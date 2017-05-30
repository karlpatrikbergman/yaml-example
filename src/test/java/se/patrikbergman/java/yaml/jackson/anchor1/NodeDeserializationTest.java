package se.patrikbergman.java.yaml.jackson.anchor1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.yaml.jackson.ObjectFromFileUtilJackson;

import java.io.IOException;

import static org.junit.Assert.*;

@Slf4j
public class NodeDeserializationTest {

    @Test
    public void testBasickDeserializationWithReader() throws IOException {
        final Node node = ObjectFromFileUtilJackson.INSTANCE.getObject("jackson/anchor1/node.yaml", Node.class);
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
