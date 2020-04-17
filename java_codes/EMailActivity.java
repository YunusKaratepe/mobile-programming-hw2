package com.yunuskaratepe.e_mailapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EMailActivity extends AppCompatActivity {

    private EditText etMailReceiver;
    private EditText etMailTopic;
    private EditText etMailMessage;
    private EditText etMailSender;
    private TextView tvFilePath;
    private Intent fileIntent;
    private Uri file;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.hello_android);
        setContentView(R.layout.activity_email);

        etMailSender = findViewById(R.id.sender);
        etMailReceiver = findViewById(R.id.receiver);
        etMailTopic = findViewById(R.id.topic);
        etMailMessage = findViewById(R.id.mail);
        tvFilePath = findViewById(R.id.filePath);

        Button buttonSendMail = findViewById(R.id.button_sendMail);
        buttonSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

        Button buttonAddFile = findViewById(R.id.button_addFile);
        buttonAddFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                fileIntent.setType("*/*");
                startActivityForResult(fileIntent, 10);

            }
        });



    }

    public void sendMail(){

        String sender = etMailSender.getText().toString();
        String receivers = etMailReceiver.getText().toString(); // maili 1 den fazla kisi alabilir
        String[] receiverList = receivers.split(",");

        String topic =  etMailTopic.getText().toString();
        String message = etMailMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, sender);
        intent.putExtra(Intent.EXTRA_EMAIL, receiverList);
        intent.putExtra(Intent.EXTRA_SUBJECT, topic);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_STREAM, file);

        intent.setType("message/rfc822"); // sadece e-mail uygulamaları tarafından alınacağını söylüyoruz.
        startActivity(Intent.createChooser(intent, "Select an e-mail app."));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 10:
                if(resultCode == RESULT_OK){
                    file = data.getData();
                    String filePath = data.getData().getPath();
                    tvFilePath.setText(filePath);
                }
                break;
        }
    }


}
