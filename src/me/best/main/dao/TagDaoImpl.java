package me.best.main.dao;

import me.best.main.models.Tag;

import java.util.List;

public class TagDaoImpl extends BaseDao<Tag> implements TagDao {
    @Override
    public Tag getById(String id) {
        String sql = "select * from public.tag where id=?";
        return super.get(sql, id);
    }

    @Override
    public List<Tag> getAll() {
        String sql = "select * from public.user";
        return super.getAll(sql);
    }

    @Override
    public String add() {
        String sql = "insert into public.tag(id, name, clickNum, createTime) values (?, ?, ?, ?)";
        return "";
    }
}
