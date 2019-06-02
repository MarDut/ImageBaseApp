import java.util.*;

public class ModelConverter {
    public static Object[][] toArray2D(List<Picture> pictures)
    {
       Object[][] result = new Object[pictures.size()][];
       for (int i=0 ; i<pictures.size() ; i++)
       {
           result[i] = pictures.get(i).toVector();
       }
       return result;
    }

    public static Object[][] toArray2D(Picture picture)
    {
        return new Object[][]{{picture.toVector()}};
    }
}
