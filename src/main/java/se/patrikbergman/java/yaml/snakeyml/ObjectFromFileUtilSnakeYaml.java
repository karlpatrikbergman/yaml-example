package se.patrikbergman.java.yaml.snakeyml;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.PropertyUtils;
import org.yaml.snakeyaml.representer.Representer;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public enum ObjectFromFileUtilSnakeYaml {
    INSTANCE;

    public <T> T getObject(String path, Class<T> clazz) throws RuntimeException {
        try {
            InputStream in = new ResourceInputStream(path);
            return getYaml().loadAs(in, clazz);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
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
