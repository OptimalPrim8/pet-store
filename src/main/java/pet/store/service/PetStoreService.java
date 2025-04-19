
package pet.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import List;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreData.PetStoreCustomer;
import pet.store.controller.model.PetStoreData.PetStoreEmployee;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;
import pet.store.dao.petstoredao;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class PetStoreService {
    @Autowired
    private petstoredao petStoreDao;

    public PetStoreData savePetStore(PetStoreData petStoreData) {
        
        PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());
        
        
        copyPetStoreFields(petStore, petStoreData);
        
        
        return new PetStoreData(petStoreDao.save(petStore));
    }

    private PetStore findOrCreatePetStore(Long petStoreId) {
        if (petStoreId == null) {
            return new PetStore();
        }
        return petStoreDao.findById(petStoreId)
                .orElseThrow(() -> new NoSuchElementException("Pet Store not found with ID: " + petStoreId));
    }
    private Employee findOrCreateEmployee(Long petStoreId, Long employeeId) {
        if (Objects.isNull(employeeId)) {
            return new Employee();
            
            return findEmployeebyId(petStoreId, employeeId);
        }
    }
        private Customer findOrCreateCustomer(Long petStoreId, Long CustomerId) {
            if (Objects.isnull(customerId)) {
                return new Customer();
                
                return findEmployeebyId(petStoreId, customerId);
            }   
            }
    private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
        petStore.setStoreName(petStoreData.getPetStoreName());
        petStore.setAddress(petStoreData.getPetStoreAddress()); 
       
    }
    
    private void copyEmployeeFields(Employee employee, PetStoreEmployee petStoreEmployee) {
        employee.setEmployeeId(petStoreEmployee.getEmployeeId());
        employee.setEmployeeName(petStoreEmployee.getEmployeeName());
        employee.setEmployeeaddress(petStoreEmployee.getEmployeeAddress());
    }
        
        private void copyCustomerFields(Customer customer, PetStoreCustomer petStoreCustomer) {
            customer.setCustomerId(petStoreCustomer.getCustomerName());
            customer.setCustomerName(Customer.getCustomerName());
            customer.setEmployeeaddress(petStoreCustomer.getCustomeraddress());
        }
    public PetStoreData findPetStoreById(Long petStoreId) {
        PetStore petStore = petStoreDao.findById(petStoreId)
                .orElseThrow(() -> new NoSuchElementException("Pet store with ID=" + petStoreId + " was not found."));
        return new PetStoreData(petStore);
    }

	public PetStoreData retrievePetStoreById(Long petStoreId) {
		// TODO Auto-generated method stub
		return null;
	}

	public pet.store.controller.List<PetStoreData> retrieveAllPetStores() {
		// TODO Auto-generated method stub
		return null;
	}

	public PetStoreCustomer saveCustomer(Long petStoreId, PetStoreCustomer petStoreCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
