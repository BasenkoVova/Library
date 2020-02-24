package library;

import library.model.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static library.model.AbstractBaseEntity.START_SEQ;

public class TestDateBook {

    public static final int USER_BOOK_ID_1 = START_SEQ + 2;
    public static final int USER_BOOK_ID_2 = START_SEQ + 3;
    public static final int ADMIN_BOOK_ID = START_SEQ + 4;

    public static final Book BOOK1 = new Book(USER_BOOK_ID_1, "Монах, що продав свій феррарі", "Робін Шарма", "2015",100);
    public static final Book BOOK2 = new Book(USER_BOOK_ID_2, "Найбагатша людина у Вавилоні", "Джордж Клейсон", "2017",120);
    public static final Book BOOK3 = new Book(ADMIN_BOOK_ID, "Стратегії геніїв", "Девід Йоффе, Майкл Кузумано", "2017",110);



    public static void assertMatch(Book actual, Book expected) {
//        assertThat(actual).isEqualToComparingOnlyGivenFields(expected, "id", "name", "email");
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "users");
    }

    public static void assertMatch(Iterable<Book> actual, Book... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Book> actual, Iterable<Book> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("users").isEqualTo(expected);
    }



}
