package steps.asertsResponses;

import entity.Book;
import models.positive_responses.GetAllAuthorsBooksPositiveResponseXML;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

public class GetAllBookAssertXML {
    public static void verifyBodyGetBooksXML(GetAllAuthorsBooksPositiveResponseXML allBooks, long id, String bookTitle) {
        Optional<Book> firstBookOptional = allBooks.getBooks().getBooks().stream().findFirst();

        Book firstBook = firstBookOptional.get();
        assertEquals(firstBook.getBookTitle(), bookTitle);
        assertEquals(firstBook.getId(), id);
    }
}
