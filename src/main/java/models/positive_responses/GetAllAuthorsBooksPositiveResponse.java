package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.Author;
import entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.requests.SaveNewBooksRequest;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllAuthorsBooksPositiveResponse {

//    private Book books;
//    private SaveNewAuthorPositiveResponse author;
//

    private Book bookTitle;
    private Author author;
}
