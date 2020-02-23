package service;

import dao.PointDao;
import model.Point;
import util.ConfigReader;
import util.ConnectionCreator;

import java.util.List;

public class PointService {
    private PointDao dao;

    private static volatile PointService instance = null;
    private PointService(){
        ConnectionCreator connection = new ConnectionCreator(ConfigReader.getConfiguration());
        this.dao = new PointDao(connection.getFactory());
    }
    public static PointService getInstance(){
        synchronized (PointService.class){
            if (instance == null){
                synchronized (PointService.class){
                    instance = new PointService();
                }
            }
        }
        return instance;
    }

    public List<Point> getAllPoints() {
        return dao.getAllPoints();
    }

    public boolean addPoint(Point point) {
        return dao.addPoint(point);
    }
}
