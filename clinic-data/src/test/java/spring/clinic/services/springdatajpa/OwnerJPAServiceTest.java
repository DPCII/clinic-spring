package spring.clinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.clinic.models.Owner;
import spring.clinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJPAService service;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setLastName("Smith");
        owner.setId(7L);
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner smith = service.findByLastName("Smith");

        assertEquals("Smith", smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setLastName("abacdfd");
        Owner owner2 = new Owner();
        owner2.setLastName("fsdfdfd");
        owners.add(owner1);
        owners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> ownersCheck = service.findAll();

        assertNotNull(ownersCheck);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(owner));

        Owner ownerTest = service.findById(7L);

        assertNotNull(ownerTest);
    }

    @Test
    void save() {

        Owner ownerToSave = new Owner();
        ownerToSave.setId(8L);

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(7L);
        verify(ownerRepository).deleteById(anyLong());
    }
}