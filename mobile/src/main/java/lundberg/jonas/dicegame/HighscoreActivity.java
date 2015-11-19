package lundberg.jonas.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class HighscoreActivity extends AppCompatActivity {
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        db = new DatabaseHelper(getApplicationContext());
        highscore();
    }
    /**
     * Displays highscore                           (1)
     * <p>
     * uses the SQlite to get highscores and uppdate te texview to show the highscores     [2]
     */
    public void highscore(){
        TextView tv = (TextView) findViewById(R.id.highscore);
        List<Integer> scores = db.getAllEntries();
        for(int score : scores) {
            tv.append("\n" + score);
        }
    }
}
