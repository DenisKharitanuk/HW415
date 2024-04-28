package steps.asertsResponses;

import entity.Author;
import entity.Book;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;
import models.positive_responses.GetAllAuthorsBooksPositiveResponseXML;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllBookAssertXML {
    public static void verifyBodyGetBooksXML(GetAllAuthorsBooksPositiveResponseXML allBooks, String bookTitle, Author author) {

//        Optional<GetAllAuthorsBooksPositiveResponse> firstBookOptional = allBooks.getBooks().stream().findFirst();

//        Book firstBook = firstBookOptional.get().getBookTitle();
        assertEquals(allBooks.getBooks().get(0).getBookTitle(), bookTitle);
        assertEquals(allBooks.getBooks().get(0).getAuthor(), author);
    }
}
