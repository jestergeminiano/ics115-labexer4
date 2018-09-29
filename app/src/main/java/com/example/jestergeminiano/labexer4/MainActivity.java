package com.example.jestergeminiano.labexer4;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.design.widget.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button toastBtn = findViewById(R.id.toastBtn);
        Button snackbarBtn = findViewById(R.id.snackbarBtn);
        Button snackbaractBtn = findViewById(R.id.snackbaractBtn);
        final ConstraintLayout constraintLayout = findViewById(R.id.main_layout_id);

        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "TOAST!";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(getApplicationContext(),message,duration).show();
            }
        });

        snackbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.main_layout_id);
                String message = "Snackbar message";
                int duration = Snackbar.LENGTH_SHORT;

                showSnackbar(view, message, duration);
            }
        });

        snackbaractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Snackbar snackbar = Snackbar
                        .make(constraintLayout, "Succesfully removed", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Snackbar snackbarAction = Snackbar.make(constraintLayout, "Succesfully Restored!", Snackbar.LENGTH_SHORT);
                                snackbarAction.show();
                            }
                        });
                snackbar.show();

            }
        });

    }


    public void showSnackbar(View view, String message, int duration)
    {
        Snackbar.make(view, message, duration).show();
    }


}
