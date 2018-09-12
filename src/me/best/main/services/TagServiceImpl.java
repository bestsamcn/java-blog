package me.best.main.services;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Tag;

/**
 * 标签服务实现类
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
}
