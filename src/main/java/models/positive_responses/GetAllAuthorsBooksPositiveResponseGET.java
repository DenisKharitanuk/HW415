package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.Author;
import entity.Book;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllAuthorsBooksPositiveResponseGET {
    private List<Book> books;
    private Book book;
    private long bookId;
    private String bookTitle;

    private Author author;
    private long authorId;
    private String firstName;
    private String secondName;
    private String familyName;
}
