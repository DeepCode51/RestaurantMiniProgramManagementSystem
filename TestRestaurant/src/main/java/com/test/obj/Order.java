package com.test.obj;

public class Order {
    private int id;
    private String raccount;
    private String openid;
    private String stat;
    private String createtime;
    private double totalprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaccount() {
        return raccount;
    }

    public void setRaccount(String raccount) {
        this.raccount = raccount;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", raccount='" + raccount + '\'' +
                ", openid='" + openid + '\'' +
                ", stat='" + stat + '\'' +
                ", createtime='" + createtime + '\'' +
                ", totalprice=" + totalprice +
                '}';
    }
}
