package se.patrikbergman.java.yaml.jackson;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Node {
    public String name;

    public Node next;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }
}

