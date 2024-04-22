package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "author")
public class Author {

    @XmlElement(name = "id", required = true)
    @JsonProperty("id")
    private final long id;

    @XmlElement(name = "first_name", required = true)
    @JsonProperty("firstName")
    private String firstName;

    @XmlElement(name = "family_name", required = true)
    @JsonProperty("familyName")
    private String familyName;

    @XmlElement(name = "second_name", required = false)
    @JsonProperty("secondName")
    private String secondName;
}
