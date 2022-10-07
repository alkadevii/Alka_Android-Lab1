package algonquin.cst2335.devi0093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import algonquin.cst2335.devi0093.databinding.ActivityMainBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromPrevious =getIntent();
        String emailAddress=fromPrevious.getStringExtra("email address");
        TextView textView=findViewById(R.id.welcomeTextview);
        textView.setText("Welcome back "+ emailAddress);
    }
}