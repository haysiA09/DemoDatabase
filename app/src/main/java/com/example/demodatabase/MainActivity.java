package com.example.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert=findViewById(R.id.buttonInsert);
        btnGetTasks=findViewById(R.id.buttonGetTask);
        tvResults=findViewById(R.id.textViewResults);
        lv=findViewById(R.id.ListView);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //create the db helper object passing activity's context
                DBHelper db=new DBHelper(MainActivity.this);

                //insert task
                db.insertTask("Submit RJ","25 Apr 2016");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the DBHelper object, passing int the activity's context
                DBHelper db= new DBHelper(MainActivity.this);
                //insert task
                ArrayList<String> data =db.getTaskContent();
                db.close();

                String txt="";
                for(int i=0;i<data.size();i++){
                    Log.d("Database Content",i+". "+data.get(i));
                    txt += i+". "+data.get(i)+"\n";

                }
                tvResults.setText(txt);
            }
        });

        task=new ArrayList<Task>();
        task.add(new Task(" "));


    }
}
