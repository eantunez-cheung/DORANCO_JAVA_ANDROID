package fr.doranco.calculatrice;

public enum OperateurEnum {
    ADDITION("+"),
    SOUSTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String operateur;

    private OperateurEnum(String operateur) {
        this.operateur = operateur;
    }

    public String getOperateur() {
        return operateur;
    }
}
