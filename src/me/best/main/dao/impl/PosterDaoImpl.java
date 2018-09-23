package me.best.main.dao.impl;

import me.best.main.dao.BaseDao;
import me.best.main.dao.PosterDao;
import me.best.main.models.Poster;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/23 18:22
 */
public class PosterDaoImpl extends BaseDao<Poster> implements PosterDao {
    @Override
    public int add(Poster poster) {
        String sql = "insert into public.poster(id, \"createTime\", name, path, thumbnail) values (?, ?, ?, ?, ?)";
        return super.update(sql, poster.getId(), poster.getCreateTime(), poster.getName(), poster.getPath(), poster.getThumbnail());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from public.poster where id=?";
        return super.update(sql, id);
    }

    @Override
    public List<Poster> getList(int pageIndex, int pageSize) {
        String sql = "select * from public.poster order by \"createTime\" limit ? offset ?";
        return super.getList(sql, pageSize, (pageIndex-1)*pageSize);
    }

    @Override
    public int getTotal(){
        String sql = "select count(*) from public.poster";
        return (int) super.getValue(sql);
    }

}
