package service;

import dao.PointDao;
import model.Point;

public class PointService {

    private PointDao dao;

    public PointDao getDao() {
        return dao;
    }

    public void setDao(PointDao dao) {
        this.dao = dao;
    }

    public boolean addPoint(Point point) {
        return dao.addPoint(point);
    }
}
