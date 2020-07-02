package com.zyd.blog.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyd.blog.persistence.beans.BizTags;

import java.util.Date;


public class Tags {
    private BizTags bizTags;

    public Tags() {
        this.bizTags = new BizTags();
    }

    public Tags(BizTags bizTags) {
        this.bizTags = bizTags;
    }

    @JsonIgnore
    public BizTags getBizTags() {
        return this.bizTags;
    }

    public Long getId() {
        return this.bizTags.getId();
    }

    public void setId(Long id) {
        this.bizTags.setId(id);
    }

    public String getName() {
        return this.bizTags.getName();
    }

    public void setName(String name) {
        this.bizTags.setName(name);
    }

    public String getDescription() {
        return this.bizTags.getDescription();
    }

    public void setDescription(String description) {
        this.bizTags.setDescription(description);
    }

    public Date getCreateTime() {
        return this.bizTags.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.bizTags.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.bizTags.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.bizTags.setUpdateTime(updateTime);
    }

}

