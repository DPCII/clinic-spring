package spring.clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.clinic.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
