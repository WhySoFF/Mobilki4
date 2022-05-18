package com.makichanov.notes_app;

import android.content.Context;

import androidx.room.Room;

import com.makichanov.notes_app.db.NotesAppDatabase;
import com.makichanov.notes_app.repository.NoteDbRepository;
import com.makichanov.notes_app.service.NoteService;
import com.makichanov.notes_app.service.NoteServiceListener;

public class NotesAppContext {

    private static final NotesAppContext instance = new NotesAppContext();
    private NoteService noteService;
    private NotesAppDatabase database;

    private NotesAppContext() {
    }

    public static NotesAppContext getInstance() {
        return instance;
    }

    public void setListener(NoteServiceListener listener) {
        noteService.setListener(listener);
    }

    public NoteService getNoteService(Context context) {
        if (noteService == null) {
            noteService = new NoteService(context);
        }
        return noteService;
    }

    public NoteDbRepository noteDbRepository(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, NotesAppDatabase.class,
                            "notes_app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database.noteDbRepository();
    }

}
