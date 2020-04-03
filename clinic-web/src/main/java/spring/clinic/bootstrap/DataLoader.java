package spring.clinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.clinic.models.Owner;
import spring.clinic.models.Pet;
import spring.clinic.models.PetType;
import spring.clinic.models.Vet;
import spring.clinic.services.OwnerService;
import spring.clinic.services.PetTypeService;
import spring.clinic.services.VetService;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Bob");
        owner1.setLastName("Smith");
        owner1.setAddress("123 Main St");
        owner1.setCity("Boston");
        owner1.setTelephone("555-333-0000");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Jones");
        owner2.setAddress("123 Main St");
        owner2.setCity("Boston");
        owner2.setTelephone("555-333-0000");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axelstein");

        vetService.save(vet1);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Pet lafayette = new Pet();
        lafayette.setPetType(cat);
        lafayette.setBirthdate(LocalDate.of(2019, Month.APRIL, 1));
        lafayette.setName("Lafayette");
        lafayette.setOwner(owner1);
        owner1.getPets().add(lafayette);

        Pet august = new Pet();
        august.setPetType(cat);
        august.setBirthdate(LocalDate.of(2019, Month.APRIL, 14));
        august.setName("August");
        august.setOwner(owner2);
        owner2.getPets().add(august);

    }
}
