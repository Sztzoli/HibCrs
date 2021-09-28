
package hibcrs;

import java.util.Arrays;

public class Hibcrs {

    
    public static void main(String[] args) {
       
       Client client = new Client();
       client.setId("10");
       client.setName("Zoli");
       client.setAge(10);       
 //    ClientDao.save(client);
       
       Address address = new Address();
       address.setClient(client);
       address.setId("20");
       address.setAddressName("address");
  //    AddressDao.save(address);
   //    System.out.println(Arrays.toString(ClientDao.getAll()));
       System.out.println(ClientDao.getByPk("10"));
     // ClientDao.delete(client);
    }
    
}
