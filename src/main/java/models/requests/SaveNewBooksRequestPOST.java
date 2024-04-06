package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import entity.Author;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaveNewBooksRequestPOST {
    private String boolTitle;
    private Author author;
    private long authorId;

    private String contentType;
}
