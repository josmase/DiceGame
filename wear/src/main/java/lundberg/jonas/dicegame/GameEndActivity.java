package lundberg.jonas.dicegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameEndActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);
        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(StartGameActivity.EXTRA_MESSAGE);

        // Create the text view
        TextView textView = (TextView) findViewById(R.id.gameState);
        textView.setText(message);
    }

    /**
     * takes the user to a new game of 21                         (1)
     * @param view necessary for creating a new view
     */
    public void startGame(View view) {
        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);
        finish();

    }
}
