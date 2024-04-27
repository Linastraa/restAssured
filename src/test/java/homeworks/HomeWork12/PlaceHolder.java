package homeworks.HomeWork12;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceHolder {
    private Integer id;
    private homeworks.HomeWork12.category category;
    private String name;
    private String[] photoUrls;
    private homeworks.HomeWork12.tags[] tags;
    private String status;

    public PlaceHolder(){
    }

    public PlaceHolder(Integer id, homeworks.HomeWork12.category category, String name, String[] photoUrls, homeworks.HomeWork12.tags[] tags, String status) {
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

    public homeworks.HomeWork12.category getCategory() {
        return category;
    }

    public void setCategory(homeworks.HomeWork12.category category) {
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

    public homeworks.HomeWork12.tags[] getTags() {
        return tags;
    }

    public void setTags(homeworks.HomeWork12.tags[] tags) {
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
        return "PlaceHolder{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + Arrays.toString(photoUrls) +
                ", tags=" + Arrays.toString(tags) +
                ", status='" + status + '\'' +
                '}';
    }
}
