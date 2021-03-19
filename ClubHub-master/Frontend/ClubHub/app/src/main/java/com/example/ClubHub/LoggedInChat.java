package com.example.ClubHub;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Chat that only users who are logged in can participate in
 */
public class LoggedInChat extends AppCompatActivity {

    /**
     * Buttons that allow the user to send a message
     */
    Button  bt,b2;
    /**
     * Editable text sections
     */
    EditText e1,e2, clubName;

    /**
     * Text view to display the chat to the user
     */
    TextView t1;

    /**
     * String to hold messageTwo
     */
    String message2 = "";

    /**
     * Client for the websocket
     */
    private WebSocketClient cc;

    /**
     * Logged in chat uses the websockets to implement chat for logged in users with a custom username
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_chat);
        bt=(Button)findViewById(R.id.bt);
        b2=(Button)findViewById(R.id.bt2);
        e2=(EditText)findViewById(R.id.et2);
        t1=(TextView)findViewById(R.id.tx1);

        clubName = (EditText)findViewById(R.id.clubChatText);

        //Make the textView scrollable
        t1.setMovementMethod(new ScrollingMovementMethod());

        final String userName = getIntent().getStringExtra("userName");

        Draft[] drafts = {new Draft_6455()};

        /**
         * If running this on an android device, make sure it is on the same network as your
         * computer, and change the ip address to that of your computer.
         * If running on the emulator, you can use localhost.
         */
        //ws://hostname:8080/chat/{user name/id}
        String w = "ws://cs309-pp-4.misc.iastate.edu:8080/websocket/"+userName;

        try {
            Log.d("Socket:", "Trying socket");
            cc = new WebSocketClient(new URI(w),(Draft) drafts[0]) {
                @Override
                public void onMessage(String message) {
                    Log.d("", "run() returned: " + message);
                    //String s=t1.getText().toString();
                    //t1.setText(s+message +"\n");
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

        bt.setOnClickListener(new View.OnClickListener() {
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
                    w = "ws://cs309-pp-4.misc.iastate.edu:8080/websocket/" + clubName.getText() + "/" + userName;
                }
                else{
                    w = "ws://cs309-pp-4.misc.iastate.edu:8080/websocket/"+userName;
                }

                try {
                    Log.d("Socket:", "Trying socket");
                    cc = new WebSocketClient(new URI(w),(Draft) drafts[0]) {
                        @Override
                        public void onMessage(String message) {
                            Log.d("", "run() returned: " + message);

                            t1.setBackgroundColor(Color.rgb(123, 169, 242));

                            if(message.contains("Joined")){
                                message2 = "<font color=black>" + message2 + "</font>" + "<font color=red>" + message + "</font><br>";
                            }
                            else{
                                String[] tokens = message.split(":");
                                message2 = "<font color=black>" + message2 + "</font>" + "<font color=yellow>" + tokens[0] + ":" + "</font>" + "<font color=black>" + tokens[1] + "</font><br>";
                            }

                            t1.setText(Html.fromHtml(message2));
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

