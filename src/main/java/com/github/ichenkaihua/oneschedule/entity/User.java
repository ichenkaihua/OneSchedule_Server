package com.github.ichenkaihua.oneschedule.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_phone")
    private String phone;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_avatar_id")
    private Integer avatarId;

    @Column(name = "u_last_time")
    private Date lastTime;

    @Column(name = "u_create_time")
    private Date createTime;

    @Column(name = "u_state")
    private Integer state;

    /**
     * @return u_id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return u_name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return u_password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return u_phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return u_email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return u_avatar_id
     */
    public Integer getAvatarId() {
        return avatarId;
    }

    /**
     * @param avatarId
     */
    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    /**
     * @return u_last_time
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * @param lastTime
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * @return u_create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return u_state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }
}