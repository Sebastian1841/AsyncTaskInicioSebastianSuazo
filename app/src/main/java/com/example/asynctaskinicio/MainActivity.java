package com.example.asynctaskinicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private Button btn_1;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et_Usuario);
        et2 = findViewById(R.id.et_pass);
        btn_1 = findViewById(R.id.btn_inicio);
        pb = findViewById(R.id.pb_inicio);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute(et1.getText().toString());

            }
        });
    }
    class Task extends AsyncTask<String, Void ,String>{

        @Override
        protected void onPreExecute(){
            pb.setVisibility(View.VISIBLE);
            btn_1.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            return strings[0];
        }

        @Override
        protected void onPostExecute(String s){
            pb.setVisibility(View.GONE);
            btn_1.setEnabled(true);

            Intent intent = new Intent(MainActivity.this, Resultado.class);
            intent.putExtra("Usuario", s);
            startActivity(intent);
        }
    }
}