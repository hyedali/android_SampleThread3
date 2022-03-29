package com.example.samplethread3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });
    }

    class BackgroundThread extends Thread{
        int value = 0;

        public void run(){
            for(int i=0; i<100; i++){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}

                value += 1;

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("value의 값 : " + value);
                    }
                });
            }
        }
    }
}