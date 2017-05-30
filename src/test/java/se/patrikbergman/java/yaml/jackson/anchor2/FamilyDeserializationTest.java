package se.patrikbergman.java.yaml.jackson.anchor2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import se.patrikbergman.java.yaml.jackson.ObjectFromFileUtilJackson;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class FamilyDeserializationTest {

//    @Ignore
    @Test
    public void test() throws IOException {
        final Person father = ObjectFromFileUtilJackson.INSTANCE.getObject("jackson/anchor2/family.yml", Person.class);
        assertNotNull(father);

        Map<String, Person> children = father.getChildren();
        assertNotNull(children);

        assertEquals(2, children.size());
        Person child1 = children.get("child1");
        assertNotNull(child1);

        assertEquals(child1.getFather(), father);
    }
}
