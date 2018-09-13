package me.best.main.dao;

import me.best.main.models.Tag;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
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
    public int add(Tag tag) {
        String sql = "insert into public.tag (id, name, \"clickNum\", \"createTime\") values (?, ?, ?, ?)";
        return super.update(sql, tag.getId(), tag.getName(), tag.getClickNum(), tag.getCreateTime());
    }

    @Override
    public int edit(Tag tag) {
        String sql = "update public.tag set name=?, \"clickNum\"=? where id=?";
        return super.update(sql, tag.getName(), tag.getClickNum(), tag.getId());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from public.tag where id=?";
        return  super.update(sql, id);
    }

    @Override
    public long getCountByName(String name) {
        String sql = "select count(*) from public.tag where name=?";
        return (long) super.getValue(sql, name);
    }
}
