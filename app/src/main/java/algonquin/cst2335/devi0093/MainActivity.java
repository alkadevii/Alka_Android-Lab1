package algonquin.cst2335.devi0093;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Alka Devi
 * @version 1.0
 * This page takes password as an edit text and checks if the password meets
 * requirements upon clicking the login button
 *
 */

public class MainActivity extends AppCompatActivity {
    /**
     * This holds the text at the centre of the screen
     **/
    TextView tv = null;
    /**
     * This holds an edit text to enter password
     **/
    EditText et = null;
    /**
     * This holds a button that checks password when clicked
     **/
    Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //loads the XML file on the screen:
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textView);
        EditText et = findViewById(R.id.editTextPassword);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            boolean check = checkPasswordComplexity(password);
            if (!check) {
                tv.setText("You shall not pass");
            } else {
                tv.setText("Your password meets the requirements");
            }
        });
    }

    /**
     * This function checks the parameter passed and validates the login
     *
     * @param password the string object that we are checking
     * @return Returns true if password is good and false if password is not good.
     */
    boolean checkPasswordComplexity(String password) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        String upperCase = "(.*[A-Z].*)";
        String lowerCase = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[@,#,$,%].*$)";
        if (password.matches(upperCase)) {
            foundUpperCase = true;
        }
        if (password.matches(lowerCase)) {
            foundLowerCase = true;
        }
        if (password.matches(numbers)) {
            foundNumber = true;
        }
        if (password.matches(specialChars)) {
            foundSpecial = true;

        }

        if (!foundUpperCase) {
            String message = "password should contain atleast one uppercase letter";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show(); // Say that they are missing an upper case letter;

            return false;

        } else if (!foundLowerCase) {
            String message = "password should contain atleast one lowercase letter";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show(); //say that they are missing lowercase letter
            return false;

        } else if (!foundNumber) {
            String message = "password should contain atleast one numeric value";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show(); //say that they are missing numeric value
            return false;

        } else if (!foundSpecial) {
            String message = "password should contain atleast one special character";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show(); //say that they are missing special character
            return false;
        } else {
            return true; //only get here if they're all true
        }
    }
}

