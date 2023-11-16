package com.ywy.entity;

public class IDCard {
    private Integer id;
    private String cardNo;
    private Integer uid;

    @Override
    public String toString() {
        return "IDCard{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", uid=" + uid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public IDCard() {
    }

    public IDCard(Integer id, String cardNo, Integer uid) {
        this.id = id;
        this.cardNo = cardNo;
        this.uid = uid;
    }
}
