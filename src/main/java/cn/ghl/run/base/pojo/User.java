package cn.ghl.run.base.pojo;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author tui
 */
public class User implements Serializable {
    @NotBlank(message = "不能是空")
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
