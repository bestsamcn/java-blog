package me.best.main.dao;

import me.best.main.models.Tag;

import java.sql.Timestamp;
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
    public String add(Tag tag) {
        String sql = "insert into public.tag (id, name, clickNum, createTime) values (?, ?, ?, ?)";
        System.out.println(sql);
        int row =  super.add(sql, tag.getId(), tag.getName(), tag.getClickNum(), tag.getCreateTime());
        System.out.println(row+"sfasdfasdfasdlfajsdlfkjalksdjfalksdjf");
        return tag.getId();
    }
}
