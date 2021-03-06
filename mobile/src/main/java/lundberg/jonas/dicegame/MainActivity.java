package lundberg.jonas.dicegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user clicks the Start button nd opens a new activity of startGame  */
    public void startGame(View view) {
        Intent intent = new Intent(this, StartGameActivity.class);
        startActivity(intent);
    }
    /** Called when the user clicks the Highcsore button and opens a new activity of Highscore  */
    public void highscore(View view) {
        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);
    }

}
