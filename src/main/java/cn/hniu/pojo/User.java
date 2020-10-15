package cn.hniu.pojo;

import java.util.Date;

/**
 *  实体类，用户数据
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String mobile;
    private String gender;
    private String email;
    private Date createDate;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String mobile, String gender, String email, Date createDate) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.gender = gender;
        this.email = email;
        this.createDate = createDate;
    }

    public User(Integer id, String username, String password, String mobile, String gender, String email, Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.gender = gender;
        this.email = email;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
