package entity;

import lombok.Data;

@Data
public class Book {
    private  long id ;
    private String bookTitle;
    private long authorId;
}
