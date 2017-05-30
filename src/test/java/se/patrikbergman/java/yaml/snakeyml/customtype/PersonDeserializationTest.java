package se.patrikbergman.java.yaml.snakeyml.customtype;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.representer.Representer;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

@Slf4j
public class PersonDeserializationTest {

    @Test
    public void test() throws IOException {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Representer representer = new Representer();
        PropertyUtils propertyUtils = representer.getPropertyUtils();
        propertyUtils.setSkipMissingProperties(true);
        Yaml yaml = new Yaml(new Constructor(), representer, options);

        ResourceInputStream resourceInputStream = new ResourceInputStream("snakeyml/customotype/person.yml");
        Person person = (Person) yaml.loadAs(resourceInputStream, Person.class);

        assertNotNull(person.getName());
        assertNotNull(person.getSkills());
        assertNotNull(person.getSkills().get("devSkill"));

        log.info(person.toString());

    }
}
