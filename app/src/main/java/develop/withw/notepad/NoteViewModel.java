package develop.withw.notepad;

import android.app.Application;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NoteViewModel extends AndroidViewModel {

    private String text;
    private Repository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allNotes = repository.getAllNotes();
    }


    public void insert(Note note){
        repository.insert(note);
    }
    public void updateNote(Note note){
        repository.update(note);
    }

    public void deleteNote(Note note){
        repository.deleteNote(note);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

   public void setTest(EditText test, TextView textView){
        textView.setText(test.getText().toString());
   }

    public String getText() {
        return repository.getString();
    }

    public void setText(String text) {
      repository.saveString(text);
    }
/**
     * inja mitonim karaye har activyty ro joda konim
     * masalan tuye activity AddNote,yek view model dorost konim va qesmate insert ro tuye on bezarim,ama inja
     * az ye noe kameltar omadim estefade kardim
     */
}
