package com.example.android.phobuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // for swipe right
        gestureDetector = new GestureDetector(this);
    }
    // for swipe right.
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
        boolean result = false;
        float diffY = moveEvent.getY() - downEvent.getY();
        float diffX = moveEvent.getX() - downEvent.getX();
        //Which is greater?
        if (Math.abs(diffX) > Math.abs(diffY)) {
            // right or left swipe
            if (Math.abs(diffX) > 100 && Math.abs(velocityX) > 100) {
                if (diffX > 0) {
                    onSwipeRight();
                } else {
                    onSwipeLeft();
                }
                result = true;
            }
        } else {
            // up or down swipe
            if (Math.abs(diffY) > 100 && Math.abs(velocityY) > 100) {
                if (diffY > 0) {
                    onSwipeBottom();
                } else {
                    onSwipeTop();
                }
                result = true;
            }
        }

        return result;
    }

    private void onSwipeBottom() {
    }

    private void onSwipeLeft() {
    }

    private void onSwipeRight() {
        Toast.makeText(this, "Swipe Left to Search", Toast.LENGTH_LONG).show();
        Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(startIntent);
    }

    private void onSwipeTop() {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
