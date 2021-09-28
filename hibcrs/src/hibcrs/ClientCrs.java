
package hibcrs;


public class ClientCrs extends ClientCrsBase{

    protected AdressCrs adressCrs;

    public ClientCrs() {
        adressCrs = new AdressCrs(this);    
        System.out.println("3-------");
    }
   
    public ClientCrs(Class type) {
        super(type);        
    }

    public ClientCrs( AppCrs appCrs) {
        super(appCrs);        
    }
    
    
    
    
    
    @Override
    public void delete(Client client) {
        
       
           Address[] a = adressCrs.getByPk(client.getId());
             for (Address add : a) {
            System.out.println("delete adress");
            
            adressCrs.delete(add);
        }
        super.delete(client);
       
      
    }
    
    
}
