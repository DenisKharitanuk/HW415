package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import entity.Author;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllAuthorsBooksRequestXML {
    private Author author;
}
