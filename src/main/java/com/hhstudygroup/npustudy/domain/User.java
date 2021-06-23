package com.hhstudygroup.npustudy.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * id: int
     * user_uuid: varchar(36)
     * user_name: varchar(255)
     * password: varchar(255)
     * real_name: varchar(255)
     * age: int
     * sex: int
     * birth_day: datetime
     * user_level: int
     * phone: varchar(255)
     * role: int
     * status: int
     * image_path: varchar(255)
     * create_time: datetime
     * modify_time: datetime
     * last_active_time: datetime
     * deleted: bit(1)
     */
    private static final long serialVersionUID = -7840648268024222111L;

    private Integer id;
    private String userUuid;
    private String userName;
    private String password;
    private String realName;
    private Integer age;
    /**
     * 0.未知 1.男 2女
     */
    private Integer sex;
    private Date birthDay;
    /**
     * 学生年级(1-4，大一 ~ 大四)
     */
    private Integer userLevel;
    private String phone;
    /**
     * 0.超级管理员 1.学生  3.管理员
     */
    private Integer role;
    /**
     * 1.启用 2禁用
     */
    private Integer status;
    /**
     * 头像地址
     */
    private String imagePath;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最近一次信息修改时间
     */
    private Date modifyTime;
    /**
     * 最近一次登录时间
     */
    private Date lastActiveTime;
    /**
     * 是否删除
     */
    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userUuid='" + userUuid + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthDay=" + birthDay +
                ", userLevel=" + userLevel +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", imagePath='" + imagePath + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", lastActiveTime=" + lastActiveTime +
                ", deleted=" + deleted +
                '}';
    }
}
