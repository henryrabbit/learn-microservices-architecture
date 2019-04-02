package icpc.njust.learn.microservices.architecture.book.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Book {
    private String id;
    private String bookname;
    private String isbn;
    private String edition;
    private String booksize;
    private String publicationtime;
    private String wordcount;
    private String language;
    private int number;
    private int lent;
    private String author;
    private String publish;

    public Book() {
    }

    public Book(String id, String bookname, String isbn, String edition, String booksize, String publicationtime, String wordcount, String language, int number, int lent, String author, String publish) {
        this.id = id;
        this.bookname = bookname;
        this.isbn = isbn;
        this.edition = edition;
        this.booksize = booksize;
        this.publicationtime = publicationtime;
        this.wordcount = wordcount;
        this.language = language;
        this.number = number;
        this.lent = lent;
        this.author = author;
        this.publish = publish;
    }


    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bookname")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "edition")
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Basic
    @Column(name = "booksize")
    public String getBooksize() {
        return booksize;
    }

    public void setBooksize(String booksize) {
        this.booksize = booksize;
    }

    @Basic
    @Column(name = "publicationtime")
    public String getPublicationtime() {
        return publicationtime;
    }

    public void setPublicationtime(String publicationtime) {
        this.publicationtime = publicationtime;
    }

    @Basic
    @Column(name = "wordcount")
    public String getWordcount() {
        return wordcount;
    }

    public void setWordcount(String wordcount) {
        this.wordcount = wordcount;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "lent")
    public int getLent() {
        return lent;
    }

    public void setLent(int lent) {
        this.lent = lent;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "publish")
    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                number == book.number &&
                lent == book.lent &&
                Objects.equals(bookname, book.bookname) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(edition, book.edition) &&
                Objects.equals(booksize, book.booksize) &&
                Objects.equals(publicationtime, book.publicationtime) &&
                Objects.equals(wordcount, book.wordcount) &&
                Objects.equals(language, book.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookname, isbn, edition, booksize, publicationtime, wordcount, language, number, lent);
    }


    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", bookname='" + bookname + '\'' +
                ", isbn='" + isbn + '\'' +
                ", edition='" + edition + '\'' +
                ", booksize='" + booksize + '\'' +
                ", publicationtime='" + publicationtime + '\'' +
                ", wordcount='" + wordcount + '\'' +
                ", language='" + language + '\'' +
                ", number=" + number +
                ", lent=" + lent +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                '}';
    }
}
