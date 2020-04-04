package spring.clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.clinic.models.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
