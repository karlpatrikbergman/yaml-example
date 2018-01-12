package se.patrikbergman.java.yaml.jackson.customtype2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@Value
@Builder
public class NodeEquipment {
    private final Map<String, Board> boards;
}
