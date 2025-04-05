package pet.store.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Entity
public class Customer {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String customerName;
	    private String customerEmail; 
	    private String customerPhone;
	    private String customerAddress;
	    
	    
	    @ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	    @EqualsAndHashCode.Exclude
	    @ToString.Exclude
	    private Set<PetStore> petStores;
}
