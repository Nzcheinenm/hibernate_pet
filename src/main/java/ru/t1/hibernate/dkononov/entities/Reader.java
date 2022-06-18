package ru.t1.hibernate.dkononov.entities;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "books_readers",
            joinColumns = {@JoinColumn(name = "reader_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "reader_id"))},
            inverseJoinColumns = {@JoinColumn(name = "book_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "book_id"))})
    private List<Book> books;

    public Reader() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
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


    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getBooks().size();
    }
}
