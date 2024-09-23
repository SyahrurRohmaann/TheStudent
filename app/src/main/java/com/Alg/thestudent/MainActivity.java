package com.Alg.thestudent;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button register;
        TextView txtLogin;
        EditText tglLahir, namaLengkap, Nim, Alamat, Email, noHP, Username, Password;
        Spinner Gender;
        namaLengkap=findViewById(R.id.edt_namalengkap);
        Nim=findViewById(R.id.edt_nim);
        Alamat=findViewById(R.id.edt_alamat);
        Email=findViewById(R.id.edt_email);
        noHP=findViewById(R.id.edt_phone);
        Gender=findViewById(R.id.spin_gender);
        tglLahir=findViewById(R.id.edt_tgllahir);
        Username=findViewById(R.id.edt_username);
        Password=findViewById(R.id.edt_password);
        register=findViewById(R.id.button);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });

        tglLahir.setOnClickListener(v->{
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this,(view, year1, monthOfYear, dayOfMonth) -> {
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                tglLahir.setText(selectedDate);
            }, year, month, day);
            datePicker.show();
        });

    }
}