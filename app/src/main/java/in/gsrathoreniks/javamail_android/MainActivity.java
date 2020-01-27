package in.gsrathoreniks.javamail_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

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
                    GMailSender sender = new GMailSender("niks.gajsa@gmail.com",
                            "7891238567");
                    Uri uri = Uri.fromFile(new File("//assets/text.txt"));
                    String filepath = uri.getPath();
                    Log.d(LOG_TAG,filepath);
                    sender.sendMail("EMAIL SUBJECT", "EMAIL BODY",
                            "niks.gajsa@gmail.com", "niks.gajsa@gmail.com");
                    Log.d(LOG_TAG,"Success");
                } catch (Exception e) {
                    Log.e(LOG_TAG, e.getMessage(), e);
                }
            }

        }).start();
    }
}
