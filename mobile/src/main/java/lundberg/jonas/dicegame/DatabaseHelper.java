package lundberg.jonas.dicegame;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.provider.BaseColumns;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by knugen on 11/13/15.
 * Hanadles creation of database and input/output
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    /**
     * Metadata about the table for the app
     */
    public static abstract class ScoreEntry implements BaseColumns {
        public static final String TABLE_NAME = "highscore_21";
        public static final String COLUMN_NAME_SCORE = "score";
    }

    /**
     * Helper strings, as Google suggests to be used.
     */
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ScoreEntry.TABLE_NAME + " (" +
                    ScoreEntry._ID + " INTEGER PRIMARY KEY," +
                    ScoreEntry.COLUMN_NAME_SCORE + INTEGER_TYPE + " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ScoreEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, "tjugoettHighScore.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    /**
     * Adds score and rolls into table
     * @param score The score
     */
    public void addEntry(int score) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ScoreEntry.COLUMN_NAME_SCORE, score);
        db.insert(ScoreEntry.TABLE_NAME, null, values);
    }


    /**
     * Returns all the scores and throws in a list
     * @return Returns [Score], unordered and raw.
     */
    public List<Integer> getAllEntries() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {ScoreEntry.COLUMN_NAME_SCORE};
        Cursor c = db.query(ScoreEntry.TABLE_NAME, projection, null, null, null, null, null);
        List<Integer> scores = new ArrayList<>();
        while (c.moveToNext()) {
            scores.add(c.getInt(0));
        }
        return scores;
    }
}