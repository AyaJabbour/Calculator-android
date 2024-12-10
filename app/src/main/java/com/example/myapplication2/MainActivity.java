package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView tvLogin;
    EditText tvloginplain;
    TextView tvpassword;
    EditText tvpwtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnlogin), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn1 = findViewById(R.id.btn1);
        tvLogin = findViewById(R.id.tvlogin);
        tvloginplain = findViewById(R.id.tvloginplain);
        tvpassword = findViewById(R.id.tvpassword);
        tvpwtext = findViewById(R.id.tvpwtext);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = tvloginplain.getText().toString();
                String password = tvpwtext.getText().toString();

                // Vérification combinée des identifiants
                if (username.equals("AyaJabbour") && password.equals("123123")) {
                    // Si le nom d'utilisateur ET le mot de passe sont corrects
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                       // Affichage des messages d'erreur spécifiques
                        if (!username.equals("AyaJabbour")) {
                            Toast.makeText(MainActivity.this, "Invalid username", Toast.LENGTH_LONG).show();
                        }
                        if (!password.equals("123123")) {
                            Toast.makeText(MainActivity.this, "Invalid password", Toast.LENGTH_LONG).show();
                        }
                }
            }
        });
    }
}