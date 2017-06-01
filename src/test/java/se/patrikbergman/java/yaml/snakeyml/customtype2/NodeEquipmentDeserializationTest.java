package se.patrikbergman.java.yaml.snakeyml.customtype2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.yaml.ObjectFromFileUtil;
import se.patrikbergman.java.yaml.snakeyml.ObjectFromFileUtilSnakeYaml;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

@Slf4j
public class NodeEquipmentDeserializationTest {
    private final String PATH = "snakeyml/customtype2/nodeequipment.yml";

    @Test
    public void deserializeNodeEquipmentWithSnakeYaml() throws IOException {
        final ObjectFromFileUtil objectFromFileUtil = ObjectFromFileUtilSnakeYaml.INSTANCE;
        final NodeEquipment nodeEquipment =objectFromFileUtil.getObject(PATH, NodeEquipment.class);
        assertNotNull(nodeEquipment.getBoards());
        assertNotNull(nodeEquipment.getBoards().get("slot1"));

        final Tpmr2500 tpmr2500 = (Tpmr2500) nodeEquipment.getBoards().get("slot2");
        tpmr2500.tpmr2500SpecificMethod();

        log.info(nodeEquipment.toString());

        nodeEquipment.getBoards().forEach((k,v) -> log.info("key: "+k+" value: "+v.getBoardEntry()));

    }
}
