package lundberg.jonas.dicegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

public class GameEndActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity_game_end);
        /*
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
        */
        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(StartGameActivity.EXTRA_MESSAGE);
        updateTextViewScore(message);

    }
    public void startGame(View view) {
        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);
        finish();
    }
    private void updateTextViewScore(String message) {
        TextView tv = (TextView) findViewById(R.id.gameState);
        tv.setText(message);
    }
}
