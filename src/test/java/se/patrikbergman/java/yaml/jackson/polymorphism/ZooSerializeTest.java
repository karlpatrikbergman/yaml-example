package se.patrikbergman.java.yaml.jackson.polymorphism;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ZooSerializeTest {
    private static String outputFile = "zoo.json";

    @Test
    public void test() throws IOException {
        // let start creating the zoo
        Zoo zoo = new Zoo("Samba Wild Park", "Paz");
        Lion lion = new Lion("Simba");
        Elephant elephant = new Elephant("Manny");
        List<Animal> animals = new ArrayList<>();
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);

        ObjectMapper mapper = new ObjectMapper();
        log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(zoo));
    }
}
