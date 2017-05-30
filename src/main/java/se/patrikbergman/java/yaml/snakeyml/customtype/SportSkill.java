package se.patrikbergman.java.yaml.snakeyml.customtype;

import lombok.Data;

@Data
public class SportSkill implements BaseSkill {
    private String name;
    private String description;
    private String sport;
}
