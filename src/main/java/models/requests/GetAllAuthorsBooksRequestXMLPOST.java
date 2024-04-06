package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import entity.Author;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllAuthorsBooksRequestXMLPOST {
    private Author author;
    private int id;
    private String header;
}
