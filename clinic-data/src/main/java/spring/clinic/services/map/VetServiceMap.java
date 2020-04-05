package spring.clinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.clinic.models.Specialty;
import spring.clinic.models.Vet;
import spring.clinic.services.VetService;
import spring.clinic.services.VetSpecialtyService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final VetSpecialtyService vetSpecialtyService;

    public VetServiceMap(VetSpecialtyService vetSpecialtyService) {
        this.vetSpecialtyService = vetSpecialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        /*
        In the event that Vets are saved and populated before their specialties are persisted, we make sure
        that specialty persistence occurs here and that they receive their id.
         */
        if(object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null) {
                    Specialty savedSpecialty = vetSpecialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
