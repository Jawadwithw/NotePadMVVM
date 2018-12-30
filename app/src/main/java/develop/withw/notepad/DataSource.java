package develop.withw.notepad;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface DataSource {

    void insert(Note note);
    void update(Note note);
    void deleteNote(Note note);
    void deleteAllNotes();

    void saveString(String string);
    String getString();

    LiveData<List<Note>> getAllNotes();
}
