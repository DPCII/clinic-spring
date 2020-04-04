package spring.clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.clinic.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
