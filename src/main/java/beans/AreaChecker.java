package beans;

import model.Point;
import service.PointService;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class AreaChecker implements Serializable {

    private static final long serialVersionUID = -3982895126946874882L;

    private PointService service;
    private LinkedList<Point> history = new LinkedList<>();

    private Double x;
    private boolean y_4 = true;
    private boolean y_3 = false;
    private boolean y_2 = false;
    private boolean y_1 = false;
    private boolean y0 = false;
    private boolean y1 = false;
    private boolean y2 = false;
    private boolean y3 = false;
    private Double y;
    private Double r = 1d;

    private Double canvasX;
    private Double canvasY;

    public List<Point> getHistory(){
        return this.history;
    }
    public Double getX() {
        return x;
    }
    public boolean isY_4() {
        return y_4;
    }
    public boolean isY_3() {
        return y_3;
    }
    public boolean isY_2() {
        return y_2;
    }
    public boolean isY_1() {
        return y_1;
    }
    public boolean isY0() {
        return y0;
    }
    public boolean isY1() {
        return y1;
    }
    public boolean isY2() {
        return y2;
    }
    public boolean isY3() {
        return y3;
    }
    public Double getY() {
        return y;
    }
    public Double getR() {
        return r;
    }
    public Double getCanvasX() {
        return canvasX;
    }
    public Double getCanvasY() {
        return canvasY;
    }

    public void setX(Double x) {
        this.x = x;
    }
    public void setY_4(boolean y_4) {
        this.y_4 = y_4;
    }
    public void setY_3(boolean y_3) {
        this.y_3 = y_3;
    }
    public void setY_2(boolean y_2) {
        this.y_2 = y_2;
    }
    public void setY_1(boolean y_1) {
        this.y_1 = y_1;
    }
    public void setY0(boolean y0) {
        this.y0 = y0;
    }
    public void setY1(boolean y1) {
        this.y1 = y1;
    }
    public void setY2(boolean y2) {
        this.y2 = y2;
    }
    public void setY3(boolean y3) {
        this.y3 = y3;
    }
    public void setY() {
        if (y_4) {
            y = -4d;
        } else if (y_3) {
            y = -3d ;
        } else if (y_2) {
            y = -2d;
        } else if (y_1) {
            y = -1d;
        } else if (y1) {
            y = 1d;
        } else if (y2) {
            y = 2d;
        } else if (y3) {
            y = 3d;
        }
    }
    public void setR(Double r) {
        this.r = r;
    }
    public void setCanvasX(Double canvasX) {
        this.canvasX = canvasX;
    }
    public void setCanvasY(Double canvasY) {
        this.canvasY = canvasY;
    }

    public void checkArea(){
        setY();
        if (x != null && y != null){
            Point userPoint = new Point(x,y,r);
            userPoint.setHit(isHit(userPoint));
            service.addPoint(userPoint);
            history.addFirst(userPoint);
        }
    }

    public void checkCanvas(){
        Point userPoint = new Point(canvasX,canvasY,r);
        userPoint.setHit(isHit(userPoint));
        service.addPoint(userPoint);
        history.addFirst(userPoint);
    }

    public boolean isHit(Point currentPoint){
        double x = currentPoint.getX();
        double y = currentPoint.getY();
        double r = currentPoint.getR();
        double halfR = currentPoint.getR()/2;

        return x >= 0 && y <= 0 && x <= halfR && y >= -r ||
                x <= 0 && y <= 0 && x*x + y*y <= halfR*halfR ||
                x <= 0 && y >= 0 && x >= -halfR && y < x + halfR ;
    }

    public PointService getService() {
        return service;
    }

    public void setService(PointService service) {
        this.service = service;
    }
}
