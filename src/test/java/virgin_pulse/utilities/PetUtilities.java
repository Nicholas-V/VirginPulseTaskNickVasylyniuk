package virgin_pulse.utilities;

import virgin_pulse.pojo.Category;
import virgin_pulse.pojo.Pet;
import virgin_pulse.pojo.Tags;

public class PetUtilities {

    public static Pet createNewPet(String petName, String categoryName,  String photoUrls, String tagsName, String status ){
        Pet pet = new Pet();
        Category petCategory = new Category();
        Tags petTags = new Tags();

        petCategory.setName(categoryName);
        petTags.setName(tagsName);

        pet.setPetCategory(petCategory);
        pet.setName(petName);
        pet.setPhotoUrl(photoUrls);
        pet.setPetTag(petTags);
        pet.setStatus(status);
        return pet;
    }
}
