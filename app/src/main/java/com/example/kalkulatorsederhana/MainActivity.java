package com.example.kalkulatorsederhana;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.example.kalkulatorsederhana.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private EditText etAngkaPertama, etAngkaKedua;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        etAngkaPertama = binding.etAngkaPertama;
        etAngkaKedua = binding.etAngkaKedua;
        tvHasil = binding.tvHasil;
        // Setup listeners for operation buttons
        setupOperationButtons();
    }

    private void setupOperationButtons() {
        AppCompatButton btnTambah = binding.btntambah;
        AppCompatButton btnKurang = binding.btnKurang;
        AppCompatButton btnKali = binding.btnKali;
        AppCompatButton btnBagi = binding.btnBagi;

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('+');
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('-');
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('*');
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('/');
            }
        });
    }

    private void hitung(char operator) {
        String strAngkaPertama = etAngkaPertama.getText().toString();
        String strAngkaKedua = etAngkaKedua.getText().toString();

        if (strAngkaPertama.isEmpty() || strAngkaKedua.isEmpty()) {
            tvHasil.setText("Masukkan kedua angka terlebih dahulu");
            return;
        }

        double angkaPertama = Double.parseDouble(strAngkaPertama);
        double angkaKedua = Double.parseDouble(strAngkaKedua);
        double hasil = 0;

        switch (operator) {
            case '+':
                hasil = angkaPertama + angkaKedua;
                break;
            case '-':
                hasil = angkaPertama - angkaKedua;
                break;
            case '*':
                hasil = angkaPertama * angkaKedua;
                break;
            case '/':
                if (angkaKedua == 0) {
                    tvHasil.setText("Tidak bisa membagi dengan nol");
                    return;
                }
                hasil = angkaPertama / angkaKedua;
                break;
        }

        tvHasil.setText(String.valueOf(hasil));
    }
}
