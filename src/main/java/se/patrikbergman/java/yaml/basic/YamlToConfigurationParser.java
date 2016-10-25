package se.patrikbergman.java.yaml.basic;

import org.yaml.snakeyaml.Yaml;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;
import java.io.InputStream;

final class YamlToConfigurationParser {

    public static Configuration parse(String resourceOnClassPath) throws IOException {
        Yaml yaml = new Yaml();
        InputStream in = new ResourceInputStream(resourceOnClassPath);
        return yaml.loadAs(in, Configuration.class);
    }
}
