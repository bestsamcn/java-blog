package me.best.main.services;

import me.best.main.models.Tag;

public interface TagService {
    public String add(Tag tag);
    public Tag getById(String id);
}
