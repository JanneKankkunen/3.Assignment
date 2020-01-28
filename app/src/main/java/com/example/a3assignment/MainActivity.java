package com.example.a3assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button buttonAddTime;
    EditText text;
    ListView listView;
    Calendar calendar = Calendar.getInstance();
    String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
    ArrayAdapter arrayAdapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        buttonAddTime = (Button) findViewById(R.id.buttonAddTime);
        buttonAddTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        listView=(ListView)findViewById(R.id.listview);
        //arrayList.add(currentDate);
        listView.setAdapter(arrayAdapter);

    }

    public void openDialog() {
        OpenDialog openDialog = new OpenDialog();
        openDialog.show(getSupportFragmentManager(), "open dialog");
    }
}

