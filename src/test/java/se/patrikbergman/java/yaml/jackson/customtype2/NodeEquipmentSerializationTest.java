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
        Tpd10gbe tpd10gbe = new Tpd10gbe();
        tpd10gbe.setName("tpd10gbe");
        tpd10gbe.setClient("client");
        tpd10gbe.setGroupOrTable("if");
        tpd10gbe.setModule("wdm");
        tpd10gbe.setTpd10gbeSpecificField("yodoyodo");

        NodeEquipment nodeEquipment = new NodeEquipment();
        Map<String, Board> boards = new HashMap<>();
        boards.put("slot1", tpd10gbe);
        nodeEquipment.setBoards(boards);

//        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper mapper = ObjectFromFileUtilJackson.INSTANCE.getMapper();
        log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nodeEquipment));
    }
}
