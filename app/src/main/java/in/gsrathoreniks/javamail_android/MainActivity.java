package in.gsrathoreniks.javamail_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "SendMail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void SendEmail(View view) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender("YOUR_EMAIL@GMAIL.COM",
                            "YOUR_PASSWORD");
                    sender.sendMail("EMAIL SUBJECT", "EMAIL BODY",
                            "SENDER_EMAIL@GMAIL.COM", "RECIPIENTS_EMAIL@gmail.com");
                    Log.d(LOG_TAG,"Success");
                } catch (Exception e) {
                    Log.e(LOG_TAG, e.getMessage(), e);
                }
            }

        }).start();
    }
}
