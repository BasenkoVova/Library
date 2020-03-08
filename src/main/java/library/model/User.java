package library.model;

import org.hibernate.annotations.BatchSize;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
public class User extends AbstractNamedEntity {


    @Column(name = "email", nullable = false, unique = true)
    @Email
    @Size(max = 100)
    private String email;


    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;


//    @Column(name = "password", nullable = false)
//    @NotBlank
//    @Size(min = 5, max = 100)
//    private String password;
//
//    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
//    private boolean enabled = true;
//
//    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
//    @NotNull
//    private Date registered = new Date();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();



    public User() {
    }


    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getRoles());
    }

    public User(Integer id, String name, String email, Role role, Role... roles) {
        this(id, name, email, EnumSet.of(role, roles));
    }


    public User(Integer id, String name, String email, Collection<Role> roles) {
        super(id, name);
        this.email = email;
        setRoles(roles);
    }


    public User(Integer id, String name, String email, Set<Role> roles, Set<Book> books) {
        this(id, name, email, roles);
        this.books = books;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        if (this.books.isEmpty())
            this.books = new HashSet<Book>();
        this.books.add(book);
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
        Set<Role> s = roles.stream()
                .filter(r -> !this.roles.contains(r))
                .collect(Collectors.toSet());
        if (this.roles == null)
            this.roles = new HashSet<Role>(roles);
        else {
            for (Role r : roles) {
                this.roles.add(r);
            }
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                ", roles=" + roles +
                '}';
    }


}
