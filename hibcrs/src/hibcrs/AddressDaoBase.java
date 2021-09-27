
package hibcrs;

public class AddressDaoBase {
     public static void save(Address a) {
        AdressCrs c;
        c = new AdressCrs();
        
        try {
            c.save(a);
        } finally {
            c.clear();
        }       
    }
    
    public static void delete(Address a){
         AdressCrs c;
        c = new AdressCrs();
        
        try {
            c.delete(a);
        } finally {
            c.clear();
        } 
    }
}
