import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.*;

public class Model extends DefaultTableModel
{
    private PictureDb db;
    private Object[][] data;

    public Model(PictureDb db)
    {
        this.db = db;
        updateData(ModelConverter.toArray2D(db.getPictures()));
    }

    public void filterByPhrase(String phrase)
    {
        List<Picture> pictures = db.getPicturesByPhrase(phrase);
        updateData(ModelConverter.toArray2D(pictures));
    }

    public void filterByTag(String phrase)
    {
        List<Picture> pictures = db.getPicturesByTag(phrase);
        updateData(ModelConverter.toArray2D(pictures));
    }

    public void sortByAuthor()
    {
        db.sortByAuthor();
        refreshData();
    }

    public void sortByLocation()
    {
        db.sortByLocation();
        refreshData();
    }

    public void sortByDate()
    {
        db.sortByDate();
        refreshData();
    }

    public void removeByIndex(int index){
        db.removePictureByIndex(index);
        refreshData();
    }

    public void showAuthorMinValue(){
        Picture picture = db.getPictureWithMinLocationValue();
        updateData(ModelConverter.toArray2D(picture));
    }

    public void showLocationMinValue(){
        Picture picture = db.getPictureWithMinLocationValue();
        updateData(ModelConverter.toArray2D(picture));

    }

    public void showAuthorMaxValue(){
        Picture picture =  db.getPictureWithMaxAuthorValue();
        updateData(ModelConverter.toArray2D(picture));
    }

    public void showDateMinValue(){
        Picture picture =  db.getPictureWithMinDateValue();
        updateData(ModelConverter.toArray2D(picture));
    }

    public void showLocationMaxValue(){
        Picture picture =  db.getPictureWithMaxLocationValue();
        updateData(ModelConverter.toArray2D(picture));
    }

    public void showDateMaxValue(){
        Picture picture =  db.getPictureWithMaxDateValue();
        updateData(ModelConverter.toArray2D(picture));
    }


    //TODO: Następne sortowania / zaczyna się od widoku -> controller (listener (obsluga zdarzeń)) -> model

    public String getPicturePath(int index)
    {
        if (data != null)
        {
            return (String) data[index][4];
        }
        return null;
    }

    public void save(String path) throws IOException {
        db.save(path);
    }

    public void open(String path) throws IOException
    {
        db = JsonPictureDb.fromFile(path);
        refreshData();
    }

    public void addPicture(Picture picture)
    {
        db.add(picture);
        refreshData();
    }

    public Picture getPictureByIndex(int index)
    {
        return db.getPictures().get(index);
    }

    public void refreshData(){
        List<Picture> pictures = db.getPictures();
        updateData(ModelConverter.toArray2D(pictures));
    }

    private void updateData(Object[][] data)
    {
        this.data = data;
        setDataVector(data, new Object[]
                {
                        "AUTHOR",
                        "LOCATION",
                        "DATE",
                        "TAGS"
                });
    }


}
