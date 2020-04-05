package spring.clinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.clinic.models.PetType;
import spring.clinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
