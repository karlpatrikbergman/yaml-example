package se.patrikbergman.java.yaml.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;
import se.patrikbergman.java.utility.resource.ResourceInputStream;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public enum ObjectFromFileUtilJackson {
    INSTANCE;

    private final ObjectMapper mapper;

    public <T> T getObject(String path, Class<T> clazz) throws RuntimeException {
        try {
            InputStream in = new ResourceInputStream(path);
            final ObjectReader reader = mapper.reader().forType(clazz);
            return reader.readValue(in);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    ObjectFromFileUtilJackson() {
        mapper = new ObjectMapper(new YAMLFactory());
        SimpleModule module = new SimpleModule();
        mapper.registerModule(module);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
