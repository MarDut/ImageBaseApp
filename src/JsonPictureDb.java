import com.google.gson.*;
import java.io.*;
import java.util.stream.*;

import java.util.*;

public class JsonPictureDb implements PictureDb {

    private List<Picture> pictures;

    public JsonPictureDb(){
        pictures = new ArrayList<>();
    }

    public void add(Picture picture)
    {
        picture.setId(geterateNextId());
        pictures.add(picture);
    }

    @Override
    public void save(String filePath) throws IOException{

        Gson gson = createGson();
        FileWriter writer = new FileWriter(filePath);
        gson.toJson(this, writer);
        writer.close();
    }

    @Override
    public List<Picture> getPictures() {
        return pictures;
    }

    // zwraca liste obrazow, ktore spelniaja kryterium wyszukiwania po tagu
    @Override
    public List<Picture> getPicturesByTag(String tag) {
        return pictures.stream()
                .filter(p -> p.tagsContain(tag))
                .collect(Collectors.toList());
    }

    @Override
    public Picture getPicture(long id) {
        return pictures.stream()
                .filter(p -> p.getId() == id)
                .collect(toSingleton());
    }

    @Override
    public boolean removePicture(long id)
    {
        Picture picture = getPicture(id);

        if(picture != null)
        {
            pictures.remove(picture);
            return true;
        }
        return false;
    }

    @Override
    public List<Picture> getPicturesByPhrase(String phrase)
    {
        return pictures.stream()
                .filter(p -> (p.getId() + "").contains(phrase) ||
                        p.getPath().contains(phrase) ||
                        p.getAuthor().contains(phrase) ||
                        p.getLocation().contains(phrase) ||
                        p.getDate().toString().contains(phrase) ||
                        p.tagsContain(phrase)
                )
                .collect(Collectors.toList()); //tutaj się tworzy lista (zamień to wszytko na listę, co zostało wyfiltrowane / strumien sie zamienia na liste)
    }

    @Override
    public void sortByAuthor()
    {
        pictures.sort((p1, p2)-> p1.getAuthor().compareTo(p2.getAuthor()));
    }

    @Override
    public void sortByLocation()
    {
        pictures.sort((p1, p2)-> p1.getLocation().compareTo(p2.getLocation()));
    }

    @Override
    public void sortByDate()
    {
        pictures.sort((p1, p2)-> p1.getDate().compareTo(p2.getDate()));
    }

    @Override
    public Picture getPictureWithMinAuthorValue()
    {
        // TODO: zastanowic sie co sie stanie jezeli bedzie dwoch takich samych autorow
        return pictures.stream()
                .min((p1, p2)-> p1.getAuthor().compareTo(p2.getAuthor()))
                .orElse(null);
    }

    @Override
    public Picture getPictureWithMaxAuthorValue()
    {
        return pictures.stream()
                .max((p1, p2)-> p1.getAuthor().compareTo(p2.getAuthor()))
                .orElse(null);
    }

    @Override
    public Picture getPictureWithMinLocationValue()
    {
        return pictures.stream()
                .min((p1, p2)-> p1.getLocation().compareTo(p2.getLocation()))
                .orElse(null);
    }

    @Override
    public Picture getPictureWithMaxLocationValue()
    {
        return pictures.stream()
                .max((p1, p2)-> p1.getLocation().compareTo(p2.getLocation()))
                .orElse(null);
    }

    @Override
    public Picture getPictureWithMinDateValue()
    {
        return pictures.stream()
                .min((p1, p2)-> p1.getDate().compareTo(p2.getDate()))
                .orElse(null);
    }

    @Override
    public Picture getPictureWithMaxDateValue()
    {
        return pictures.stream()
                .max((p1, p2)-> p1.getDate().compareTo(p2.getDate()))
                .orElse(null);
    }

    @Override
    public List<Picture> getPicturesLessThanDate(Date date)
    {
        return pictures.stream()
                .filter(p -> p.getDate().before(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Picture> getPicturesGreaterThanDate(Date date) {
        return pictures.stream()
                .filter(p -> p.getDate().after(date))
                .collect(Collectors.toList());
    }

    // fabrykowanie obiektu klasy JsonPictureDb
    public static JsonPictureDb fromFile (String filePath) throws IOException{
            Gson gson = createGson();
            return gson.fromJson(new FileReader(filePath), JsonPictureDb.class);
    }
    // tworzenie obietków gson w konkretnym formacie, w razie zmiany formatu zmiana kodu w jendym miejscu
    private static Gson createGson(){
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .create();
    }
    // tworzenie metody kolektora (na wlasnych warunkach) zamiast zwracac listy, zwracmay pojedynczy obiekt lub null
    private static <T> Collector<T, ?, T> toSingleton()
    {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        return null; // zamiast wyjatku metoda zwraca null, poniewaz testuje wartosc null zamist rzucac wyjatkiem
                    }
                    return list.get(0);
                }
        );
    }

    private long geterateNextId()
    {
        return pictures.stream()
                .max(Comparator.comparing(Picture::getId))
                .map(Picture::getId)
                .orElse(0L) + 1;
    }
}
