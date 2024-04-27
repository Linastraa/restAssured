package homeworks.HomeWork12;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class tags {
    private Integer id;
    private String name;

    public tags(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public tags() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "tags{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

