package models.positive_responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "authors_books")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllAuthorsBooksPositiveResponseXML {
    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book", required = true)
    List<GetAllAuthorsBooksPositiveResponse> books;
}
