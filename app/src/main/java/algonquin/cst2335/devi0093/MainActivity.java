package algonquin.cst2335.devi0093;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import algonquin.cst2335.devi0093.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
        variableBinding.loginButton.setOnClickListener(click -> {
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            EditText emailEditText = variableBinding.editTextEmailAddress;
            nextPage.putExtra("email address",emailEditText.getText().toString());
            startActivity(nextPage);
        });
        ;

        Log.w( "MainActivity", "In onCreate() - Loading Widgets");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w( "MainActivity", "In onDestroy() - Destroying widgets" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w( "MainActivity", "In onPause() - Pausing Widgets" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w( "MainActivity", "In onResume() - Resume Widgets" );
    }

    //
}
