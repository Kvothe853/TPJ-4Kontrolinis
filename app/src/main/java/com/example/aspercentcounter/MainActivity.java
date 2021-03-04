package com.example.aspercentcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView percentText;
    private SeekBar seekBar;
    private Button result;
    private EditText amount;
    private TextView tip;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentText = findViewById(R.id.percentText);
        seekBar = findViewById(R.id.seekBar);
        result = findViewById(R.id.result);
        amount = findViewById(R.id.amount);
        tip = findViewById(R.id.tip);
        total = findViewById(R.id.total);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentText.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(amount.getText().toString().equals("")) {
                        String errorText = "Please enter number!";
                        errorMessage(errorText);
                    } else {
                        int sk = Integer.parseInt(amount.getText().toString());
                        int percent = Integer.parseInt(percentText.getText().toString());

                        double totalResult = (sk / 100.00) * percent;
                        totalResult = Math.floor(totalResult * 100) / 100;

                        double totalTip = sk - totalResult;
                        totalTip = Math.floor(totalTip * 100) / 100;

                        tip.setText(String.valueOf(totalResult));
                        total.setText(String.valueOf(totalTip));
                    }
                } catch (NumberFormatException ignored) {

                    }
                }
                private void errorMessage(String errorText){
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, errorText, duration);
                    toast.show();
                }
        });
    }
}