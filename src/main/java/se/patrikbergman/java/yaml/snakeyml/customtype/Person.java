package se.patrikbergman.java.yaml.snakeyml.customtype;

import lombok.Data;

import java.util.Map;

@Data
public class Person {
    private int age;
    private String job;
    private String name;
    private Map<String, BaseSkill> skills;
}
