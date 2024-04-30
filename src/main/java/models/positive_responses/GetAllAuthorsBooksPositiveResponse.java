package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Author;
import entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.requests.SaveNewBooksRequest;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAuthorsBooksPositiveResponse {
    @JsonProperty("bookTitle")
    private String bookTitle;

    @JsonProperty("author")
    private Author author;
}
