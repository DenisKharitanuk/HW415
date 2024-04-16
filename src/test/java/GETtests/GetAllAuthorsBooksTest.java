package GETtests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;
import models.positive_responses.SaveNewAuthorPositiveResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Specifications;
import steps.asertsResponses.GetAllBookAssert;

@Epic("GetTests")
@Story("getAllBooks")
public class GetAllAuthorsBooksTest {

    @DisplayName("Get all authors books")
    @Description("A list of all books by the author corresponding " +
            "to the entered id is returned, the list contains the created book, status code 200")
    @ParameterizedTest(name = "id = {0}")
    @ValueSource(longs = {10})
    public void getAllAuthorsBooksTest() {
        SaveNewAuthorPositiveResponse author = Specifications.requestSpecSaveNewAuthor(RandomStringUtils.randomAlphabetic(5),
                RandomStringUtils.randomAlphabetic(5), RandomStringUtils.randomAlphabetic(5), 200);

        long id = author.getAuthorId();

        String bookTitle = "Flugegihaimer";
        Specifications.requestSpecSaveNewBook("Flugegihaimer", id , 200);

        GetAllAuthorsBooksPositiveResponse allBooks = (GetAllAuthorsBooksPositiveResponse) Specifications.requestSpecGetAllBooksJSON(String.valueOf(id), 200);

        GetAllBookAssert.verifyBodyGetBooks((ValidatableResponse) allBooks, id, bookTitle);
    }

}
