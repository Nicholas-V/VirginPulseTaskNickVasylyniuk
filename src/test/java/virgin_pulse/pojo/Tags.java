package virgin_pulse.pojo;

import lombok.*;

@Getter
@Setter
@ToString

public class Tags {
    private long id;
    private String name;

    public Tags(String name){
        this.setName(name);
    }

}
