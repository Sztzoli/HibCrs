
package hibcrs;

import org.hibernate.HibernateException;


public class ClientCrsBase extends AppCrs{

    public ClientCrsBase() {
    }
    
     public ClientCrsBase(AppCrs appcrs) {
    }
    
    
    
    public void save(Client client) {
        s.save(client);
    }
    
    public void delete(Client client) {
//        if (1 == 1) {
//            throw new HibernateException("Hiba");
//        }
        s.delete(client);        
    }
}
