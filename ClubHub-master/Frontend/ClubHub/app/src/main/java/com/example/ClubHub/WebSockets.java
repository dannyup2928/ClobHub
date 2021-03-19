package com.example.ClubHub;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ClubHub.R;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Chat function to be available to all users
 */
public class WebSockets extends AppCompatActivity {

    /**
     * Buttons to allow the user to send a message and register in the chat
     */
    Button  b1,b2;
    /**
     * Text the user is able to send and modify
     */
    EditText e1,e2, clubName;
    /**
     * TextView variable to show messages
     */
    TextView t1;

    /**
     * Message field two
     */
    String message2 = "";

    /**
     * WebSocket variable to contain the chat
     */
    private WebSocketClient cc;

    /**
     * Creates the layout for the page and differentiates the chat from User chat by checking if the
     * user is a member of any of the clubs
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_sockets);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        t1=(TextView)findViewById(R.id.tx1);

        clubName = (EditText)findViewById(R.id.ClubChat);

        //Make the textView scrollable
        t1.setMovementMethod(new ScrollingMovementMethod());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Draft[] drafts = {new Draft_6455()};

                /**
                 * If running this on an android device, make sure it is on the same network as your
                 * computer, and change the ip address to that of your computer.
                 * If running on the emulator, you can use localhost.
                 */
                //ws://hostname:8080/chat/{user name/id}
                String w;

                if(clubName.length() > 0){
                    w = "ws://cs309-pp-4.misc.iastate.edu:8080/websocket/" + clubName.getText() + "/" + e1.getText().toString();
                }
                else{
                    w = "ws://cs309-pp-4.misc.iastate.edu:8080/websocket/"+e1.getText().toString();
                }

                try {
                    Log.d("Socket:", "Trying socket");
                    cc = new WebSocketClient(new URI(w),(Draft) drafts[0]) {
                        @Override
                        public void onMessage(String message) {

                            Log.d("", "run() returned: " + message);
                            String s = t1.getText().toString();
                            //t1.setText(Html.fromHtml("<font color=red>" + message + "</font><br><br>"));

                            t1.setBackgroundColor(Color.rgb(123, 169, 242));

                            if(message.contains("Joined")){
                                message2 = "<font color=black>" + message2 + "</font>" + "<font color=red>" + message + "</font><br>";
                            }
                            else{
                                String[] tokens = message.split(":");
                                message2 = "<font color=black>" + message2 + "</font>" + "<font color=yellow>" + tokens[0] + ":" + "</font>" + "<font color=black>" + tokens[1] + "</font><br>";
                            }

                            t1.setText(Html.fromHtml(message2));

                            //t1.setText(s + message + "\n");
                            //t1.setTextColor(Color.WHITE);

                            //Spanned display = Html.fromHtml(s + "<font color=blue>" + message + "\n" + "</font><br><br> < br/>");
                        }

                        @Override
                        public void onOpen(ServerHandshake handshake) {
                            Log.d("OPEN", "run() returned: " + "is connecting");
                        }

                        @Override
                        public void onClose(int code, String reason, boolean remote) {
                            Log.d("CLOSE", "onClose() returned: " + reason);
                        }

                        @Override
                        public void onError(Exception e)
                        {
                            Log.d("Exception:", e.toString());
                        }
                    };
                }
                catch (URISyntaxException e) {
                    Log.d("Exception:", e.getMessage().toString());
                    e.printStackTrace();
                }
                cc.connect();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cc.send(e2.getText().toString());
                    e2.setText("");
                }
                catch (Exception e)
                {
                    Log.d("ExceptionSendMessage:", e.getMessage().toString());
                }
            }
        });
    }
}

