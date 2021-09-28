
package hibcrs;

import org.hibernate.HibernateException;


public class ClientCrsBase extends AppCrs<Client>{

    public ClientCrsBase() {
        System.out.println("2-------");
    }

    public ClientCrsBase(Class type) {
        super(type);
    }

    public ClientCrsBase(AppCrs appCrs) {
        super(appCrs);
    }

   
 
}
