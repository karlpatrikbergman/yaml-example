package se.patrikbergman.java.yaml.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public enum JacksonYamlUtil {
    INSTANCE;

    final ObjectMapper mapper;

    JacksonYamlUtil() {
        mapper = new ObjectMapper(new YAMLFactory());
        SimpleModule module = new SimpleModule();
//        module.addDeserializer(Slot.SlotKeyType.class, new SlotKeyTypeDeserializer());
//        module.addDeserializer(BoardType.class, new BoardTypeDeserializer());
//        module.addDeserializer(LinePortType.class, new LinePortTypeDeserializer());
//        module.addDeserializer(ClientPortType.class, new ClientPortTypeDeserializer());
        mapper.registerModule(module);

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public ObjectReader getReader() {
        return mapper.reader();
    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
