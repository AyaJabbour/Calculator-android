package com.example.myapplication2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity3 extends AppCompatActivity {
    ConstraintLayout linearLayout;
    Button back;
    Intent intent;
    //On déclare toutes les variables dont on aura besoin
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMoins;
    Button buttonDiv;
    Button buttonMul;
    Button buttonC;
    Button buttonEgal;
    Button buttonPoint;
    Button buttonsqrt;
    Button button1surx;
    Button xaucarre;
    Button buttonCE2;
    Button buttonCE;
    Button buttonpourcentage;

    TextView ecran;
    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonpoint);
        buttonPlus = (Button) findViewById(R.id.buttonplus);
        buttonMoins = (Button) findViewById(R.id.buttonmois);
        buttonDiv = (Button) findViewById(R.id.buttondiv);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        ecran =  findViewById(R.id.textView2);

        buttonsqrt= findViewById(R.id.buttonsqrt);
        xaucarre=findViewById(R.id.buttonxaucarre);

        button1surx=findViewById(R.id.button1surx);
        buttonpourcentage=findViewById(R.id.buttonpourcentage);
        buttonCE2=findViewById(R.id.buttonCE2);
        buttonCE=findViewById(R.id.buttonCE);

        button1surx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                unsurxClick();
            }
        });
        buttonCE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                supprimerDernierCaractere();
            }
        });
        buttonCE2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                supprimerDernierCaractere();
            }
        });
        buttonpourcentage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pourcentageClick();
            }
        });

        buttonsqrt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqrtClick();
            }
        });
        xaucarre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                carreClick();
            }
        });
        //On attribue un écouteur d'évènement à tous les boutons
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });
        buttonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });
        buttonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });



        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent=new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        linearLayout=findViewById(R.id.main);

    }
    public void unsurxClick() {
        double value = Double.parseDouble(ecran.getText().toString());
        if (value != 0) {
            value = 1 / value; // Calcul de l'inverse
            ecran.setText(String.valueOf(value));
            update = true;
        } else {
            ecran.setText("Erreur"); // Gestion de la division par zéro
        }
    }
    //---------------------------------
    public void pourcentageClick() {
        double value = Double.parseDouble(ecran.getText().toString());
        value = value / 100; // Calcul du pourcentage
        ecran.setText(String.valueOf(value));
        update = true;
    }
    //---------------------------------
    public void supprimerDernierCaractere() {
        String affichage = ecran.getText().toString();
        if (!affichage.isEmpty()) {
            affichage = affichage.substring(0, affichage.length() - 1); // Supprime le dernier caractère
            ecran.setText(affichage);
        } else {
            ecran.setText("0"); // Si l'écran est vide, on affiche "0"
        }
    }

    //voici la méthode qui est exécutée lorsqu'on clique sur un bouton chiffre
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!ecran.getText().equals("0"))
                str = ecran.getText() + str;
        }
        ecran.setText(str);
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton +
    public void plusClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton -
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton *
    public void mulClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton /
    public void divClick(){
        if(clicOperateur){
            calcul();
            ecran.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton =
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }
    //voici la méthode qui est exécutée lorsque l'on clique sur le bouton C
    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        ecran.setText("");
    }
    public void carreClick() {
        double value = Double.parseDouble(ecran.getText().toString());
        value = Math.pow(value, 2); // Élévation au carré
        ecran.setText(String.valueOf(value));
        update = true; // Permet de réinitialiser l'écran lors de la prochaine saisie
    }
    public void sqrtClick() {
        double value = Double.parseDouble(ecran.getText().toString());
        if (value >= 0) {
            value = Math.sqrt(value);
            ecran.setText(String.valueOf(value));
            update = true; // Permet de réinitialiser l'écran lors de la prochaine saisie
        } else {
            ecran.setText("Erreur"); // Gestion des racines carrées de nombres négatifs
        }
    }
    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul() {
        if (operateur.equals("+")) {
            chiffre1 = chiffre1 +
                    Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("-")) {
            chiffre1 = chiffre1 -
                    Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("*")) {
            chiffre1 = chiffre1 *
                    Double.valueOf(ecran.getText().toString()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if (operateur.equals("/")) {
            try {
                chiffre1 = chiffre1 /
                        Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            } catch (ArithmeticException e) {
                ecran.setText("0");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.standard) {
            Snackbar.make(linearLayout, "are you sure", Snackbar.LENGTH_LONG).setAction("yes", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(linearLayout, "Operation annulée", Snackbar.LENGTH_LONG).setTextColor(Color.WHITE).setBackgroundTint(Color.RED).show();
                    startActivity( new Intent(MainActivity3.this,MainActivity2.class));
                }
            }).setActionTextColor(Color.WHITE).setTextColor(Color.GREEN).show();
            return true;
        } else if (id == R.id.scientifique) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}