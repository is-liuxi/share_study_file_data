package cn.hniu.pojo;

import java.util.Date;

/**
 *  打卡实体类
 */
public class Daka {
    private Integer id;
    private Date daka_date;
    private Integer userid;

    public Daka() {
    }

    public Daka(Date daka_date, Integer userid) {
        this.daka_date = daka_date;
        this.userid = userid;
    }

    public Daka(Integer id, Date daka_date, Integer userid) {
        this.id = id;
        this.daka_date = daka_date;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDaka_date() {
        return daka_date;
    }

    public void setDaka_date(Date daka_date) {
        this.daka_date = daka_date;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Daka{" +
                "id=" + id +
                ", daka_date=" + daka_date +
                ", userid=" + userid +
                '}';
    }
}
