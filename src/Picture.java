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
    private BufferedImage image;

    public Picture() {

    }

    public Picture(long id, String path, String author, String location, Date date, List<String> tags, BufferedImage image) {
        this.id = id;
        this.path = path;
        this.author = author;
        this.location = location;
        this.date = date;
        this.tags = tags;
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}