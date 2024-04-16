package steps.asertsResponses;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

public class GetAllBookAssert {

    public static void verifyBodyGetBooks(ValidatableResponse allBooks, long id, String bookTitle) {
        allBooks.assertThat()
                .body("find{it.bookTitle=='" + bookTitle + "'}.bookTitle", equalTo(bookTitle))
                .body("author.find{it.id==" + id + "}.id", equalTo((int) id));
    }
}
