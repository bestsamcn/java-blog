package me.best.main.models;

/**
 * @Author: Sam
 * @Date: 2018/9/23 18:18
 */
import java.sql.Timestamp;

public class Poster {
    private String id;
    private Timestamp createTime;
    private String name;
    private String path;
    private String thumbnail;

    public Poster(){
        super();
    }
    public Poster(String id, Timestamp createTime, String name, String path, String thumbnail) {
        this.id = id;
        this.createTime = createTime;
        this.name = name;
        this.path = path;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

