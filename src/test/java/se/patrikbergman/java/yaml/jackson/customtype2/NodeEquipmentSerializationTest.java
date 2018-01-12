package se.patrikbergman.java.yaml.jackson.customtype2;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.yaml.jackson.ObjectFromFileUtilJackson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class NodeEquipmentSerializationTest {
    @Test
    public void test() throws IOException {
        Tpd10gbe tpd10gbe = Tpd10gbe.builder()
                .name("tpd10gbe")
                .client("client")
                .groupOrTable("if")
                .module("client")
                .tpd10gbeSpecificField("yadayada")
                .build();

        Map<String, Board> boards = new HashMap<>();
        boards.put("slot1", tpd10gbe);

        NodeEquipment nodeEquipment = NodeEquipment.builder()
                .boards(boards)
                .build();
        ObjectMapper mapper = ObjectFromFileUtilJackson.INSTANCE.getMapper();
        log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nodeEquipment));
    }
}
