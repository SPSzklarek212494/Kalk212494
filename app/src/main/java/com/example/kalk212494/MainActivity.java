package com.example.kalk212494;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void przejscie(View view)
    {
        switch (view.getId())
        {
            case R.id.button_simple:
                startActivity(new Intent(MainActivity.this, SimpleActivity.class));
                break;
            case R.id.button_advanced:
                startActivity(new Intent(MainActivity.this, Activity_advanced.class));
                break;
            case R.id.button_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
            case R.id.button_exit:
                finish();
                break;
        }
    }


}
