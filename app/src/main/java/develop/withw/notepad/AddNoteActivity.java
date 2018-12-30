package develop.withw.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    private EditText et_title,et_desc;
    private NumberPicker numberPicker;

    public static final String EXTRA_TITLE = "develop.withw.notepad.EXTRA_TITLE";
    public static final String EXTRA_DESC = "develop.withw.notepad.EXTRA_DESC";
    public static final String EXTRA_PRIORITY = "develop.withw.notepad.EXTRA_PRIORITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        et_desc=(EditText)findViewById(R.id.et_desc);
        et_title=(EditText)findViewById(R.id.et_title);

        numberPicker=(NumberPicker)findViewById(R.id.number_picker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String title=et_title.getText().toString();
        String desc = et_desc.getText().toString();
        int priority = numberPicker.getValue();
        if (title.trim().isEmpty() || desc.trim().isEmpty()){
            Toast.makeText(this, "Please Insert Title And Description", Toast.LENGTH_SHORT).show();
            //baraye in return neweshtim ke dg hich codei ro baad az neshun dadan toast ejra nakone chon khali bude dg hatman!
            return;
        }

        Intent data=new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESC,desc);
        data.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK,data);
        finish();


    }
}
