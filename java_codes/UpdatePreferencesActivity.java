package com.yunuskaratepe.e_mailapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import static com.yunuskaratepe.e_mailapplication.MainActivity.currentUser;

public class UpdatePreferencesActivity extends AppCompatActivity {

    EditText age, weight, height, mail;
    ImageView imageView;
    TextView username, selectedLanguage;
    Spinner spinner;
    String strAge, strWeight, strHeight, strMail, strLanguage, strGender, strTheme;
    SharedPreferences sharedPreferences;
    RadioGroup radioGroupGender, radioGroupTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_preferences);

        imageView = findViewById(R.id.updatePreferences_image);
        username = findViewById(R.id.updatePreferences_username);
        age = findViewById(R.id.updatePreferences_age);
        weight = findViewById(R.id.updatePreferences_weight);
        height = findViewById(R.id.updatePreferences_height);
        mail = findViewById(R.id.updatePreferences_mail);
        radioGroupGender = findViewById(R.id.updatePreferences_genderRadioGroup);
        radioGroupTheme = findViewById(R.id.updatePreferences_themeRadioGroup);
        spinner = findViewById(R.id.updatePreferences_language_spinner);
        selectedLanguage = findViewById(R.id.updatePreferences_languageTxt);

        //username ve user image static olarak alınıyor.
        imageView.setImageBitmap(currentUser.getImage());
        username.setText(currentUser.getUserName());

        sharedPreferences = this.getSharedPreferences("com.yunuskaratepe.e_mailapplication", Context.MODE_PRIVATE);

        strAge = sharedPreferences.getString(currentUser.getUserName() + ",age", "");
        strWeight = sharedPreferences.getString(currentUser.getUserName() + ",weight", "");
        strHeight = sharedPreferences.getString(currentUser.getUserName() + ",height", "");
        strLanguage = sharedPreferences.getString(currentUser.getUserName() + ",language", "");
        strMail = sharedPreferences.getString(currentUser.getUserName() + ",mail", "");
        strTheme = sharedPreferences.getString(currentUser.getUserName() + ",theme", "");
        strGender = sharedPreferences.getString(currentUser.getUserName() + ",gender", "");

        age.setText(strAge);
        weight.setText(strWeight);
        height.setText(strHeight);
        mail.setText(strMail);
        selectedLanguage.setText(strLanguage);
        if(strGender.matches("Male")){
            radioGroupGender.check(R.id.radio_male);
        }else if(strGender.matches("Female")){
            radioGroupGender.check(R.id.radio_female);
        }
        if(strTheme.matches("Dark")){
            radioGroupTheme.check(R.id.radio_dark);
        }else if(strTheme.matches("Light")){
            radioGroupTheme.check(R.id.radio_light);
        }

    }

    public void updatePreferences(View v){


        // ayni username 2 user olamayacağına göre:
        sharedPreferences.edit().putString(currentUser.getUserName() + ",age", age.getText().toString()).apply();
        sharedPreferences.edit().putString(currentUser.getUserName() + ",weight", weight.getText().toString()).apply();
        sharedPreferences.edit().putString(currentUser.getUserName() + ",height", height.getText().toString()).apply();
        sharedPreferences.edit().putString(currentUser.getUserName() + ",mail", mail.getText().toString()).apply();
        sharedPreferences.edit().putString(currentUser.getUserName() + ",language", spinner.getSelectedItem().toString()).apply();

        int id = radioGroupTheme.getCheckedRadioButtonId();
        if(id != -1){
            RadioButton rb = findViewById(id);
            sharedPreferences.edit().putString(currentUser.getUserName() + ",theme", rb.getText().toString()).apply();
        }
        id = radioGroupGender.getCheckedRadioButtonId();
        if(id != -1){
            RadioButton rb = findViewById(id);
            sharedPreferences.edit().putString(currentUser.getUserName() + ",gender", rb.getText().toString()).apply();
        }

    }


}
