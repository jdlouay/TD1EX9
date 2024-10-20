public class MotDict {

    private String mot;
    private String def;


    public MotDict(String mot, String def) {
        this.mot = mot;
        this.def = def;
    }


    public String getMot() {
        return this.mot;
    }


    public String getDefinition() {
        return this.def;
    }


    public void setDefinition(String def) {
        this.def = def;
    }


    public void setMot(String mot) {
        this.mot = mot;
    }


    public Boolean synonyme(String chaine) {

        return this.def.compareTo(chaine) == 0;
    }

    public boolean synoo(MotDict M) {

        return this.def.compareTo(M.def) == 0;
    }
}
