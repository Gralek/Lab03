package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView textSummary;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


        textSummary = findViewById(R.id.textSummary);
        buttonBack = findViewById(R.id.buttonBack);


        Intent intent = getIntent();

        if (intent != null) {

            String clientName = intent.getStringExtra("KLUCZ_NAZWA");
            String pizzaSize = intent.getStringExtra("KLUCZ_ROZMIAR");
            boolean hasExtraCheese = intent.getBooleanExtra("KLUCZ_SER", false);


            String cheeseText = hasExtraCheese ? "Tak" : "Nie";

            String summaryResult = "Podsumowanie zamówienia:\n\n" +
                    "Klient: " + clientName + "\n" +
                    "Rozmiar pizzy: " + pizzaSize + "\n" +
                    "Dodatkowy ser: " + cheeseText;


            textSummary.setText(summaryResult);
        }


        buttonBack.setOnClickListener(v -> {
            finish();
        });
    }
}
