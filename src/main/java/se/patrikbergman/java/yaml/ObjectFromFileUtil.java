package se.patrikbergman.java.yaml;

public interface ObjectFromFileUtil {
    <T> T getObject(String path, Class<T> clazz) throws RuntimeException;
}

