package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.Author;
import entity.Book;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllAuthorsBooksPositiveResponseXML {
    private Map<Author, List<Book>> authorsBooks;
    private List<Book> books;
    private Author author;
    private Book book;
}
