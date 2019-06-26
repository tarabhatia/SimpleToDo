package com.example.simpleto_do;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.simpleto_do.MainActivity.ITEM_POSITION;
import static com.example.simpleto_do.MainActivity.ITEM_TEXT;

public class EditItemActivity extends AppCompatActivity {

    // track edit text
    EditText eItemText;
    // position of edited item in list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        // resolve edit text from layout
        eItemText = findViewById(R.id.eItemText);
        // set edit text value from intent extra
        eItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        // update position from intent extra
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        // update the title bar of activity
        getSupportActionBar().setTitle("Edit Item");
    }

    // handler for save button
    public void onSaveItem(View v) {
        // prepare new intent for result
        Intent i = new Intent();
        // pass updated item text as extra
        i.putExtra(ITEM_TEXT, eItemText.getText().toString());
        // pass original position as extra
        i.putExtra(ITEM_POSITION, position);
        // set the intent as the result of the activity
        setResult(RESULT_OK, i);
        // close the activity and redirect to main
        finish();
    }

}
