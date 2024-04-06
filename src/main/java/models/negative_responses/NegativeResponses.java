package models.negative_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NegativeResponses {
    private int errorCode;
    private String errorMessage;
    private String errorDetails;
}
