
package hibcrs;


public class ClientCrs extends ClientCrsBase{

    protected AdressCrs adressCrs;

    public ClientCrs() {
        adressCrs = new AdressCrs(this);
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
