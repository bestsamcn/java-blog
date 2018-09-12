package me.best.main.services;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Tag;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
    public class TagServiceImpl implements TagService{
    @Override
    public String add(Tag tag) {
        String id = FactoryDao.getTagDao().add(tag);
        return id;
    }

    @Override
    public Tag getById(String id) {
        Tag tag = FactoryDao.getTagDao().getById(id);
        return tag;
    }

    @Override
    public List<Tag> getList() {
        return null;
    }

    @Override
    public String delete(String id) {
        return FactoryDao.getTagDao().delete(id);
    }

    @Override
    public String edit(Tag tag) {
        return FactoryDao.getTagDao().edit(tag);
    }
}
