package develop.withw.notepad;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class Repository implements DataSource {
    private Application application;
    private LocalDataSource localDataSource;
    private ServerDataSource serverDataSource;
    public Repository(Application application) {
        this.application = application;
        localDataSource = new LocalDataSource(application);
        serverDataSource = new ServerDataSource();
    }




    @Override
    public void insert(Note note) {
        localDataSource.insert(note);
    }

    @Override
    public void update(Note note) {
        localDataSource.update(note);
    }

    @Override
    public void deleteNote(Note note) {
        localDataSource.deleteNote(note);
    }

    @Override
    public void deleteAllNotes() {
        localDataSource.deleteAllNotes();
    }

    @Override
    public void saveString(String string) {
        localDataSource.saveString(string);
    }

    @Override
    public String getString() {
        return localDataSource.getString();
    }

    @Override
    public LiveData<List<Note>> getAllNotes() {
        return localDataSource.getAllNotes();
    }


}
