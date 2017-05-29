package se.patrikbergman.java.yaml.advanced;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.representer.Representer;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;
import java.io.InputStream;

final class YamlParser {

    public static Person parse(String resourceOnClassPath) throws IOException {
        InputStream in = new ResourceInputStream(resourceOnClassPath);
        return getYaml().loadAs(in, Person.class);
    }

    private static Yaml getYaml() {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Representer representer = new Representer();
        PropertyUtils propertyUtils = representer.getPropertyUtils();
        propertyUtils.setSkipMissingProperties(true);
        return new Yaml(new Constructor(), representer, options);
    }
}
