package com.example.kalk212494;

import android.content.Context;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.content.Intent;




public class SimpleActivity extends AppCompatActivity {


    skrypty lacznik;
    TextView pole1;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        lacznik = new skrypty();
        pole1 = findViewById(R.id.liczby);

        lacznik.clear_all(pole1);
        context = getApplicationContext();
    }






    public void click(View view)
    {
        switch (view.getId())
        {
            case R.id.button_backspace:
                lacznik.backspace(pole1);
                break;
            case R.id.button_c:
                lacznik.clear_all(pole1);
                break;
            case R.id.button_0:
                lacznik.pisanie(pole1, "0");
                break;
            case R.id.button_1:
                lacznik.pisanie(pole1, "1");
                break;
            case R.id.button_2:
                lacznik.pisanie(pole1, "2");
                break;
            case R.id.button_3:
                lacznik.pisanie(pole1, "3");
                break;
            case R.id.button_4:
                lacznik.pisanie(pole1, "4");
                break;
            case R.id.button_5:
                lacznik.pisanie(pole1, "5");
                break;
            case R.id.button_6:
                lacznik.pisanie(pole1, "6");
                break;
            case R.id.button_7:
                lacznik.pisanie(pole1, "7");
                break;
            case R.id.button_8:
                lacznik.pisanie(pole1, "8");
                break;
            case R.id.button_9:
                lacznik.pisanie(pole1, "9");
                break;
            case R.id.button_plus:
                lacznik.dodawanie(pole1);
                break;
            case R.id.button_minus:
                lacznik.odejmowanie(pole1);
                break;
            case R.id.button_mnoznik:
                lacznik.mnozenie(pole1);
                break;
            case R.id.button_dzielnik:
                lacznik.dzielenie(pole1);
                break;
            case R.id.button_kropka:
                lacznik.pisanie(pole1, ".");
                break;
            case R.id.button_rowna:
                lacznik.rowna_sie(pole1,context);
                break;
            case R.id.button_znak:
                lacznik.zmiana_znaku(pole1);
                break;
        }


    }
}
