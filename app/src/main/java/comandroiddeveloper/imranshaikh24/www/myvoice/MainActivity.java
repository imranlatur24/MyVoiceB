package comandroiddeveloper.imranshaikh24.www.myvoice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ListeningActivity {

    private LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (LinearLayout)findViewById(R.id.commands);

        // The following 3 lines are needed in every onCreate method of a ListeningActivity
        context = getApplicationContext(); // Needs to be set
        VoiceRecognitionListener.getInstance().setListener(this); // Here we set the current listener
        startListening(); // starts listening
    }

    // Here is where the magic happens
    @Override
    public void processVoiceCommands(String... voiceCommands) {
        content.removeAllViews();
        for (String command : voiceCommands) {
            TextView txt = new TextView(getApplicationContext());
            txt.setText(command);
            txt.setTextSize(20);
            txt.setTextColor(Color.BLACK);
            txt.setGravity(Gravity.CENTER);
            content.addView(txt);
        }
        restartListeningService();
    }
}