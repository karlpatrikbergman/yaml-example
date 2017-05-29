package se.patrikbergman.java.yaml.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

@Slf4j
public class NodeDeserializationTest {

    private final ObjectMapper MAPPER = JacksonYamlUtil.INSTANCE.mapper;

    private final static String SIMPLE_YAML_NATIVE =
            "---\n"
                    +"&1 name: \"first\"\n"
                    +"next:\n"
                    +"  &2 name: \"second\"\n"
                    +"  next: *1"
            ;

    @Test
    public void testBasicDeserialization() throws Exception {
        log.info(SIMPLE_YAML_NATIVE);
        Node first = MAPPER.readValue(SIMPLE_YAML_NATIVE, Node.class);
        _verify(first);
    }

    @Test
    public void testBasickDeserializationWithReader() throws IOException {
        final ObjectReader reader = JacksonYamlUtil.INSTANCE.getReader().forType(se.patrikbergman.java.yaml.jackson.Node.class);
        final InputStream in = new ResourceInputStream("jackson/node.yaml");
        final Node node = reader.readValue(in);
        _verify(node);
    }

    private void _verify(Node n)
    {
        assertNotNull(n);
        assertEquals("first", n.name);
        assertNotNull(n.next);
        assertEquals("second", n.next.name);
        assertNotNull(n.next.next);
        assertSame(n, n.next.next);
    }
}
