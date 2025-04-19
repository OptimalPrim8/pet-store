package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class PetStoreData {

    private Long petStoreId;
    private String petStoreName;
    private String petStoreAddress;
    private Set<PetStoreCustomer> customers = new HashSet<>();
    private Set<PetStoreEmployee> employees = new HashSet<>();

    public PetStoreData(PetStore petStore) {
        this.petStoreId = petStore.getId();
        this.petStoreName = petStore.getStoreName();
        this.petStoreAddress = petStore.getAddress();

        // Populate customers
        for (Customer customer : petStore.getCustomers()) {
            this.customers.add(new PetStoreCustomer(customer));
        }

        // Populate employees
        for (Employee employee : petStore.getEmployees()) {
            this.employees.add(new PetStoreEmployee(employee));
        }
    }


    @NoArgsConstructor
    public static class PetStoreCustomer {
        public PetStoreCustomer(Customer customer) {
            customer.getId();
            customer.getCustomerName();
            customer.getCustomerAddress();
        }
    }

    @Data
    @NoArgsConstructor
    public static class PetStoreEmployee {
        private Long employeeId;
        private String employeeName;

        public PetStoreEmployee(Employee employee) {
            this.employeeId = employee.getEmployeeId();
            this.employeeName = employee.getEmployeeName();
        }

		public Object getEmployeeFirstName() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getEmployeeAddress() {
			// TODO Auto-generated method stub
			return null;
		}

	
    }
}
