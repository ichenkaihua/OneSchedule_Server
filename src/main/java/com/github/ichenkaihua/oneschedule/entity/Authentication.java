package com.github.ichenkaihua.oneschedule.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "authentication")
public class Authentication {
    @Id
    @Column(name = "ac_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ac_user_id")
    private Integer userId;

    @Column(name = "ac_create_time")
    private Date createTime;

    @Column(name = "ac_md5_value")
    private String md5Value;

    @Column(name = "ac_update_time")
    private Date updateTime;

    @Column(name = "ac_expire_time")
    private Date expireTime;

    /**
     * @return ac_id
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
     * @return ac_user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return ac_create_time
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
     * @return ac_md5_value
     */
    public String getMd5Value() {
        return md5Value;
    }

    /**
     * @param md5Value
     */
    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value;
    }

    /**
     * @return ac_update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return ac_expire_time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}