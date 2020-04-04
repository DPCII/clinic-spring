package spring.clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.clinic.models.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
