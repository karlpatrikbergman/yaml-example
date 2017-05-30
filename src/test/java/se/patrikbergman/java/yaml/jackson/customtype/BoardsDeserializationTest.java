package se.patrikbergman.java.yaml.jackson.customtype;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;

/**
 * Works neither with SnakeYaml or Jackson
 */
@Slf4j
public class BoardsDeserializationTest {

    @Ignore
    @Test
    public void test() throws IOException {

//        Constructor constructor = new Constructor(Node.class);
//        constructor.addTypeDescription(new TypeDescription(Tpd10gbe.class, new Tag("!tpd10be")));
//        constructor.addTypeDefinition(carDescription);

        Constructor constructor = new Constructor(NodeEquipment.class);
        TypeDescription typeDescription = new TypeDescription(NodeEquipment.class);
        typeDescription.putMapPropertyType("boards", Board.class, Tpd10gbe.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yaml = new Yaml(constructor);
        ResourceInputStream resourceInputStream = new ResourceInputStream("jackson/customtype/nodeequipment.yaml");
        yaml.load(resourceInputStream);


//        log.info(nodeEquipment.toString());

    }
}
