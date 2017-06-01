package se.patrikbergman.java.yaml.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;
import se.patrikbergman.java.utility.resource.ResourceInputStream;
import se.patrikbergman.java.yaml.ObjectFromFileUtil;
import se.patrikbergman.java.yaml.jackson.customtype2.Tpd10gbe;
import se.patrikbergman.java.yaml.jackson.customtype2.Tpmr2500;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public enum ObjectFromFileUtilJackson implements ObjectFromFileUtil {
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
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        mapper.registerSubtypes(Tpd10gbe.class, Tpmr2500.class);

//        mapper.enableDefaultTyping(); // default to using DefaultTyping.OBJECT_AND_NON_CONCRETE
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
