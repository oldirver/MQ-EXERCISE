package com.junxian.mq.exercise.bo;

/**
 * Created by KeJunXian on 2016/9/17.
 *
 */
public class OrderBO {

    private String id;

    private String userId;

    private String[] itemList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getItemList() {
        return itemList;
    }

    public void setItemList(String[] itemList) {
        this.itemList = itemList;
    }
}
