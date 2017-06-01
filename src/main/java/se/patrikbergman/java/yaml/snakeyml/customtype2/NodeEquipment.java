package se.patrikbergman.java.yaml.snakeyml.customtype2;

import lombok.Data;

import java.util.Map;

@Data
public class NodeEquipment {
    private Map<String, Board> boards;
}
