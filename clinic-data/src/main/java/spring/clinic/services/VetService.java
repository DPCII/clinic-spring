package spring.clinic.services;

import spring.clinic.models.Vet;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
