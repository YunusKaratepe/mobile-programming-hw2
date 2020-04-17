package com.yunuskaratepe.e_mailapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private int loginCount;
    static User currentUser;

    static ArrayList<User> users = new ArrayList<User>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // all users
        Bitmap user1Image = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.cartman);
        Bitmap user2Image = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.kenny);
        Bitmap user3Image = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.kyle);
        User u1 = new User("Cartman", "123", user1Image);
        User u2 = new User("Kenny", "456", user2Image);
        User u3 = new User("Kyle", "789", user3Image);
        users.add(u1);
        users.add(u2);
        users.add(u3);

        loginCount = 0;


    }

    public void login(View v){

        username = findViewById(R.id.textView2);
        password = findViewById(R.id.password);


        if( username.getText().toString().matches("") || password.getText().toString().matches("") ){
            Toast.makeText(getApplicationContext(), "Areas can't be empty.", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        for (User u: users) {
            if(u.getUserName().matches(username.getText().toString()) &&
                    u.getPassword().matches(password.getText().toString())){
                currentUser = u;
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                return;
            }
        }
        loginCount++;
        if(loginCount >= 3){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Login Failed!");
            builder.setMessage("You entered wrong username-password 3 times. App will end now.");
            builder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    finish();
                }
            });
            builder.show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Wrong username or password!", Toast.LENGTH_SHORT)
                .show();
    }


 }