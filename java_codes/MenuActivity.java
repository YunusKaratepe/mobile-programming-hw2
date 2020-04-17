package com.yunuskaratepe.e_mailapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void goMailScreen(View v){
        Intent intent = new Intent(MenuActivity.this, EMailActivity.class);
        startActivity(intent);
    }
    public void goUserList(View v){
        Intent intent = new Intent(MenuActivity.this, UserListActivity.class);
        startActivity(intent);
    }
    public void goUserPreferences(View v){
        Intent intent = new Intent(MenuActivity.this, UpdatePreferencesActivity.class);
        startActivity(intent);
    }


}
