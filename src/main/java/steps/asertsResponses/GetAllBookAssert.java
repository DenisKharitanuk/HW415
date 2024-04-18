package steps.asertsResponses;

import models.positive_responses.GetAllAuthorsBooksPositiveResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllBookAssert {

    public static void verifyBodyGetBooks(List<GetAllAuthorsBooksPositiveResponse> allBooks, long id, String bookTitle) {

        assertEquals (allBooks.get(0).getBooks().get(0).getBookTitle(),bookTitle);
        assertEquals(allBooks.get(0).getBooks().get(0).getAuthorId(),id);
    }
}
