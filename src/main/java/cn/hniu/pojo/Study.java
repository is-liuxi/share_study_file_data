package cn.hniu.pojo;

public class Study {
    private Integer id;
    private String imgPath;
    private String title;
    private String content;
    private String url;

    public Study(Integer id, String imgPath, String title, String content, String url) {
        this.id = id;
        this.imgPath = imgPath;
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public Study(String imgPath, String title, String content, String url) {
        this.imgPath = imgPath;
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", imgPath='" + imgPath + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
