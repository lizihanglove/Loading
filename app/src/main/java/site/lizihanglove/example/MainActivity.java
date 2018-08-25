package site.lizihanglove.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import site.lizihanglove.loading.Loading;
import site.lizihanglove.loading.Rotating;

public class MainActivity extends AppCompatActivity {

    private ImageView animLeft;
    private ImageView animRight;
    private Loading loading;
    private Rotating rotating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loading = new Loading.Builder(MainActivity.this)
                .setCancelable(true)
                .build();
        rotating = new Rotating.Builder(MainActivity.this)
                .setCancelable(true)
                .build();
    }

    public void loading(View view) {
        loading.show();
    }

    public void rotating(View view) {
        rotating.show();
    }
}

