package com.example.android.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        SeekBar seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setMax(20);
        seekbar.setProgress(5);

        generateTable(5);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTable;
                if(progress<1)
                {
                    timesTable=min;
                    seekBar.setProgress(min);
                }else
                    timesTable=progress;
                generateTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }

    public void generateTable(int number)
    {
        ArrayList<String> tables = new ArrayList<String>();
        for(int i=1;i<=10;i++)
        {
            tables.add(Integer.toString(i*number));

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tables);
        listView.setAdapter(arrayAdapter);

    }
}
