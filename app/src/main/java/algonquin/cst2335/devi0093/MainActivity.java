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
import android.widget.RadioButton;
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


        variableBinding.radioButton.setOnCheckedChangeListener( (btn,isChecked)->{
            model.isSelect.postValue(isChecked);


        });

        variableBinding.switch1.setOnCheckedChangeListener( (btn,isChecked)->{
            model.isSelect.postValue(isChecked);
        });


    }
}