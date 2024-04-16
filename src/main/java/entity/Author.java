package entity;

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
    private final long id;

    @XmlElement(name = "first_name", required = true)
    private String firstName;

    @XmlElement(name = "family_name", required = true)
    private String familyName;

    @XmlElement(name = "second_name", required = false)
    private String secondName;
}
