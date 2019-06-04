import javax.swing.table.DefaultTableModel;
import java.util.*;

public class Model extends DefaultTableModel
{
    private PictureDb db;

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

    private void updateData(Object[][] data)
    {
        setDataVector(data, new Object[]
                {
                        "AUTHOR",
                        "LOCATION",
                        "DATE",
                        "TAGS"
                });
    }
}
