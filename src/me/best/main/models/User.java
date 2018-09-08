package me.best.main.models;

import java.sql.Timestamp;

public class User {
    private String id;
    private String account;
    private String password;
    private String avatar;
    private String email;
    private String mobile;
    private Timestamp createTime;
    private String createIp;
    private Timestamp lastUpateTime;
    private Timestamp lastLoginTime;
    private String userType;
    private Timestamp setAdminTime;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setAccount(String account){
        this.account = account;
    }
    public String getAccount(){
        return this.account;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatar(){
        return this.avatar;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return this.mobile;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }
    public Timestamp getCreateTime(){
        return this.createTime;
    }
    public void setCreateIp(String createIp){
        this.createIp = createIp;
    }
    public String getCreateIp(){
        return this.createIp;
    }
    public void setLastUpateTime(Timestamp lastUpateTime){
        this.lastUpateTime = lastUpateTime;
    }
    public Timestamp getLastUpdateTime(){
        return this.lastUpateTime;
    }
    public void setLastLoginTime(Timestamp lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    public Timestamp getLastLoginTime(){
        return this.lastLoginTime;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getUserType(){
        return this.userType;
    }
    public void setSetAdminTime(Timestamp setAdminTime){
        this.setAdminTime = setAdminTime;
    }
    public Timestamp getSetAdminTime(){
        return this.setAdminTime;
    }
    public User(){
        super();
    }
    public User(String id, String account, String password, String avatar, String email, String mobile, Timestamp creatTime, String createIp, Timestamp lastLoginTime, Timestamp lastUpateTime, String userType, Timestamp setAdminTime ){
        super();
        this.id = id;
        this.account = account;
        this.password = password;
        this.avatar = avatar;
        this.email = email;
        this.mobile = mobile;
        this.createTime = createTime;
        this.createIp = createIp;
        this.lastLoginTime = lastLoginTime;
        this.lastUpateTime = lastUpateTime;
        this.userType = userType;
        this.setAdminTime = setAdminTime;
    }

}
