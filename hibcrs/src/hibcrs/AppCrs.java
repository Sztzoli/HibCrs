package hibcrs;

import java.lang.reflect.Array;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppCrs<T> {
    
    protected Session s;
    protected Transaction t;
    protected Class<T> type;

    public AppCrs() {
        s = SessionUtil.getSession();
        t = s.beginTransaction();
        System.out.println("1------");
    }
    
    public AppCrs(Class<T> type) {
        s = SessionUtil.getSession();
        t = s.beginTransaction();
        this.type = type;
    }
    
     public AppCrs(AppCrs appCrs) {
        s = appCrs.getS();
        t = appCrs.getT();
    }
    
    
    public void clear() {
        System.out.println("End----------------");
        t.commit();            
        s.close();
    }

    public Session getS() {
        return s;
    }

    public Transaction getT() {
        return t;
    }
    
    public void save(T data) {
        s.save(data);
    }
    
    public void delete(T data) {
        s.delete(data);
    }
    
    public T getByPk(String data) {
        return s.get(type, data);
    }
    
    public T[] getAll() {
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);        
        Root<T> root = query.from(type);
        query.select(root);
        List<T> l = s.createQuery(query).list();
        return l.toArray((T[]) Array.newInstance(type, l.size()));
    }
    

    
}
