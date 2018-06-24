package site.lizihanglove.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import site.lizihanglove.loading.Loading;

public class MainActivity extends AppCompatActivity {

    private ImageView animLeft;
    private ImageView animRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Loading.Builder(MainActivity.this)
                .setCancelable(false)
                .build()
                .show();


    }
}

