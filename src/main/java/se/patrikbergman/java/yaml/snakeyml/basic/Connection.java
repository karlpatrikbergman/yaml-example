package se.patrikbergman.java.yaml.snakeyml.basic;

import lombok.Data;

@Data
public final class Connection {
    private String url;
    private int poolSize;
}
