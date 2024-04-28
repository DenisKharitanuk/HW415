package steps.asertsResponses;

import entity.Book;
import io.restassured.response.ValidatableResponse;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllBookAssert {
    public static void verifyBodyGetBooks(ValidatableResponse allBooks, long id, String bookTitle) {
        allBooks.assertThat()
                .body("find{it.bookTitle=='" + bookTitle + "'}.bookTitle", equalTo(bookTitle))
                .body("author.find{it.id==" + id + "}.id", equalTo((int) id));
    }
}


