package com.example.browser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView am,yt;
    EditText tittle_view;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am=findViewById(R.id.am);
        yt=findViewById(R.id.yt);
        search=findViewById(R.id.search);

        tittle_view=findViewById(R.id.tittle_view);
        String amz="https://amazon.com";
        String you="https://youtube.com";



        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Webactivity.class);
                intent.putExtra("links",amz);
                startActivity(intent);
            }
        });
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Webactivity.class);
                intent.putExtra("links",you);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String go=tittle_view.getText().toString();
                String url="https://"+go+".com";
                Intent intent=new Intent(getApplicationContext(),Webactivity.class);
                intent.putExtra("links",url);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Attention!");
            builder.setMessage("Are you sure you want to exit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();
                }
            });
            builder.create().show();
        }

}