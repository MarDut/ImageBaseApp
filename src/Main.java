import org.json.JSONObject;
import org.json.JSONArray;

public class Main {

    public static void main(String [] args){

        JSONObject object = new JSONObject();

        object.put("path","tmp");
        object.put("author","Jan Kowalski");
        object.put("location","Warsaw");
        object.put("date","2009-12-31");

        JSONArray tagList = new JSONArray();

        tagList.put("family");
        tagList.put("landscape");
        tagList.put("holidays");
        tagList.put("selfie");

        object.put("tags",tagList);

        System.out.println(object);

        System.out.println("Test");

    }
}
