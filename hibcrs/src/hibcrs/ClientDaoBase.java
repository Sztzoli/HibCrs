
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
    
    public static void delete(Client client) throws HibernateException{
        ClientCrs c;
        c = new ClientCrs();
        
        try {
            c.delete(client);
        } catch (Exception e){
            if (c.getT() != null ) {
                c.getT().rollback();
            }
            throw new RuntimeException();
        }   
        finally {
            c.clear();
        } 
    }
}
