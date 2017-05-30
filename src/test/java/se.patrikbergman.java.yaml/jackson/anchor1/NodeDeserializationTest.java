package se.patrikbergman.java.yaml.jackson.anchor1;

import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceInputStream;
import se.patrikbergman.java.yaml.jackson.JacksonYamlUtil;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

@Slf4j
public class NodeDeserializationTest {

    private final static String SIMPLE_YAML_NATIVE =
            "---\n"
                    +"&1 name: \"first\"\n"
                    +"next:\n"
                    +"  &2 name: \"second\"\n"
                    +"  next: *1"
            ;

    @Test
    public void testBasicDeserializationWithMapper() throws Exception {
        log.info(SIMPLE_YAML_NATIVE);
        Node first = JacksonYamlUtil.INSTANCE
                .getMapper()
                .readValue(SIMPLE_YAML_NATIVE, Node.class);
        _verify(first);
    }

    @Test
    public void testBasickDeserializationWithReader() throws IOException {
        final ObjectReader reader = JacksonYamlUtil.INSTANCE.getReader().forType(Node.class);
        final InputStream in = new ResourceInputStream("jackson/anchor1/node.yaml");
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
