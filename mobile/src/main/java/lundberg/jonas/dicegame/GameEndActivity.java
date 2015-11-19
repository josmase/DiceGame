package lundberg.jonas.dicegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameEndActivity extends AppCompatActivity {

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
     * takes the user to the start screen                          (1)
     */
    public void startScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
    /**
     * takes the user to a new game of 21                         (1)
     */
    public void startGame(View view) {
        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);
        finish();

    }
}
