package hibcrs;

import java.util.List;

public class AdressCrsBase extends AppCrs{

    public AdressCrsBase() {
    }

    public AdressCrsBase(AppCrs appCrs) {
        super(appCrs);
    }

   
    
    
    
    public void save(Address a) {
        s.save(a);
    }
    
    public void delete(Address a) {
        s.delete(a);
    }
    
    public Address[] getByPk(String clientId) {
        List<Address> r = s.createQuery("from Address a where a.client.id = :clientId", Address.class)
                .setParameter("clientId", clientId)
                .list();
        
        return r.toArray(new Address[0]);
    }
    
}
