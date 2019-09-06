package br.com.bossini.etanolougasolina;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    SeekBar sb;
    SeekBar sb2;
    private TextView vgaso;
    private TextView veta;
    private TextView total;
    private TextView melhorUsar;

    private ImageView imageView3;

    private double valuet;
    private double value;
    private double evalue;

    private Drawable drawable;
    private Drawable drawable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawable = getResources().getDrawable(R.drawable.gasolina);
        drawable2 = getResources().getDrawable(R.drawable.etanol);

        sb = (SeekBar) findViewById(R.id.seekBar);
        vgaso =findViewById(R.id.vgaso);

        sb2 = (SeekBar)  findViewById(R.id.seekBar2);
        veta =findViewById(R.id.veta);

        total =findViewById(R.id.total);
        imageView3 = findViewById(R.id.imageView3);
        melhorUsar = findViewById(R.id.melhorUsar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int progress, boolean b) {
                value = progress;
                vgaso.setText(currencyFormat.format(value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb) {
                valuet = evalue/value;
                total.setText(currencyFormat.format(valuet));

                if (valuet >= 0.7){
                    melhorUsar.setText("gasolina");
                    imageView3.setImageDrawable(drawable);
                }
                if (valuet < 0.7){
                    melhorUsar.setText("etanol");
                    imageView3.setImageDrawable(drawable2);
                }
            }
        });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb2, int progress1, boolean b) {
                evalue = progress1;
                veta.setText(currencyFormat.format(evalue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar sb2) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb2) {
                valuet = evalue/value;
                total.setText(currencyFormat.format(valuet));

                if (valuet >= 0.7){
                    melhorUsar.setText("gasolina");
                    imageView3.setImageDrawable(drawable);
                }
                if (valuet < 0.7){
                    melhorUsar.setText("etanol");
                    imageView3.setImageDrawable(drawable2);
                }
            }
        });
    }
}
