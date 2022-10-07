package algonquin.cst2335.devi0093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.devi0093.databinding.ActivityMainBinding;
import algonquin.cst2335.devi0093.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromPrevious =getIntent();
        String emailAddress=fromPrevious.getStringExtra("email address");
        TextView textView=findViewById(R.id.welcomeTextview);
        textView.setText("Welcome back "+ emailAddress);

        variableBinding.callPhone.setOnClickListener(clk -> {
            EditText phoneNumber = variableBinding.editTextPhone;
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:"+phoneNumber));
        });

    }
}