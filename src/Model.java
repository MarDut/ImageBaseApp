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

    public void removeByIndex(int index){
        db.removePictureByIndex(index);
        refreshData();
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

    private void refreshData(){
        List<Picture> pictures = db.getPictures();
        updateData(ModelConverter.toArray2D(pictures));
    }
}
