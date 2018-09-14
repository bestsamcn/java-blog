package me.best.main.models;

import java.sql.Timestamp;


/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class Tag {
    private String id;
    private String name;
    private Integer clickNum;
    private Timestamp createTime;
    public String getId(){
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getClickNum() {
        return clickNum;
    }
    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }
    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public Tag(){
        super();
    }
    public Tag(String id, String name, Integer clickNum, Timestamp createTime){
        this.id = id;
        this.name = name;
        this.clickNum = clickNum;
        this.createTime = createTime;
    }
}
