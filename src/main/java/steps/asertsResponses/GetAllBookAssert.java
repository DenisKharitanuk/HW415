package steps.asertsResponses;

import entity.Book;
import models.positive_responses.GetAllAuthorsBooksPositiveResponse;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllBookAssert {

    public static void verifyBodyGetBooks(List<GetAllAuthorsBooksPositiveResponse> allBooks, long id, String bookTitle) {
        Optional<GetAllAuthorsBooksPositiveResponse> firstResponseOptional = allBooks.stream().findFirst();
            GetAllAuthorsBooksPositiveResponse firstResponse = firstResponseOptional.get();
            Optional<Book> firstBookOptional = firstResponse.getBooks().stream().findFirst();
                Book firstBook = firstBookOptional.get();
                assertEquals(firstBook.getBookTitle(), bookTitle);
                assertEquals(firstBook.getAuthor(), id);
        }
    }

