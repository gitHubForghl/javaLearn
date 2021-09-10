package cn.ghl.run.base.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author tui
 */
public class Person{

    private String name;
    private Integer id;
    @JsonCreator
    public Person(@JsonProperty("name") String name,@JsonProperty("id") Integer id) {
        this.name = name;
        this.id=id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
