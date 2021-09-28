package hibcrs;

import org.hibernate.HibernateException;

public class ClientDaoBase {
    
    public static void save(Client client) {
        ClientCrs c;
        c = new ClientCrs();
        
        try {
            c.save(client);
        } finally {
            c.clear();
        }        
    }
    
    public static void delete(Client client) {
        ClientCrs c;
        c = new ClientCrs();
        
        try {
            c.delete(client);
        } catch (Exception e) {
            if (c.getT() != null) {
                c.getT().rollback();
            }
            throw new RuntimeException();
        } finally {
            c.clear();
        }        
    }
    
    public static Client[] getAll() {
        ClientCrs c;
        c = new ClientCrs(Client.class);
        
        try {
            return c.getAll();
        } catch (Exception e) {
            if (c.getT() != null) {
                c.getT().rollback();
            }
            throw new RuntimeException();
        } finally {
            c.clear();
        }
    }
    
    public static Client getByPk(String data) {
        ClientCrs c;
        c = new ClientCrs(Client.class);
        
        try {
            Client cl = c.getByPk(data);
            System.out.println(cl);
            return cl;                    
        } catch (Exception e) {
            System.out.println("in exc");
            if (c.getT() != null) {
                c.getT().rollback();
            }
            throw new RuntimeException();
        } finally {
            c.clear();
        }
    }
    
}
