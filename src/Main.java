public class Main {

    public static void main(String [] args) throws Exception{

        JsonPictureDb db = JsonPictureDb.fromFile("Pictures.json");
        db.save("Test.json");




    }
}
