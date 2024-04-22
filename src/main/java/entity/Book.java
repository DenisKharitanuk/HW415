package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class Book {
    @XmlElement(name = "id", required = true)
    @JsonProperty("id")
    private  long id ;

    @XmlElement(name = "book_title", required = true)
    @JsonProperty("bookTitle")
    private String bookTitle;

    @XmlElement(name = "author", required = true)
    @JsonProperty("author")
    private Author author;
}
