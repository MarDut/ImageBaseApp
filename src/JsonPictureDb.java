import com.google.gson.*;
import java.io.*;

import java.util.*;

public class JsonPictureDb implements PictureDb {

    private List<Picture> pictures;

    public JsonPictureDb(){
        pictures = new ArrayList<>();
    }

    public void add(Picture picture){
        pictures.add(picture);
    }

    @Override
    public void save(String filePath) throws IOException{

        Gson gson = new Gson();
        gson.toJson(this, new FileWriter(filePath));
    }

    @Override
    public List<Picture> getPictures() {
        return null;
    }

    @Override
    public List<Picture> getPicturesByTag(String tag) {
        return null;
    }

    @Override
    public Picture getPicture(long id) {
        return null;
    }

    @Override
    public boolean removePicture(long id) {
        return false;
    }

    @Override
    public List<Picture> getPicturesByPhrase(String phrase) {
        return null;
    }

    @Override
    public void sortByAuthor() {

    }

    @Override
    public void sortByLocation() {

    }

    @Override
    public void sortByDate() {

    }

    @Override
    public Picture getPictureWithMinAuthorValue() {
        return null;
    }

    @Override
    public Picture getPictureWithMaxAuthorValue() {
        return null;
    }

    @Override
    public Picture getPictureWithMinLocationValue() {
        return null;
    }

    @Override
    public Picture getPictureWithMaxLocationValue() {
        return null;
    }

    @Override
    public Picture getPictureWithMinDateValue() {
        return null;
    }

    @Override
    public Picture getPictureWithMaxDateValue() {
        return null;
    }

    @Override
    public List<Picture> getPicturesLessThanDate(Date date) {
        return null;
    }

    @Override
    public List<Picture> getPicturesGreaterThanDate(Date date) {
        return null;
    }

    // fabrykowanie obiektu klasy JsonPictureDb
    public static JsonPictureDb fromFile (String filePath) throws IOException{
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(filePath), JsonPictureDb.class);
    }
}
