
package pet.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.store.controller.model.PetStoreData;
import pet.store.entity.PetStore;
import pet.store.dao.petstoredao;

import java.util.NoSuchElementException;

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

    private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
        petStore.setStoreName(petStoreData.getPetStoreName());
        petStore.setAddress(petStoreData.getPetStoreAddress()); 
       
    }

   
    public PetStoreData findPetStoreById(Long petStoreId) {
        PetStore petStore = petStoreDao.findById(petStoreId)
                .orElseThrow(() -> new NoSuchElementException("Pet store with ID=" + petStoreId + " was not found."));
        return new PetStoreData(petStore);
    }
}