package se.patrikbergman.java.yaml.snakeyml.customtype2;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Tpmr2500 implements Board {
    private String name;
    private String client;
    private String groupOrTable;
    private String module;
    private String tpmr2500SpecificField;

    public void tpmr2500SpecificMethod() {
        log.info("Executing tpmr2500 specific method");
    }

    @Override
    public String getBoardEntry() {
        return name + " " + client +" " + groupOrTable + " " + module;
    }
}
