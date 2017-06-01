package se.patrikbergman.java.yaml.jackson.customtype2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.yaml.ObjectFromFileUtil;
import se.patrikbergman.java.yaml.jackson.ObjectFromFileUtilJackson;

@Slf4j
public class NodeEquipmentDeserializationTest {
    private final String PATH = "jackson/customtype2/nodeequipment.yml";

    @Test
    public void test2() {
        ObjectFromFileUtil objectFromFileUtil = ObjectFromFileUtilJackson.INSTANCE;
        NodeEquipment nodeEquipment = objectFromFileUtil.getObject(PATH, NodeEquipment.class);
        log.info(nodeEquipment.toString());
    }
}
