package pet.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.store.entity.PetStore;


public interface petstoredao extends JpaRepository<PetStore, Long> {

}
