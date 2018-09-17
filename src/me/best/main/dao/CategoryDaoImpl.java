package me.best.main.dao;

import me.best.main.models.Category;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {
    static final int PAGE_SIZE = 10;

    @Override
    public Category getById(String id) {
        String sql = "select * from public.category where id=?";
        return super.get(sql, id);
    }

    @Override
    public List<Category> getList(int pageIndex, int pageSize) {
        String sql = "select * from public.category order by id desc limit ? offset ?";
        return super.getList(sql, pageSize, (pageIndex-1)* pageSize);
    }

    @Override
    public List<Category> getAll(){
        String sql = "select * from public.category order by id desc";
        return super.getAll(sql);
    }

    @Override
    public long getTotal(){
        String sql = "select count(id) from public.category";
        return (long) super.getValue(sql);
    }

    @Override
    public int add(Category tag) {
        String sql = "insert into public.category (id, name, \"clickNum\", \"createTime\") values (?, ?, ?, ?)";
        return super.update(sql, tag.getId(), tag.getName(), tag.getClickNum(), tag.getCreateTime());
    }

    @Override
    public int edit(String id, String name, Object clickNum) {
        String sql = "update public.category set";
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
        String sql = "delete from public.category where id=?";
        return  super.update(sql, id);
    }

    @Override
    public long getCountByName(String name) {
        String sql = "select count(*) from public.category where name=?";
        return (long) super.getValue(sql, name);
    }
}
