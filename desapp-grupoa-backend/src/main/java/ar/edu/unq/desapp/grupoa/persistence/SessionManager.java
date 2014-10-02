package ar.edu.unq.desapp.grupoa.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionManager {

    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> tlSession;

    public synchronized static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration cfg = new Configuration();
            cfg.configure();

            sessionFactory = cfg.buildSessionFactory();
            tlSession = new ThreadLocal<Session>();
        }

        return sessionFactory;
    }

    public static <T> T runInSession(Operation<T> cmd){
        SessionFactory sessionFactory = SessionManager.getSessionFactory();
        Transaction transaction = null;
        T result = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            tlSession.set(session);

            result = cmd.execute();

            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null)
                session.close();
            tlSession.set(null);
        }

        return result;
    }

    public static Session getSession() {
        return tlSession.get();
    }

}
