package com.hhstudygroup.npustudy.domain;

import java.io.Serializable;

public class Subject implements Serializable {
    /**
     * id: int
     * name: varchar(255)
     * level: int
     * level_name: varchar(255)
     * item_order: int
     * deleted: bit(1)
     */
    private Integer id;

    /**
     * 学科 name
     */
    private String name;

    /**
     * 大一 ~ 大四  1~4 level
     */
    private Integer level;

    /**
     * 大一 ~ 大四 levelName
     */
    private String levelName;

    /**
     * 排序 itemOrder
     */
    private Integer itemOrder;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", levelName='" + levelName + '\'' +
                ", itemOrder=" + itemOrder +
                ", deleted=" + deleted +
                '}';
    }
}
