package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo_HomeWork12 {
    private Integer id;
    private HomeWork12_category category;
    private String name;
    private String[] photoUrls;
    private HomeWork12_tags[] tags;
    private String status;

    public JsonPlaceHolderPojo_HomeWork12(){
    }

    public JsonPlaceHolderPojo_HomeWork12(Integer id, HomeWork12_category category, String name, String[] photoUrls, HomeWork12_tags[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HomeWork12_category getCategory() {
        return category;
    }

    public void setCategory(HomeWork12_category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public HomeWork12_tags[] getTags() {
        return tags;
    }

    public void setTags(HomeWork12_tags[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo_HomeWork12{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + Arrays.toString(tags) +
                ", status='" + status + '\'' +
                '}';
    }
}
