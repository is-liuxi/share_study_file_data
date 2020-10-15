package cn.hniu.pojo;

import java.util.List;

public class HNGroup {
    private Integer id;
    private String name;
    private List<HighNumber> highNumber;

    public HNGroup() {
    }

    public HNGroup(String name, List<HighNumber> highNumber) {
        this.name = name;
        this.highNumber = highNumber;
    }

    public HNGroup(Integer id, String name, List<HighNumber> highNumber) {
        this.id = id;
        this.name = name;
        this.highNumber = highNumber;
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

    public List<HighNumber> getHighNumber() {
        return highNumber;
    }

    public void setHighNumber(List<HighNumber> highNumber) {
        this.highNumber = highNumber;
    }

    @Override
    public String toString() {
        return "HNGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", highNumber=" + highNumber +
                '}';
    }
}
