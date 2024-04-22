package steps.asertsResponses;

import entity.Book;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllBookAssert {

    public static void verifyBodyGetBooks(List<GetAllAuthorsBooksPositiveResponse> allBooks, long id, String bookTitle) {
        Optional<GetAllAuthorsBooksPositiveResponse> firstResponseOptional = allBooks.stream().findFirst();

        if (firstResponseOptional.isPresent()) {
            GetAllAuthorsBooksPositiveResponse firstResponse = firstResponseOptional.get();
            Optional<Book> firstBookOptional = firstResponse.getBooks().stream().findFirst();

            if (firstBookOptional.isPresent()) {
                Book firstBook = firstBookOptional.get();
                assertEquals(firstBook.getBookTitle(), bookTitle);
                assertEquals(firstBook.getAuthor(), id);
            } else {
                throw new AssertionError("No books found in the response.");
            }
        } else {
            throw new AssertionError("No response found.");
        }
    }
}
