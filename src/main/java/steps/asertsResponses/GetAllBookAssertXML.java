package steps.asertsResponses;

import models.positive_responses.GetAllAuthorsBooksPositiveResponseXML;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllBookAssertXML {
    public static void verifyBodyGetBooksXML(GetAllAuthorsBooksPositiveResponseXML allBooks, long id, String bookTitle) {
        assertEquals (allBooks.getBooks().get(0).getBooks().get(0).getBookTitle(),bookTitle);
        assertEquals(allBooks.getBooks().get(0).getBooks().get(0).getId(),id);
    }
}
