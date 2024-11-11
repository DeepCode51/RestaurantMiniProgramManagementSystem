package com.test.obj;

public class Menu {
    private int id;
    private String menutype;
    private String name;
    private double price;
    private String mimage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return mimage;
    }

    public void setImage(String mimage) {
        this.mimage = mimage;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menutype='" + menutype + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", mimage='" + mimage + '\'' +
                '}';
    }
}
