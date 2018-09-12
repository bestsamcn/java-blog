package me.best.main.dao;

import me.best.main.models.Tag;

import java.sql.Timestamp;
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
    public String add(Tag tag) {
        String sql = "insert into public.tag (id, name, \"clickNum\", \"createTime\") values (?, ?, ?, ?)";
        System.out.println(sql);
        int row =  super.update(sql, tag.getId(), tag.getName(), tag.getClickNum(), tag.getCreateTime());
        if(row == 1){
            return tag.getId();
        }
        return null;
    }

    @Override
    public String edit(Tag tag) {
        String sql = "update public.tag set name=?, \"clickNum\"=? where id=?";
        int row = super.update(sql, tag.getName(), tag.getClickNum(), tag.getId());
        if(row == 1){
            return tag.getId();
        }
        return null;
    }

    @Override
    public String delete(String id) {
        String sql = "delete from public.tag where id=?";

        int row = super.update(sql, id);
        if(row == 1){
            return id;
        }
        return null;
    }
}
