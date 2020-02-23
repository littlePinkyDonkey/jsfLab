package dao;

import model.Point;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PointDao {
    private SessionFactory sessionFactory;

    public PointDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Point> getAllPoints() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Point> points = null;
        try{
//            points = session.
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return points;
    }

    public boolean addPoint(Point point) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.save(point);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
