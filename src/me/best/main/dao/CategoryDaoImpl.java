package me.best.main.dao;

import me.best.main.models.Tag;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class CategoryDaoImpl extends BaseDao<Tag> implements CategoryDao {
    static final int PAGE_SIZE = 10;

    @Override
    public Tag getById(String id) {
        String sql = "select * from public.tag where id=?";
        return super.get(sql, id);
    }

    @Override
    public List<Tag> getList(int pageIndex, int pageSize) {
        String sql = "select * from public.tag order by id desc limit ? offset ?";
        return super.getList(sql, pageSize, (pageIndex-1)* pageSize);
    }

    @Override
    public List<Tag> getAll(){
        String sql = "select * from public.tag order by id desc";
        return super.getAll(sql);
    }

    @Override
    public long getTotal(){
        String sql = "select count(id) from public.tag";
        return (long) super.getValue(sql);
    }

    @Override
    public int add(Tag tag) {
        String sql = "insert into public.tag (id, name, \"clickNum\", \"createTime\") values (?, ?, ?, ?)";
        return super.update(sql, tag.getId(), tag.getName(), tag.getClickNum(), tag.getCreateTime());
    }

    @Override
    public int edit(String id, String name, Object clickNum) {
        String sql = "update public.tag set";
        if(name != null && !name.equals("")){
            sql += " name="+"\'"+name+"\'";
        }
        if(clickNum != null){
            sql += " \"clickNum\"="+clickNum;
        }
        sql += " where id="+"\'"+id+"\'";
        return super.update(sql);
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
