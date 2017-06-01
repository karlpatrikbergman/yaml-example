package se.patrikbergman.java.yaml.jackson.customtype2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@Data
public class NodeEquipment {
    private Map<String, Board> boards;
}
