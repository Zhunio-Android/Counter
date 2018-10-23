package com.zhunio.counter;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    /** Allows user to see count message (i.e. Count: 3). */
    private Button mButtonCounter;

    /** Allows user to decrement the count. */
    private Button mButtonDecrement;

    /** Current count */
    private int count;

    /**
     * Called when the user clicks the Reset button.
     *
     * @param view view that was clicked.
     */
    public void onReset(View view) {
        count = 0;
        enableOrDisableDecrementButton();
        updateCounter();
    }

    /**
     * Called when the user clicks the Increment button.
     *
     * @param view view that was clicked.
     */
    public void onIncrement(View view) {
        count++;
        enableOrDisableDecrementButton();
        updateCounter();
    }

    /**
     * Called when the user clicks the Decrement button.
     *
     * @param view view that was clicked.
     */
    public void onDecrement(View view) {
        count--;
        enableOrDisableDecrementButton();

        if (count <= 0) {
            count = 0;
            updateCounter();
        } else
            updateCounter();
    }

    /**
     * If the count is less than or equal to zero, the Decrement button is disabled, otherwise, the
     * Decrement button is enabled.
     */
    private void enableOrDisableDecrementButton() {
        mButtonDecrement.setEnabled(count > 0);

    }

    /** Updates the Counter button with the current count. */
    private void updateCounter() {
        // Set text to (i.e. Counter: 0)
        String text = getResources().getString(R.string.counter) + " " + String.valueOf(count);
        mButtonCounter.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonCounter = findViewById(R.id.button_counter);
        mButtonDecrement = findViewById(R.id.button_decrement);

        count = 0;

        enableOrDisableDecrementButton();

        // Enables Always-on
        setAmbientEnabled();
    }
}
