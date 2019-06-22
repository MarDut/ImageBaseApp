import java.io.IOException;
import java.util.*;

public interface PictureDb  {
/*
- wczytanie bazy obrazów z pliku o nazwie podanej przez użytkownika
ok zapis bazy obrazów do pliku o nazwie podanej przez użytkownika
ok wyświetlenie listy wszystkich obrazów
ok wyświetlenie listy obrazów w których opisie podany został wybrany tag
ok wyświetlenie pojedynczego obrazu, wybranego z bazy - dodanie obrazu do bazy
ok edycję parametrów dowolnego obrazu z bazy // poprzez gettery i settery
ok usunięcie obrazu z bazy
ok wyszukiwanie obrazów na podstawie wartości dowolnego z parametrów
ok sortowanie obrazów w katalogu na podstawie wybranej wartości dowolnego z parametrów, z wyjątkiem ścieżki i tagów
ok wyszukiwanie i wyświetlenie parametrów obrazu o najmniejszej wartości dowolnego z parametrów, z wyjątkiem ścieżki i tagów
ok wyszukiwanie i wyświetlenie parametrów obrazu o największej wartości dowolnego z parametrów, z wyjątkiem ścieżki i tagów
ok wyszukiwanie obrazów dla których data jest mniejsza od progu podanego przez użytkownika
ok wyszukiwanie obrazów dla których data jest większa od progu podanego przez użytkownika
*/
    void save(String filePath) throws IOException;
    List<Picture> getPictures();
    List<Picture> getPicturesByTag(String tag);
    Picture getPicture(long id);
    boolean removePictureByIndex(int index);
    List<Picture> getPicturesByPhrase(String phrase);
    void sortByAuthor();
    void sortByLocation();
    void sortByDate();
    Picture getPictureWithMinAuthorValue();
    Picture getPictureWithMaxAuthorValue();
    Picture getPictureWithMinLocationValue();
    Picture getPictureWithMaxLocationValue();
    Picture getPictureWithMinDateValue();
    Picture getPictureWithMaxDateValue();
    List<Picture> getPicturesLessThanDate(Date date);
    List<Picture> getPicturesGreaterThanDate(Date date);
    void add(Picture picture);

}

