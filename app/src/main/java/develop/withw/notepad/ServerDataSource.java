package develop.withw.notepad;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ServerDataSource implements DataSource {


    public ServerDataSource(){

        //here codes for retrofit
    }
    @Override
    public void insert(Note note) {
    }

    @Override
    public void update(Note note) {

    }

    @Override
    public void deleteNote(Note note) {

    }

    @Override
    public void deleteAllNotes() {

    }

    @Override
    public void saveString(String string) {

    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public LiveData<List<Note>> getAllNotes() {
        return null;
    }
}
