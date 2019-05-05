# ImageBaseApp

Pierwszy projekt powinien zostać oddany w czasie zjazdu odbywającego się 11-12 maja 2019 roku. Opóźnienie o każdy zjazd spowoduje odjęcie 10% od maksymalnej, możliwej do zdobycia liczby punktów. Projekt jest oceniany w skali od 0 do 10 punktów. Projekt należy oddać osobiście i nie zostanie on oceniony jeżeli student nie obroni go przed prowadzącym. Kluczowy wpływ na uzyskaną liczbę punktów mają odpowiedzi na pytania prowadzącego w czasie obrony projektu. Wstępna, niekoniecznie działająca wersja projektu powinna zostać dostarczona prowadzącemu napóźniej w środę przed zjazdem na którym zostanie oddany projekt (np. drogą mailową lub poprzez link do repozytorium). Wstępna wersja ma umożliwić prowadzącemu zapoznanie się z ogólną ideą i kodem źródłowym, co następnie przyspieszy i ułatwi ocenę projektu w czasie zajęć. Projekt powinien zostać zrealizowany w technologii Swing.

W ramach projektu należy utworzyć aplikację z graficznym interfejsem użytkownika, obsługującą bazę obrazów. Baza obrazów jest rozumiana jako lista obrazów (nie np. baza relacyjna) i powinna być przechowywana w postaci pliku tekstowego o dowolnym formacie. Każdy z obrazów powinien być opisany przy pomocy następujących parametrów: 
- ścieżka (położenie na dysku)
- autor (np. Ala Kowalska)
- lokalizacja (miejsce np. Wenecja, Zakopane)
- data
- tagi (w postaci listy np. rodzinne, wakacje, krajobrazy itp.)

Należy przyjąć, że poszczególne parametry mogą być pozbawione wartości dla danego obrazu, z wyjątkiem ścieżki. Graficzny interfejs użytkownika powinien umożliwiać:
- wczytanie bazy obrazów z pliku o nazwie podanej przez użytkownika
- zapis bazy obrazów do pliku o nazwie podanej przez użytkownika
- wyświetlenie listy wszystkich obrazów
- wyświetlenie listy obrazów w których opisie podany został wybrany tag
- wyświetlenie pojedynczego obrazu, wybranego z bazy - dodanie obrazu do bazy
- edycję parametrów dowolnego obrazu z bazy
- usunięcie obrazu z bazy
- wyszukiwanie obrazów na podstawie wartości dowolnego z parametrów
- sortowanie obrazów w katalogu na podstawie wybranej wartości dowolnego z parametrów, z wyjątkiem ścieżki i tagów
- wyszukiwanie i wyświetlenie parametrów obrazu o najmniejszej wartości dowolnego z parametrów, z wyjątkiem ścieżki i tagów
- wyszukiwanie i wyświetlenie parametrów obrazu o największej wartości dowolnego z parametrów, z wyjątkiem ścieżki i tagów
- wyszukiwanie obrazów dla których data jest mniejsza od progu podanego przez użytkownika
- wyszukiwanie obrazów dla których data jest większa od progu podanego przez użytkownika

Aplikacja powinna być zabezpieczona przed błędami użytkownika czy innymi problemami (np. nieprawidłowy format pliku z katalogiem przy wczytywaniu, próba podania daty czy oceny w nieprawidłowym formacie itp.). Zabezpieczenia powinny przede wszystkim obejmować poprawną obsługę wszystkich występujących wyjątków. Kod powinien być prawidłowo sformatowany, a nazwy zmiennych i metod powinny być w języku angielskim i opisywać ich funkcjonalność.
