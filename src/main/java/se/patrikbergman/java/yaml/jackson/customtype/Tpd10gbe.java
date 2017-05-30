package se.patrikbergman.java.yaml.jackson.customtype;

public class Tpd10gbe implements Board {
    private String name;

    public Tpd10gbe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
