package library.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "books", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "books_unique_name_book")})
public class Book extends AbstractNamedEntity {


    @NotBlank
    @Column(name = "author", nullable = false)
    @Size(min = 2, max = 120)
    private String author;


    @NotBlank
    @Size(min = 1, max = 3000)
    @Column(name = "date", nullable = false)
    private String date;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books") //, cascade = CascadeType.ALL
//    @CollectionTable(name = "book_user" )
//    @Column(name = "user_id")
    private Set<User> users = new HashSet<>();




    public Book() {
    }

    public Book(Integer id, String name, String author, String date) {
        super(id, name);
        this.author = author;
        this.date = date;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
