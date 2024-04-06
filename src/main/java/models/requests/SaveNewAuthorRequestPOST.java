package models.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaveNewAuthorRequestPOST {
    private String firstName;
    private String familyName;
    private String secondName;
    private String contentTypeName;
}
