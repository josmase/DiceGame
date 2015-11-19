package lundberg.jonas.dicegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

public class StartGameActivity extends Activity {

    /**Message to send to new activity */
    public final static String EXTRA_MESSAGE = "jonas.lundberg.dicegame.MESSAGE";
    static final String STATE_SCORE = "playerScore";
    private Round round1;


    private TextView mTextView;
    /**
     * Sets the rule for the view upon creation    (1)
     *
     * @param  savedInstanceState I don't know                                                   (3)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
        round1 = new Round();
    }
    /**
     * starts a game of 21                                                      (1)
     * <p>
     * When the user press the play button startGame checks                     [2]
     * if it should continue or not
     * @param view I don't know
     */
    public void startGame(View view) {

        /**
         * gameStatus is used to pass the status of the game to the next activity
         */
        String gameStatus;
        /**
         * play is used to get the result of playing one round
         */
        int play = round1.play();
        if (round1.getScore() < 21) {
            round1.addScore(play);
            updateTextViewScore();

            if (round1.getScore() == 21) {
                gameStatus = getString(R.string.won);
                gameEnd(gameStatus);
            } else if (round1.getScore() > 21) {
                gameStatus = getString(R.string.lost);
                gameEnd(gameStatus);
            }

        }
    }
    /**
     * Updates the score display                           (1)
     */
    private void updateTextViewScore() {
        TextView tv = (TextView) findViewById(R.id.currentScore);
        tv.setText(Integer.toString(round1.getScore()));
    }

    /**
     * starts a new activity and sends a message.                           (1)
     * <p>
     * Sends a message of the result of the game to a new activity and starts a new activity.     [2]
     * @param  gameStatus  Saves the result of the game in a predefined string          (3)
     */
    private void gameEnd(String gameStatus) {
        Intent intent = new Intent(this, GameEndActivity.class);
        intent.putExtra(EXTRA_MESSAGE, gameStatus);
        startActivity(intent);
        finish();
    }
}
