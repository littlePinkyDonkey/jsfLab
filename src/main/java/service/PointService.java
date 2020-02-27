package service;

import dao.PointDao;
import model.Point;

public class PointService {

    private PointDao dao;

    public boolean addPoint(Point point) {
        return dao.addPoint(point);
    }

    public PointDao getDao() {
        return dao;
    }

    public void setDao(PointDao dao) {
        this.dao = dao;
    }
}
