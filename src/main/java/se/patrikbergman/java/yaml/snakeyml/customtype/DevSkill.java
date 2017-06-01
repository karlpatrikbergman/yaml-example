package se.patrikbergman.java.yaml.snakeyml.customtype;

import lombok.Data;

@Data
public class DevSkill implements BaseSkill {
    private String name;
    private String description;
    private String language;

    @Override
    public String getAll() {
        return name + " " + description + " " + language;
    }
}
