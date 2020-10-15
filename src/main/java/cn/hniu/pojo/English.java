package cn.hniu.pojo;

import java.util.Date;

public class English {
    private Integer id;
    private String title;
    private String content;
    private String filePath;
    private Integer status;
    private Date createDate;
    private Integer groupId;
    private String name;

    @Override
    public String toString() {
        return "English{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", filePath='" + filePath + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", groupId=" + groupId +
                ", name='" + name + '\'' +
                '}';
    }

    public English(Integer id, String title, String content, String filePath, Integer status, Date createDate, Integer groupId, String name) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.status = status;
        this.createDate = createDate;
        this.groupId = groupId;
        this.name = name;
    }

    public English() {
    }

    public English(String title, String content, String filePath, Integer groupId) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.groupId = groupId;
    }

    public English(String title, String content, String filePath, Integer groupId, String name) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.groupId = groupId;
        this.name = name;
    }

    public English(String title, String content, String filePath, Integer status, Date createDate, Integer groupId) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.status = status;
        this.createDate = createDate;
        this.groupId = groupId;
    }

    public English(Integer id, String title, String content, String filePath, Integer status, Date createDate, Integer groupId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.status = status;
        this.createDate = createDate;
        this.groupId = groupId;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
