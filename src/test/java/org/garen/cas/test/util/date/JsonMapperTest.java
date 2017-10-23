package org.garen.cas.test.util.date;

import org.garen.cas.swagger.model.Pet;
import org.garen.cas.util.JsonMapper;
import org.junit.Test;

/**
 * Created by Administrator on 2017/9/7.
 */
public class JsonMapperTest {

    @Test
    public void fromJsonTest(){
        String json = "{\"category\":{\"id\":0,\"name\":\"string\"},\"id\":0,\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"status\":\"available\",\"tags\":[{\"id\":0,\"name\":\"string\"}]}";
        Pet pet = new JsonMapper().fromJson(json, Pet.class);
        System.out.println(pet);
        System.out.println(pet.getId()+"--"+pet.getName());
    }

    @Test
    public void toJsonTest(){
        Pet pet = new Pet();
        pet.setId(10L);
        pet.setName("Hello kitty");
        pet.setStatus(Pet.StatusEnum.AVAILABLE);
        String json = new JsonMapper().toJson(pet);
        System.out.println(json);
    }

}
