package me.best.main.services;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Tag;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class TagServiceImpl implements TagService{

    @Override
    public JSONObject add(String name) {
        JSONObject ret = null;

        //校验
        if(name.isEmpty() || name == null || name.length() == 0){
            ret = Utils.setResponse(-1, "标签名不能为空","null");
            return ret;
        }

        //唯一性
        long count =  FactoryDao.getTagDao().getCountByName(name);
        if(count != 0){
            System.out.println(count);
            ret = Utils.setResponse(-1, "标签名已存在","null");
            return ret;
        }

        Timestamp createTime = new Timestamp(new Date().getTime());
        Tag tag = new Tag(Utils.getUUID(), name, 0, createTime);
        try{

            //新增操作
            int row = FactoryDao.getTagDao().add(tag);
            if(row == 1){
                ret = Utils.setResponse(0, "添加成功", tag.getId());
                return ret;
            }else{
                ret = Utils.setResponse(-1, "添加失败","null");
                return ret;
            }
        }catch(Exception e){
            ret = Utils.setResponse(-1, "异常","null");
            return ret;
        }
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
    public int delete(String id) {
        return FactoryDao.getTagDao().delete(id);
    }

    @Override
    public int edit(Tag tag) {
        return FactoryDao.getTagDao().edit(tag);
    }
}
