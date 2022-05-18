package com.makichanov.notes_app.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.makichanov.notes_app.model.Note;
import com.makichanov.notes_app.repository.NoteDbRepository;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesAppDatabase extends RoomDatabase {

    public abstract NoteDbRepository noteDbRepository();

}
