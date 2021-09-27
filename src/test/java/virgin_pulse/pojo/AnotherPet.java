package virgin_pulse.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class AnotherPet {
    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true, value = "id", allowSetters = true)
    public class Pet {
        private long id;
        private Category petCategory;
        private String name;
        private List<photoUrls> photoUrls;
        private List<Tags> petTags;
        private String status;

        public Pet(){}
        public Pet(String petName, String categoryName, String tagsName, String photoURLs, String status){}

    }

}
