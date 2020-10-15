package cn.hniu.pojo;

import java.util.Date;

public class Politics {
    private Integer id;
    private String title;
    private String content;
    private String filePath;
    private Integer status;
    private Date createDate;
    private String name;

    @Override
    public String toString() {
        return "Politics{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", filePath='" + filePath + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Politics(Integer id, String title, String content, String filePath, Integer status, Date createDate, String name) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.status = status;
        this.createDate = createDate;
        this.name = name;
    }

    public Politics() {
    }

    public Politics(String title, String content, String filePath) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
    }

    public Politics(String title, String content, String filePath, String name) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.name = name;
    }

    public Politics(String title, String content, String filePath, Integer status, Date createDate) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.status = status;
        this.createDate = createDate;
    }

    public Politics(Integer id, String title, String content, String filePath, Integer status, Date createDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.status = status;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
