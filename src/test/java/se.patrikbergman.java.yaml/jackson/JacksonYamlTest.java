package se.patrikbergman.java.yaml.jackson;

import com.fasterxml.jackson.databind.ObjectReader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class JacksonYamlTest {

//    @Ignore
    @Test
    public void test() throws IOException {

        final ObjectReader reader = JacksonYamlUtil.INSTANCE.getReader().forType(Person.class);
        final InputStream in = new ResourceInputStream("jackson/family.yml");
        final Person father = reader.readValue(in);

        assertNotNull(father);

        Map<String, Person> children = father.getChildren();
        assertNotNull(children);

        assertEquals(2, children.size());
        Person child1 = children.get("child1");
        assertNotNull(child1);

        assertEquals(child1.getFather(), father);
    }
}
