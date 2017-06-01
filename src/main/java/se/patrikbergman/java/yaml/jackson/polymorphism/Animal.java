package se.patrikbergman.java.yaml.jackson.polymorphism;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Lion.class, name = "lion"),
        @JsonSubTypes.Type(value = Elephant.class, name = "elephant")
})
public abstract class Animal {
    @JsonProperty("name")
    String name;
    @JsonProperty("sound")
    String sound;
    @JsonProperty("type")
    String type;
    @JsonProperty("endangered")
    boolean endangered;

}
