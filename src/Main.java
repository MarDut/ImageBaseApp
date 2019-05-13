public class Main {

    public static void main(String [] args) throws Exception{

       // JsonPictureDb db = JsonPictureDb.fromFile("Pictures.json");
        JsonPictureDb db = new JsonPictureDb();
        db.add(new Picture());
        db.save("Test.json");


    }
}
