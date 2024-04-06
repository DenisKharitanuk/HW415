package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllAuthorsBooksRequestGET {
    private String id;
    private String contentType;
}
