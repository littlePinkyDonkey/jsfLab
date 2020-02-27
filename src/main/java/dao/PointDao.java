package dao;

import model.Point;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PointDao {

    private SessionFactory sessionFactory;

    public PointDao(){
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public boolean addPoint(Point point) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(point);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
