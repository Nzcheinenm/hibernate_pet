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

    @OneToMany(mappedBy = "reader")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<BooksReaders> booksReaders;

    @JoinColumn
    String book_id;

//    @OneToMany
//    @JoinTable(name = "books_readers",
//            joinColumns = {@JoinColumn(name = "reader_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "reader_id"))})
//    private List<BooksReaders> booksReaders;

    public Reader() {
    }

    public List<BooksReaders> getBooksReaders() {
        return booksReaders;
    }

    public void setBooksReaders(List<BooksReaders> booksReaders) {
        this.booksReaders = booksReaders;
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
        return getFirstName() + " " + getLastName() + " " + booksReaders.size();
    }
}
