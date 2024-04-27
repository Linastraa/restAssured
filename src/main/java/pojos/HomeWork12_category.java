package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeWork12_category {
    private Integer id;
    private String name;

    public HomeWork12_category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public HomeWork12_category() {
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
        return "HomeWork12_category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
