package spring.clinic.services;

import org.springframework.stereotype.Service;
import spring.clinic.models.Specialty;

@Service
public interface VetSpecialtyService extends CrudService<Specialty, Long> {
}
