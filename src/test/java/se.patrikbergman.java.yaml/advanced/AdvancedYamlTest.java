package se.patrikbergman.java.yaml.advanced;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class AdvancedYamlTest {

    @Test
    public void test() throws IOException {
        Person father = YamlParser.parse("advanced/family.yml");
        assertNotNull(father);

        Map<String, Person> children = father.getChildren();
        assertNotNull(children);

        assertEquals(1, children.size());
        Person child1 = children.get("child1");
        assertNotNull(child1);

        assertEquals(child1.getFather(), father);
    }
}
