package cn.hniu.pojo;

public class Groupinfo {
    private Integer id;
    private String name;

    public Groupinfo() {
    }

    public Groupinfo(String name) {
        this.name = name;
    }

    public Groupinfo(Integer id, String name) {
        this.id = id;
        this.name = name;
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
        return "Groupinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
