public class Main {

    public static void main(String [] args) throws Exception{

        Model model = new Model(JsonPictureDb.fromFile("Pictures.json"));
        View view = new View(model);
        Controller controller = new Controller(view);

        view.show(controller);
    }
}
