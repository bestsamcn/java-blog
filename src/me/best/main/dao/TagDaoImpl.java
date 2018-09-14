package me.best.main.dao;

import me.best.main.models.Tag;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class TagDaoImpl extends BaseDao<Tag> implements TagDao {
    static final int PAGE_SIZE = 10;

    @Override
    public Tag getById(String id) {
        String sql = "select * from public.tag where id=?";
        return super.get(sql, id);
    }

    @Override
    public List<Tag> getList(int pageIndex, int pageSize) {
        String sql = "select * from public.tag limit ? offset ? order by id desc";
        return super.getList(sql, pageSize, (pageIndex-1)* pageSize);
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
