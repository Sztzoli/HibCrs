package hibcrs;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppCrs {
    
    protected Session s;
    protected Transaction t;

    public AppCrs() {
        s = SessionUtil.getSession();
        t = s.beginTransaction();
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
    
    
    
    
    
}
