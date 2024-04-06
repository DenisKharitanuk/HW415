package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.Author;
import entity.Book;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllAuthorsBooksPositiveResponseXMLPOST {
    private Map<Author,List<Book>> authorsBooks;
    private List<Book> books;
    private Book book;
    private long bookID;
    private String bookTitle;
    private Author author;
    private long authorID;
    private String firstName;
    private String secondName;
    private String familyName;
}
