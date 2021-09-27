package hibcrs;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Client")
@Table(name = "clients")
public class Client {
    
    @Id
    @Column(name = "Id")
    protected String id;
    
    @Column(name = "Name")
    protected String name;
    
    @Column(name = "Age")
    protected int age;
    
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)       
    protected List<Address> address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
    
    
    
}
