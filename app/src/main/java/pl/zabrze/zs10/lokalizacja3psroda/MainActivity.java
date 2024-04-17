package pl.zabrze.zs10.lokalizacja3psroda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int REQUEST_LOCATION_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pobierzLokalizacje();
                    }
                }
        );
    }

    private void pobierzLokalizacje(){
        if(ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission
                            .ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION
            );
        }
        else {
            Toast.makeText(this, "wyrażono zgodę", Toast.LENGTH_SHORT).show();
        }
    }

}