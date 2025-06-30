package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;

@DisplayName("Owner Map Service Test - ")
class OwnerMapServiceTest {

	OwnerMapService ownerMapService;
	PetTypeMapService petTypeService;
	PetService petService;

	@BeforeEach
	void setUp() throws Exception {
		petTypeService = new PetTypeMapService();
		petService = new PetMapService();
		ownerMapService = new OwnerMapService(petTypeService, petService);

		System.out.println("First Before Each");
	}

	@DisplayName("Verify zero owners")
	@Test
	void ownersAreZero() {
		int ownerCount = ownerMapService.findAll().size();

		assertEquals(0, ownerCount);
	}

	@DisplayName("Pet Type - ")
	@Nested
	class TestCreatePetTypes {

		@BeforeEach
		void setUp() {
			PetType petType = new PetType(1L, "Dog");
			PetType petType2 = new PetType(2L, "Cat");
			petTypeService.save(petType);
			petTypeService.save(petType2);

			System.out.println("Nested Before Each");
		}

		@Test
		void testPetCount() {
			int petTypeCount = petTypeService.findAll().size();

			assertEquals(2, petTypeCount);
		}

		@DisplayName("Save Owners Tests - ")
		@Nested
		class SaveOwnersTests {

			@BeforeEach
			void setUp() {
				ownerMapService.save(new Owner(1L, "Before", "Each"));

				System.out.println("Save Owners Before Each");
			}

			@Test
			void saveOwner() {
				Owner owner = new Owner(2L, "Joe", "Buck");

				Owner savedOwner = ownerMapService.save(owner);

				assertNotNull(savedOwner);
			}

			@DisplayName("Find Owners Tests - ")
			@Nested
			class FindOwnersTests {

				@DisplayName("Find Owner")
				@Test
				void findOwner() {
					Owner foundOwner = ownerMapService.findById(1L);
					
					assertNotNull(foundOwner);
				}

				@DisplayName("Find Owner Not Found")
				@Test
				void findOwnerNotFound() {
					Owner foundOwner = ownerMapService.findById(2L);
					
					assertNull(foundOwner);
				}
			}
		}
	}

	@DisplayName("Verify still zero owners")
	@Test
	void ownersAreStillZero() {
		int ownerCount = ownerMapService.findAll().size();

		assertEquals(0, ownerCount);
	}
}
