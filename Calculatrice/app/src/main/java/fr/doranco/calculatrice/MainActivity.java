package fr.doranco.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final Calculateur calculateur;
    private boolean isCaculate = false;
    private boolean isOperateur = false;

    public MainActivity() {
        this.calculateur = new Calculateur();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textViewResultat = this.findViewById(R.id.txt_resulstat);
        final TextView txtOperation = this.findViewById(R.id.txt_operation);
        final Button btnEgal = this.findViewById(R.id.btn_egal);
        final Button btnReset = this.findViewById(R.id.btn_reset);
        final Button btnClear = this.findViewById(R.id.btn_clear);

        final List<Button> buttonsOperateurs = new ArrayList<Button>();
        buttonsOperateurs.add(findViewById(R.id.btn_plus));
        buttonsOperateurs.add(findViewById(R.id.btn_moins));
        buttonsOperateurs.add(findViewById(R.id.btn_mult));
        buttonsOperateurs.add(findViewById(R.id.btn_div));

        final List<Button> buttonsChiffres = new ArrayList<Button>();
        buttonsChiffres.add(findViewById(R.id.btn_decimal_point));
        buttonsChiffres.add(findViewById(R.id.btn_zero));
        buttonsChiffres.add(findViewById(R.id.btn_un));
        buttonsChiffres.add(findViewById(R.id.btn_deux));
        buttonsChiffres.add(findViewById(R.id.btn_trois));
        buttonsChiffres.add(findViewById(R.id.btn_quatre));
        buttonsChiffres.add(findViewById(R.id.btn_cinq));
        buttonsChiffres.add(findViewById(R.id.btn_six));
        buttonsChiffres.add(findViewById(R.id.btn_sept));
        buttonsChiffres.add(findViewById(R.id.btn_huit));
        buttonsChiffres.add(findViewById(R.id.btn_neuf));

        for (Button buttonChiffre : buttonsChiffres) {
            buttonChiffre.setOnClickListener(view -> {
                Button b = (Button) view;
                float chiffreSaisi = Float.parseFloat(b.getText().toString());
                calculateur.concatenerChiffreOperande(chiffreSaisi);
                textViewResultat.setText(calculateur.getOperande() + "");
            });
        }

        for (Button buttonOperateur : buttonsOperateurs) {
            buttonOperateur.setOnClickListener(view -> {
                Button b = (Button) view;
                String operateur = b.getText().toString();
                if (isOperateur){
                    calculateur.calculer();
                }
                switch (operateur) {
                    case "+":
                        calculateur.setOperateurEnum(OperateurEnum.ADDITION);
                        break;
                    case "-":
                        calculateur.setOperateurEnum(OperateurEnum.SOUSTRACTION);
                        break;
                    case "*":
                        calculateur.setOperateurEnum(OperateurEnum.MULTIPLICATION);
                        break;
                    case "/":
                        calculateur.setOperateurEnum(OperateurEnum.DIVISION);
                        break;
                    default:
                        return;
                }
                if (operateur != null) {
                    if (isCaculate) {
                        calculateur.setOperande(0);
                        calculateur.setOperation("");
                        calculateur.concatenerOperation(calculateur.getResultat() + operateur);
                    } else {
                        calculateur.concatenerOperation(calculateur.getOperande() + operateur);
                        calculateur.setOperande(0);
                        textViewResultat.setText("0");
                    }
                    txtOperation.setText(calculateur.getOperation());
                    calculateur.setOperande(0);
                    isOperateur = true;
                    isCaculate = false;
                }
            });
        }

        btnReset.setOnClickListener(view -> {
            calculateur.setResultat(0);
            calculateur.setOperande(0);
            calculateur.setOperateurEnum(null);
            textViewResultat.setText("0");
            calculateur.setOperation("");
            txtOperation.setText("");
            isOperateur = false;
            isCaculate = false;
        });

        btnClear.setOnClickListener(view -> {
            if (!isCaculate) {
                calculateur.effacerOperande();
                textViewResultat.setText(calculateur.getOperande() + "");
            }
        });

        btnEgal.setOnClickListener(view -> {
            if (calculateur.getOperateurEnum().equals(OperateurEnum.DIVISION) && calculateur.getOperande() == 0) {
                textViewResultat.setText("Division par zero impossible !");
            } else {
                calculateur.calculer();
                textViewResultat.setText(calculateur.getResultat() + "");
                calculateur.concatenerOperation(calculateur.getOperande() + "=");
                txtOperation.setText(calculateur.getOperation());
            }
            isCaculate = true;
            isOperateur = false;
        });
    }
}