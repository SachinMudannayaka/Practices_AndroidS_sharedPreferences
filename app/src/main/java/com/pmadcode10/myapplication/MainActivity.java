package com.pmadcode10.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Button btnsave,btnload;
 EditText txtname,txtage;
 String name;
 int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave=findViewById(R.id.savebutton);
        btnload=findViewById(R.id.viewbutton);

        txtname=findViewById(R.id.name);
        txtage=findViewById(R.id.age);

        btnsave.setOnClickListener((v)->{
            name=txtname.getText().toString();
            age=Integer.parseInt(txtage.getText().toString());
            SharedPreferences prferen=getSharedPreferences("Summary",MODE_PRIVATE);
            SharedPreferences.Editor edit= prferen.edit();
            edit.putString("name",name);
            edit.putInt("age",age);
            edit.commit();
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();



        });

         btnload.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 SharedPreferences prf=getSharedPreferences("Summary",MODE_PRIVATE);

                 String name=prf.getString("name","No name");
                 int age=prf.getInt("age",0);
                 Toast.makeText(MainActivity.this, "Your Name: "+name+"Your age "+age, Toast.LENGTH_SHORT).show();
             }
         });
    }
}