package se.patrikbergman.java.yaml.snakeyml.anchor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.yaml.ObjectFromFileUtilSnakeYaml;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class AnchorYamlTest {

    @Test
    public void test() throws IOException {
        Person father = ObjectFromFileUtilSnakeYaml.INSTANCE.getObject("snakeyml/anchor/family.yml", Person.class);
        assertNotNull(father);

        Map<String, Person> children = father.getChildren();
        assertNotNull(children);

        assertEquals(1, children.size());
        Person child1 = children.get("child1");
        assertNotNull(child1);

        assertEquals(child1.getFather(), father);
    }
}
