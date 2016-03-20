package com.github.ichenkaihua.oneschedule.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "image_resource")
public class ImageResource {
    @Id
    @Column(name = "ir_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ir_path")
    private String path;

    @Column(name = "ir_upload_time")
    private Date uploadTime;

    @Column(name = "ir_user_id")
    private Integer userId;

    /**
     * @return ir_id
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
     * @return ir_path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return ir_upload_time
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * @param uploadTime
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * @return ir_user_id
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
}