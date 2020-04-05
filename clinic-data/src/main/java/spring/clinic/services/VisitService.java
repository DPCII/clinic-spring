package spring.clinic.services;

import org.springframework.stereotype.Service;
import spring.clinic.models.Visit;

@Service
public interface VisitService extends CrudService<Visit, Long> {
}
