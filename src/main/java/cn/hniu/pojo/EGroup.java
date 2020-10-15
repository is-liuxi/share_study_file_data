package cn.hniu.pojo;

import java.util.List;

public class EGroup {
    private Integer id;
    private String name;
    private List<English> english;

    public EGroup() {
    }

    public EGroup(String name, List<English> english) {
        this.name = name;
        this.english = english;
    }

    public EGroup(Integer id, String name, List<English> english) {
        this.id = id;
        this.name = name;
        this.english = english;
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

    public List<English> getEnglish() {
        return english;
    }

    public void setEnglish(List<English> english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "EGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", english=" + english +
                '}';
    }
}
