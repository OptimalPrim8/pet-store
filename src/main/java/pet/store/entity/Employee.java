package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_store_id") // Relationship variable
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PetStore petStore;


	public Long getEmployeeId() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEmployeeName() {
		// TODO Auto-generated method stub
		return null;
	}
}
