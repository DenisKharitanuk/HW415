package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.Author;
import entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllAuthorsBooksPositiveResponse {
    private List<Book> books;
}
