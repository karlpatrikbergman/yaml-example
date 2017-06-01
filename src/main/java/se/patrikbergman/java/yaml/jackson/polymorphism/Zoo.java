package se.patrikbergman.java.yaml.jackson.polymorphism;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class Zoo {

    public String name;
    public String city;
    public List<Animal> animals;

    @JsonCreator
    public Zoo(@JsonProperty("name") String name, @JsonProperty("city") String city) {
        this.name = name;
        this.city = city;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo [name=" + name + ", city=" + city + ", animals=" + animals + "]";
    }

}
