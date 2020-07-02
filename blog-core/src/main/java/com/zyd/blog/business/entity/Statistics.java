package com.zyd.blog.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyd.blog.persistence.beans.BizStatistics;


public class Statistics {

    private BizStatistics bizStatistics;

    public Statistics(BizStatistics bizStatistics) {
        this.bizStatistics = bizStatistics;
    }

    public Statistics() {
    }

    @JsonIgnore
    public BizStatistics getBizStatistics() {
        return bizStatistics;
    }

    public String getName() {
        return this.bizStatistics.getName();
    }

    public void setName(String name) {
        this.bizStatistics.setName(name);
    }

    public Integer getValue() {
        return this.bizStatistics.getValue();
    }

    public void setValue(Integer value) {
        this.bizStatistics.setValue(value);
    }
}
