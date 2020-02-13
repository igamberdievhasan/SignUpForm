package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.EmptyStackException;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView logo = findViewById(R.id.logo);
        final TextView name = findViewById(R.id.nameView);
        final TextView email = findViewById(R.id.emailView);
        final TextView password = findViewById(R.id.passwordView);
        final TextView confirmPass = findViewById(R.id.confirmPassView);

        final EditText nameTextBox = findViewById(R.id.nameTextBox);
        final EditText emailTextBox = findViewById(R.id.emailTextBox);
        final EditText passwordTextBox = findViewById(R.id.passwordTextBox);
        final EditText confirmPassTextBox = findViewById(R.id.confirmPassTextBox);

        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(nameTextBox) || isEmpty(emailTextBox) || isEmpty(passwordTextBox) || isEmpty(confirmPassTextBox) ) {

                    if (nameTextBox.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Empty Text", Toast.LENGTH_SHORT).show();
                        name.setTextColor(Color.RED);

                    } else {
                        name.setTextColor(Color.GRAY);
                    }

                    if (emailTextBox.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Empty Text", Toast.LENGTH_SHORT).show();
                        email.setTextColor(Color.RED);

                    } else {
                        email.setTextColor(Color.GRAY);
                    }

                    if (passwordTextBox.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Empty Text", Toast.LENGTH_SHORT).show();
                        password.setTextColor(Color.RED);

                    } else {
                        password.setTextColor(Color.GRAY);
                    }

                    if (confirmPassTextBox.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Empty Text", Toast.LENGTH_SHORT).show();
                        confirmPass.setTextColor(Color.RED);

                    } else {
                        confirmPass.setTextColor(Color.GRAY);
                    }
                }else{
                    name.setTextColor(Color.GRAY);
                    email.setTextColor(Color.GRAY);
                    password.setTextColor(Color.GRAY);
                    confirmPass.setTextColor(Color.GRAY);

                    if (matchedPass(passwordTextBox, confirmPassTextBox) == false) {
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                        confirmPass.setTextColor(Color.RED);
                        password.setTextColor(Color.RED);
                    }else{
                        confirmPass.setTextColor(Color.GRAY);
                        password.setTextColor(Color.GRAY);
                        logo.setText("Welcome, "+ nameTextBox.getText().toString()+", to the SignUpForm App");
                    }


                }

            }
            boolean matchedPass(EditText password, EditText confirmPass){
                if(password.getText().toString().equals(confirmPass.getText().toString())) {
                    return true;
                }
                return false;
            }

            boolean isEmpty(EditText text) {
                CharSequence str = text.getText().toString();
                return TextUtils.isEmpty(str);
            }
        });


    }
}
