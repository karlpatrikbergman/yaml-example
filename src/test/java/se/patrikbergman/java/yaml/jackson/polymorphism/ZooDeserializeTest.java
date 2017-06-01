package se.patrikbergman.java.yaml.jackson.polymorphism;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceInputStream;
import se.patrikbergman.java.yaml.ObjectFromFileUtil;
import se.patrikbergman.java.yaml.jackson.ObjectFromFileUtilJackson;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

@Slf4j
public class ZooDeserializeTest {

    private final String PATH = "jackson/polymorphism/zoo.json";

    @Test
    public void test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResourceInputStream resourceInputStream = new ResourceInputStream(PATH);
        Zoo zoo = mapper.readValue(resourceInputStream, Zoo.class);

        assertNotNull(zoo);
        assertNotNull(((Lion)zoo.animals.get(0)).getName().equals("Simba"));

        System.out.println(zoo);
    }

    @Test
    public void test2() {
        ObjectFromFileUtil objectFromFileUtil = ObjectFromFileUtilJackson.INSTANCE;
        Zoo zoo = objectFromFileUtil.getObject(PATH, Zoo.class);
        log.info(zoo.toString());
    }
}
