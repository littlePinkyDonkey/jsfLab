package model;

import javax.persistence.*;

@Entity
public class Point {

    @Id
    @SequenceGenerator(name = "id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "x", nullable = false)
    private Double x;

    @Column(name = "y", nullable = false)
    private Double y;

    @Column(name = "r", nullable = false)
    private Double r;

    private boolean hit;

    public Point(){}
    public Point(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Double getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public Double getR() {
        return r;
    }
    public boolean isHit() {
        return hit;
    }

    public void setX(Double x) {
        this.x = x;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public void setR(Double r) {
        this.r = r;
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;
        return x.equals(point.getX()) &&
                y.equals(point.getY()) &&
                r.equals(point.getR()) &&
                isHit() == point.isHit();
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", hit=" + hit +
                '}';
    }
}
