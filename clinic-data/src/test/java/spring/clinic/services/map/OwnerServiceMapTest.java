package spring.clinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.clinic.models.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerIdForTest = 4L;
    final String ownerLastNameForTest = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        Owner owner = new Owner();
        owner.setId(ownerIdForTest);
        owner.setLastName(ownerLastNameForTest);
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void save() {
        Owner owner = ownerServiceMap.save(new Owner());
        assertNotNull(owner);
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerIdForTest);

        assertEquals(ownerIdForTest, owner.getId());
    }

    @Test
    void findByLastName() {
        assertEquals(ownerLastNameForTest, ownerServiceMap.findByLastName(ownerLastNameForTest).getLastName());
    }

    @Test
    void deleteById() {
        assertNotNull(ownerServiceMap.findById(ownerIdForTest));
        ownerServiceMap.deleteById(ownerIdForTest);
        assertNull(ownerServiceMap.findById(ownerIdForTest));
    }

    @Test
    void delete() {
        Owner testDel = new Owner();
        ownerServiceMap.save(testDel);
        assertTrue(ownerServiceMap.findAll().contains(testDel));
        ownerServiceMap.delete(testDel);
        assertFalse(ownerServiceMap.findAll().contains(testDel));
    }
}