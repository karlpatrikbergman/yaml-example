package se.patrikbergman.java.yaml.jackson.customtype2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Tpd10gbe.class, name = "tpd10gbe"),
        @JsonSubTypes.Type(value = Tpmr2500.class, name = "tpmr2500")
})
public interface Board {
    String getName();

    String getBoardEntry();
}
