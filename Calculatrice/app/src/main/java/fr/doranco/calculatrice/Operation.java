package fr.doranco.calculatrice;

public class Operation {

    private float operande1;
    private float operande2;
    private OperateurEnum operateurEnum;
    private float resultat;

    public float getOperande1() {
        return operande1;
    }

    public void setOperande1(float operande1) {
        this.operande1 = operande1;
    }

    public float getOperande2() {
        return operande2;
    }

    public void setOperande2(float operande2) {
        this.operande2 = operande2;
    }

    public OperateurEnum getOperateurEnum() {
        return operateurEnum;
    }

    public void setOperateurEnum(OperateurEnum operateurEnum) {
        this.operateurEnum = operateurEnum;
    }

    public float getResultat() {
        return resultat;
    }

    public void setResultat(float resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return operande1 + " "
                + operateurEnum.getOperateur() + " "
                + operande2 + " = "
                + resultat;
    }
}
