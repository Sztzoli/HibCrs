
package hibcrs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Address")
@Table(name = "address")
public class Address {
    
    @Id
    @Column(name = "Id_AD")
    protected String id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClientFk")           
    protected Client client;
    
    @Column(name = "Address_name")
    protected String addressName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    
    
}
