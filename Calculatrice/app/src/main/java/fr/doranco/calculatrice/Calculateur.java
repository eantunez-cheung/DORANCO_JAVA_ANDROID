package fr.doranco.calculatrice;

public class Calculateur {
    private float resultat;
    private OperateurEnum operateurEnum;
    private float operande;
    private String operation = "";

    public Calculateur() {
    }

    public void concatenerChiffreOperande(float chiffre) {
        if (chiffre >= 0 && chiffre < 10) {
            setOperande(operande * 10 + chiffre);
        }
    }

    public void concatenerOperation(String value){
        String str = getOperation();
        setOperation(getOperation() + value);
    }

    public void effacerOperande() {
        String strOperande = String.valueOf(operande);
        String newOperande = strOperande.substring(0, strOperande.length() - 1);
        if (newOperande.length() == 0) {
            setOperande(0);
        } else {
            setOperande(Integer.valueOf(newOperande));
        }
    }

    public void calculer() {
        switch (operateurEnum) {
            case ADDITION:
                resultat += operande;
                break;
            case SOUSTRACTION:
                resultat -= operande;
                break;
            case MULTIPLICATION:
                resultat *= operande;
                break;
            case DIVISION:
                resultat /= operande;
            default:
                return;
        }
    }

    public float getResultat() {
        return resultat;
    }

    public void setResultat(float resultat) {
        this.resultat = resultat;
    }

    public OperateurEnum getOperateurEnum() {
        return operateurEnum;
    }

    public void setOperateurEnum(OperateurEnum operateurEnum) {
        this.operateurEnum = operateurEnum;
    }

    public float getOperande() {
        return operande;
    }

    public void setOperande(float operande) {
        this.operande = operande;
        if (operateurEnum == null) {
            setResultat(operande);
        }
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
