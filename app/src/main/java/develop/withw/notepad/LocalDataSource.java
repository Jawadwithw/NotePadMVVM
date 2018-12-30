package develop.withw.notepad;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class LocalDataSource implements DataSource {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    private String text;

    public LocalDataSource(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();

    }

    @Override
    public void insert(Note note) {

        new InsertNoteAsyncTask(noteDao).execute(note);

    }

    @Override
    public void update(Note note) {
        new UpdateNoteAsyncTask(noteDao).execute(note);

    }

    @Override
    public void deleteNote(Note note) {

        new DeletetNoteAsyncTask(noteDao).execute(note);
    }

    @Override
    public void deleteAllNotes() {
        new DeleteAllNoteAsyncTask(noteDao).execute();

    }

    @Override
    public void saveString(String string) {
        this.text=string;
    }

    @Override
    public String getString() {
        return text;
    }

    @Override
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }


    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private static class DeletetNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private DeletetNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private DeleteAllNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }

}

