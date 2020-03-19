package com.example.kalk212494;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_advanced extends AppCompatActivity {

    skrypty_advanced lacznik2;
    TextView pole2;
    Context context2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        lacznik2 = new skrypty_advanced();
        pole2 = findViewById(R.id.pole2);

        lacznik2.clear_all(pole2);
        context2 = getApplicationContext();
    }

    public void click2(View view)
    {
        switch (view.getId())
        {
            case R.id.button_backspace2:
                lacznik2.backspace(pole2);
                break;
            case R.id.button_c2:
                lacznik2.clear_all(pole2);
                break;
            case R.id.button_0b:
                lacznik2.pisanie(pole2, "0");
                break;
            case R.id.button_1b:
                lacznik2.pisanie(pole2, "1");
                break;
            case R.id.button_2b:
                lacznik2.pisanie(pole2, "2");
                break;
            case R.id.button_3b:
                lacznik2.pisanie(pole2, "3");
                break;
            case R.id.button_4b:
                lacznik2.pisanie(pole2, "4");
                break;
            case R.id.button_5b:
                lacznik2.pisanie(pole2, "5");
                break;
            case R.id.button_6b:
                lacznik2.pisanie(pole2, "6");
                break;
            case R.id.button_7b:
                lacznik2.pisanie(pole2, "7");
                break;
            case R.id.button_8b:
                lacznik2.pisanie(pole2, "8");
                break;
            case R.id.button_9b:
                lacznik2.pisanie(pole2, "9");
                break;
            case R.id.button_plus2:
                lacznik2.dodawanie(pole2);
                break;
            case R.id.button_minus2:
                lacznik2.odejmowanie(pole2);
                break;
            case R.id.button_mnoznik2:
                lacznik2.mnozenie(pole2);
                break;
            case R.id.button_dzielnik2:
                lacznik2.dzielenie(pole2);
                break;
            case R.id.button_kropka2:
                lacznik2.pisanie(pole2, ".");
                break;
            case R.id.button_rowna2:
                lacznik2.rowna_sie2(pole2,context2);
                break;
            case R.id.button_znak2:
                lacznik2.zmiana_znaku(pole2);
                break;
            case R.id.button_procent:
                lacznik2.obliczanie_procentow(pole2,context2);
                break;
            case R.id.button_sqrt:
                lacznik2.inne_obl(pole2, 1, context2);
                break;
            case R.id.button_log:
                lacznik2.inne_obl(pole2, 2, context2);
                break;
            case R.id.button_ln:
                lacznik2.inne_obl(pole2, 3, context2);
                break;
            case R.id.button_potega:
                lacznik2.potega(pole2);
                break;
            case R.id.button_kwadrat:
                lacznik2.inne_obl(pole2, 5, context2);
                break;
            case R.id.button_sin:
                lacznik2.inne_obl(pole2, 6, context2);
                break;
            case R.id.button_cos:
                lacznik2.inne_obl(pole2, 7, context2);
                break;
            case R.id.button_tan:
                lacznik2.inne_obl(pole2, 8, context2);
                break;
        }

    }
}
