package ru.t1.hibernate.dkononov.entities;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @OneToMany(mappedBy = "reader")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<BooksReaders> booksReaders = new HashSet<BooksReaders>();

    @Version
    long version;


    public Reader() {
    }

    public void addBook(BooksReaders bookReader) {
        this.booksReaders.add(bookReader);
    }

    public Set<BooksReaders> getBooksReaders() {
        return booksReaders;
    }

    public void setBooksReaders(Set<BooksReaders> booksReaders) {
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
