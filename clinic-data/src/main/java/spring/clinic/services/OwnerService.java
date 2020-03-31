package spring.clinic.services;

import spring.clinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
