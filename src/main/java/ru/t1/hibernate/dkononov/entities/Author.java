package ru.t1.hibernate.dkononov.entities;


import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author",
        indexes = @Index(name = "fio", columnList = "firstName,lastName", unique = true))
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
    @OneToMany(mappedBy = "author")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Book> book;

    @JoinColumn
    private int book_id;

    @Version
    long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        String allBooks = "";
        for (Book o : book) {
            allBooks += o.getTitle() + " ";
        }
        return "Author - [Id:" + id + ", " + lastName + ",Books : '" + allBooks + "']";
    }
}
