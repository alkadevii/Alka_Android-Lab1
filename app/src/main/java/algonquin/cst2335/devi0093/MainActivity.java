package algonquin.cst2335.devi0093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.devi0093.databinding.ActivityMainBinding;
import algonquin.cst2335.devi0093.R;
import algonquin.cst2335.devi0093.databinding.ActivityMainBinding;
import data.MainActivityViewModel;
import data.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel model;
    private ActivityMainBinding variableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        super.onCreate(savedInstanceState);

//        loads the XML file on screen
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());


        variableBinding.myButton.setOnClickListener(click ->
        {
            model.isSelected.postValue(variableBinding.editMessage.getText().toString());

        });

        model.isSelected.observe(this, newString -> {
            variableBinding.firstString.setText("Your edit text has:" + newString);


        });
        variableBinding.checkbox.setOnCheckedChangeListener( (btn,isChecked)->{
            model.isSelect.postValue(isChecked);
            variableBinding.firstString.setText("The value is now:" + isChecked);
        }); variableBinding.RadioButton.setOnCheckedChangeListener( (btn,isChecked)->{
            model.isSelect.postValue(isChecked);
            variableBinding.firstString.setText("The value is now:" + isChecked);
        });
        variableBinding.Switch.setOnCheckedChangeListener( (btn,isChecked)->{
            model.isSelect.postValue(isChecked);
            variableBinding.firstString.setText("The value is now:" + isChecked);
        });

        variableBinding.Imageview.setImageResource(R.drawable.logo_algonquin);
        variableBinding.Imageview.setOnClickListener(click ->
                Toast.makeText(this,"You Clicked on image",Toast.LENGTH_SHORT).show()
        );


        model.isSelect.observe(this, selected -> {
            variableBinding.checkbox.setChecked(selected);
            variableBinding.RadioButton.setChecked(selected);
            variableBinding.Switch.setChecked(selected);

            Context context = getApplicationContext();
            CharSequence text = "You clicked the value and it is now:" +selected;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        });
    }
}