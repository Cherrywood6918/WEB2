package beanComponents;

import java.io.Serializable;
import java.util.Date;

public class TableData implements Serializable {
    private double x;
    private double y;
    private double r;
    private String date;
    private boolean res;

    public TableData(double x, double y, double r, String date, boolean res) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.date = date;
        this.res = res;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public boolean getRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "{" +
                "\"x\":\"" + x +
                "\", \"y\":\"" + y +
                "\", \"r\":\"" + r +
                "\", \"date\":\"" + date  +
                "\", \"res\":\"" + res +
                "\"}";
    }
}
