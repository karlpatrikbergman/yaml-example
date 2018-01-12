package se.patrikbergman.java.yaml.jackson.customtype2;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Value
@Builder
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
