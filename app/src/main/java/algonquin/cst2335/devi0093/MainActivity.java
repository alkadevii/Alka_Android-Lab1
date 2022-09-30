package algonquin.cst2335.devi0093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.devi0093.databinding.ActivityMainBinding;
import algonquin.cst2335.devi0093.R;
import algonquin.cst2335.devi0093.databinding.ActivityMainBinding;
import data.MainActivityViewModel;
import data.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.flagView);
        sw = findViewById(R.id.Switch1);

        sw.setOnCheckedChangeListener( (btn, isChecked) -> {
            if (isChecked)
            {
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(5000);
                rotate.setRepeatCount(Animation.INFINITE);
                rotate.setInterpolator(new LinearInterpolator());

                imgView.startAnimation(rotate);
            }
            else {
                imgView.clearAnimation();
            }

        });
    }

//
}
