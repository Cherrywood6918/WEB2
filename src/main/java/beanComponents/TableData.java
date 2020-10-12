package beanComponents;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TableData implements Serializable {
    private double x;
    private double y;
    private double r;
    private Date date;
    private boolean res;

    public TableData() {
    }

    public TableData(double x, double y, double r, Date date, boolean res) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableData data = (TableData) o;
        return Double.compare(data.x, x) == 0 &&
                Double.compare(data.y, y) == 0 &&
                Double.compare(data.r, r) == 0 &&
                res == data.res &&
                Objects.equals(date, data.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, date, res);
    }

    @Override
    public String toString() {
        return "TableData{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", date=" + date +
                ", res=" + res +
                '}';
    }
}
