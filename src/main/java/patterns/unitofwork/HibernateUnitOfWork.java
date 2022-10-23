package patterns.unitofwork;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUnitOfWork {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    private boolean active;

    public HibernateUnitOfWork(SessionFactory sessionFactory) {
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();
        this.active = true;
    }

    public boolean contains(Object object) {
        if (!this.active) {
            throw new RuntimeException(HibernateUnitOfWork.Errors.UNIT_OF_WORK_ALREADY_COMPLETE.code());
        } else {
            return this.session.contains(object);
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public void evict(Object object) {
        if (!this.active) {
            throw new RuntimeException(HibernateUnitOfWork.Errors.UNIT_OF_WORK_ALREADY_COMPLETE.code());
        } else {
            this.session.evict(object);
        }
    }

    public void attach(Object object) {
        if (!this.active) {
            throw new RuntimeException(HibernateUnitOfWork.Errors.UNIT_OF_WORK_ALREADY_COMPLETE.code());
        } else {
            this.session.saveOrUpdate(object);
        }
    }

    public void persist(Object object) {
        if (!this.active) {
            throw new RuntimeException(HibernateUnitOfWork.Errors.UNIT_OF_WORK_ALREADY_COMPLETE.code());
        } else {
            this.session.persist(object);
        }
    }

    public void delete(Object object) {
        if (!this.active) {
            throw new RuntimeException(HibernateUnitOfWork.Errors.UNIT_OF_WORK_ALREADY_COMPLETE.code());
        } else {
            this.session.delete(object);
        }
    }

    public void commit() {
        if (!this.active) {
            throw new RuntimeException(HibernateUnitOfWork.Errors.UNIT_OF_WORK_ALREADY_COMPLETE.code());
        } else {
            this.transaction.commit();
            this.session.close();
            this.active = false;
        }
    }

    public void rollback() {
        if (!this.active) {
            throw new RuntimeException(HibernateUnitOfWork.Errors.UNIT_OF_WORK_ALREADY_COMPLETE.code());
        } else {
            this.transaction.rollback();
            this.session.close();
            this.active = false;
        }
    }

    public Session getSession() {
        return this.session;
    }

    public void close() throws RuntimeException {
        if (this.active) {
            this.rollback();
        }

    }

    public static enum Errors{
        UNKNOWN_UOW_ERROR("unknown dao error got his way to life"),
        UNIT_OF_WORK_ALREADY_COMPLETE("Unit of work already complete");

        private String message;

        private Errors(String message) {
            this.message = message;
        }

        public String code() {
            return this.name();
        }

        public String toString() {
            return this.message;
        }
    }
}


