package com.example.android.selfmessages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView messages;
    Button sendMessage;
    EditText sendMessageEditText;
    EditText sendMessageSenderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messages = findViewById(R.id.messagesList);
        sendMessage = findViewById(R.id.sendMessage);
        sendMessageEditText = findViewById(R.id.sendMessageText);
        sendMessageSenderText = findViewById(R.id.userName);

        final ArrayList<Message> messagesArray = new ArrayList<>();
        final MessageAdapter adapter = new MessageAdapter(this, 0 ,messagesArray);

        messages.setAdapter(adapter);

        sendMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!sendMessageEditText.getText().toString().isEmpty())
                {
                    messagesArray.add(new Message(sendMessageSenderText.getText().toString(),
                            sendMessageEditText.getText().toString()));
                    messages.setAdapter(adapter);
                    sendMessageEditText.setText("");
                }
            }
        });
    }
}
