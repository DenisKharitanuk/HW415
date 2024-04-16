package entity;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
public class Book {
    @XmlElement(name = "id", required = true)
    private  long id ;

    @XmlElement(name = "book_title", required = true)
    private String bookTitle;

    @XmlElement(name = "author_id", required = true)
    private long authorId;
}
