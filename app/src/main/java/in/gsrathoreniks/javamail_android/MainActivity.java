package in.gsrathoreniks.javamail_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender("YOUR_EMAIL@GMAIL.COM",
                            "YOUR_PASSWORD");
                    sender.sendMail("EMAIL SUBJECT", "EMAIL BODY",
                            "SENDER_EMAIL@GMAIL.COM", "RECIPIENTS_EMAIL@gmail.com");
                    Log.d("SendMail","Success");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }

        }).start();
    }
}
