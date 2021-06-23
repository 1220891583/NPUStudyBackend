package com.hhstudygroup.npustudy.domain;

import java.io.Serializable;

public class Inbox implements Serializable {
    /**
     * 邮箱
     * id: int
     * user_id: int
     * total_msg: int
     * readed: int
     */

    private static final long serialVersionUID = -5776818767435811239L;

    private int id;

    private int user_id;

    private int totalMsg;

    private int readed;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotalMsg() {
        return totalMsg;
    }

    public void setTotalMsg(int totalMsg) {
        this.totalMsg = totalMsg;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", totalMsg=" + totalMsg +
                ", readed=" + readed +
                '}';
    }

}
