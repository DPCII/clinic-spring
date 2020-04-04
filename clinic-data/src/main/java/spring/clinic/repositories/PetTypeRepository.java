package spring.clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.clinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
