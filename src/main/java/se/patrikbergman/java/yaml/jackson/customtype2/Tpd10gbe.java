package se.patrikbergman.java.yaml.jackson.customtype2;

import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Value
@Builder
public class Tpd10gbe implements Board {
    private String name;
    private String client;
    private String groupOrTable;
    private String module;
    private String tpd10gbeSpecificField;

    public void tpd10gbeSpecificMethod() {
        log.info("Executing tpd10gbe specific method");
    }

    @Override
    public String getBoardEntry() {
        return name + " " + client +" " + groupOrTable + " " + module;
    }
}
