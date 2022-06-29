package ru.t1.hibernate.dkononov.entities;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "author_id"))
    private Author author;

    @OneToMany(mappedBy = "book")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<BooksReaders> booksReaders = new HashSet<BooksReaders>();

    @Version
    long version;

    public Book() {
    }

    public void addReader(BooksReaders bookReader) {
        this.booksReaders.add(bookReader);
    }

    public Set<BooksReaders> getBooksReaders() {
        return booksReaders;
    }

    public void setBooksReaders(Set<BooksReaders> booksReaders) {
        this.booksReaders = booksReaders;
    }

    public Book(String title, Author author) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book: '" + getTitle() + "', " + getAuthor() + ", id_book: " + getId();
    }
}
