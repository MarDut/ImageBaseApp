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
        Object[][] tab = new Object[1][1];
        tab[0] = picture.toVector();
        return tab;
    }
}
