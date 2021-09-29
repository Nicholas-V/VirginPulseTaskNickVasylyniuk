package virgin_pulse.pojo;

import lombok.*;

@Getter
@Setter
@ToString
public class Category {

    public Category(String name){
        this.name = name;
    }

    private long id;
    private String name;

}
