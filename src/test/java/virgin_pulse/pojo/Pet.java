package virgin_pulse.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Pet {
    private long id;
    private Category petCategory;
    private String name;
    private String photoUrl;
    private Tags petTag;
    private String status;
}
