package com.itrainasia.motionevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private float lastKnownX;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        Toast.makeText(this, "Touch Screen to Generate a Motion Event",
                Toast.LENGTH_LONG).show();
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                lastKnownX = event.getX();
                break;
            }

            
            case MotionEvent.ACTION_UP: {

                float currentX = event.getX();
                if (lastKnownX < currentX) {
                    // Left To Right
                    Toast.makeText(this,
                            "Left To Right Motion Detected Text Visible",
                            Toast.LENGTH_SHORT).show();
                    textView.setVisibility(View.VISIBLE);
                }
                if (lastKnownX > currentX) {
                    // Right To Left
                    Toast.makeText(this,
                            "Right To Left Motion Detected Text Invisible",
                            Toast.LENGTH_SHORT).show();
                    textView.setVisibility(View.INVISIBLE);
                }
                break;
            }

        }
        return false;
    }
}
