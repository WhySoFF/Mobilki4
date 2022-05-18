package com.makichanov.notes_app.service;

public interface NoteServiceListener {
    void onAdd();

    void onUpdate();

    void onRemove();
}
