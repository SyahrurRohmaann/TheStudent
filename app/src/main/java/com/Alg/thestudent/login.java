package com.Alg.thestudent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    private void login() {
        EditText Username, Password, cPassword;
        Password = findViewById(R.id.edtPassword);
        cPassword = findViewById(R.id.edtPassword2);
        Username = findViewById(R.id.edtUsername);
        btnlogin=findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Username.getText().toString();
                String pass = Password.getText().toString();
                String cPass = cPassword.getText().toString();


                if (user.equals("alung221") && pass.equals("123")) {
                    if (pass.equals(cPass)) {
                        Intent intent = new Intent(login.this, Dashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(login.this, "Password dan Konfirmasi Password tidak sama", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(login.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
