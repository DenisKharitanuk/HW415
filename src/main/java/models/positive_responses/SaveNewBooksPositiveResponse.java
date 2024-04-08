package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveNewBooksPositiveResponse {
    private long bookId;
}
