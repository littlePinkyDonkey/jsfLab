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
    public void setY(Double y) {
        this.y = y;
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
