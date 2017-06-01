package se.patrikbergman.java.yaml;

import se.patrikbergman.java.yaml.snakeyml.ObjectFromFileUtilSnakeYaml;

public enum ObjectFromFileUtilFactory {
    INSTANCE;

    public static ObjectFromFileUtil getObjectFromFileUtil() {
        return ObjectFromFileUtilSnakeYaml.INSTANCE;
    }
}
