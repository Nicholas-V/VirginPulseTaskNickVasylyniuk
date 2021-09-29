package virgin_pulse.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true, value = "id", allowSetters = true)

public class NewPet {

    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;

    public NewPet(String categoryName, String petName, String photoUrlsString, String tagsName, String statusString) {

        this.category = new Category(categoryName);
        this.name = petName;
        photoUrls = new ArrayList<>(Arrays.asList(photoUrlsString));
        Tags tagObject = new Tags(tagsName);
        this.tags = new ArrayList<>(Arrays.asList(tagObject));
        this.status = statusString;
    }

}
