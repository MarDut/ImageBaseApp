import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

public class Picture {

    private long id;
    private String path;
    private String author;
    private String location;
    private Date date;
    private List<String> tags;
    private transient BufferedImage image;
    //private static long currentId = 1;


    public Picture(String path, String author, String location, Date date, List<String> tags, BufferedImage image) {
        this.path = path;
        this.author = author;
        this.location = location;
        this.date = date;
        this.tags = tags;
        this.image = image;
    //    updateId();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    // bez settera ID, ponieważ nie dajmemy możliwości go edytowania ,sami generujemy jego wartość
    public long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean tagsContain(String phrase){
        for (String tag : getTags())
        {
            if(tag.contains(phrase)) {
                return true;
            }
        }
        return false;
    }

//    private void updateId(){
//        currentId = id + 1;
//    }
}