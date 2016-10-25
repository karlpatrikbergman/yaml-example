package se.patrikbergman.java.yaml.basic;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public final class Configuration {
    private Date released;
    private String version;
    private Connection connection;
    private List<String> protocols;
    private Map<String, String> users;
}
