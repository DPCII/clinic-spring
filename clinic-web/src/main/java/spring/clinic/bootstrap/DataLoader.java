package spring.clinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.clinic.models.*;
import spring.clinic.services.*;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VetSpecialtyService vetSpecialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, VetSpecialtyService vetSpecialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.vetSpecialtyService = vetSpecialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0)
            loadData();

    }

    private void loadData() {
        Specialty specialty1 = new Specialty();
        specialty1.setDescription("Radiology");

        Specialty specialty2 = new Specialty();
        specialty2.setDescription("Surgery");

        Specialty specialty3 = new Specialty();
        specialty3.setDescription("Dentistry");

        vetSpecialtyService.save(specialty1);
        vetSpecialtyService.save(specialty2);
        vetSpecialtyService.save(specialty3);

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
        vet1.getSpecialties().add(specialty1);
        vet1.getSpecialties().add(specialty3);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sara");
        vet2.setLastName("Evans");
        vet2.getSpecialties().add(specialty2);

        vetService.save(vet2);

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Pet lafayette = new Pet();
        lafayette.setPetType(cat);
        lafayette.setBirthdate(LocalDate.of(2019, Month.APRIL, 1));
        lafayette.setName("Lafayette");
        lafayette.setOwner(owner1);
        petService.save(lafayette);
        owner1.getPets().add(lafayette);

        Pet august = new Pet();
        august.setPetType(cat);
        august.setBirthdate(LocalDate.of(2019, Month.APRIL, 14));
        august.setName("August");
        august.setOwner(owner2);
        petService.save(august);
        owner2.getPets().add(august);

        Visit visit1 = new Visit();
        visit1.setPet(august);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneezing and watery eyes");
        visitService.save(visit1);

        System.out.println("Loaded data...");
    }
}
