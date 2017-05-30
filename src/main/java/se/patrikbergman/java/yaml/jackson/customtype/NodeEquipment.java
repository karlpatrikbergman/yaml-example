package se.patrikbergman.java.yaml.jackson.customtype;

import lombok.Data;

import java.util.Map;

@Data
public class NodeEquipment {
    private Map<String, Board> boards;
//    Board board;
}
