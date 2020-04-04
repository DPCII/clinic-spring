package spring.clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.clinic.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
