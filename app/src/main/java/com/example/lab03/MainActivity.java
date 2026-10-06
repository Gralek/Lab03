package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editClientName;
    private RadioGroup radioGroupSize;
    private CheckBox checkBoxExtraCheese;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editClientName = findViewById(R.id.editClientName);
        radioGroupSize = findViewById(R.id.radioGroupSize);
        checkBoxExtraCheese = findViewById(R.id.checkBoxExtraCheese);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> {
            String clientName = editClientName.getText().toString().trim();


            if (TextUtils.isEmpty(clientName)) {
                editClientName.setError("Nazwa klienta nie może być pusta!");
                return;
            }


            String pizzaSize = "Nie wybrano";
            int selectedId = radioGroupSize.getCheckedRadioButtonId();

            if (selectedId == R.id.radioSmall) {
                pizzaSize = "Mała";
            } else if (selectedId == R.id.radioMedium) {
                pizzaSize = "Średnia";
            } else if (selectedId == R.id.radioLarge) {
                pizzaSize = "Duża";
            }


            boolean hasExtraCheese = checkBoxExtraCheese.isChecked();


            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);


            intent.putExtra("KLUCZ_NAZWA", clientName);
            intent.putExtra("KLUCZ_ROZMIAR", pizzaSize);
            intent.putExtra("KLUCZ_SER", hasExtraCheese);


            startActivity(intent);
        });
    }
}