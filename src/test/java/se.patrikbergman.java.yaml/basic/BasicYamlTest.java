package se.patrikbergman.java.yaml.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BasicYamlTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test() throws IOException {
        Configuration configuration = YamlToConfigurationParser.parse("basic/configuration.yml");
        assertNotNull(configuration);
        Connection connection = configuration.getConnection();
        assertEquals("jdbc:mysql://localhost:3306/db", connection.getUrl());
        assertEquals(2, configuration.getProtocols().size());
        assertTrue(configuration.getUsers().containsKey("bob"));

        System.out.println("*** toString() ***");
        System.out.println(configuration + "\n");

        System.out.println("*** JSON ***");
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(configuration));
    }
}
