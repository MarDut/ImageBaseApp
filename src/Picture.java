import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Picture {

    private long id;



    private String path;
    private String author;
    private String location;
    private Date date;
    private List<String> tags;


    public Picture()
    {

    }

    public Picture(String path, String author, String location, Date date, List<String> tags)
    {
        this.path = path;
        this.author = author;
        this.location = location;
        this.date = date;
        this.tags = tags;
    }


    public void setId(long id) {
        this.id = id;
    }

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

    public void setDate(String date) throws ParseException
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        this.date = s.parse(date);
    }

    public List<String> getTags() {
        return tags;
    }


    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setTags(String tags) {
        String[] array = tags.split(", ");
        setTags(Arrays.asList(array));
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

    public Object[] toVector()
    {
        return new Object[] {author, location, date, String.join(", ", tags), path};
    }

}