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
    public JSONObject getById(String id) {
        JSONObject ret = Utils.setResponse(-1, "异常", "null");

        //校验
        if(id.isEmpty() || id == null || id.length() != 32){
            ret = Utils.setResponse(-1, "无此记录","null");
            return ret;
        }
        Tag tag = FactoryDao.getTagDao().getById(id);
        if(tag == null){
            ret = Utils.setResponse(-1, "无此记录","null");
            return ret;
        }

        //将实体转换为JSONObject类型
        JSONObject _tag = JSONObject.fromObject(tag);

        //修改createTime的类型转为long时间戳
        _tag.replace("createTime", tag.getCreateTime().getTime());
        ret = Utils.setResponse(-1, "查询成功",_tag);
        return ret;
    }

    @Override
    public List<Tag> getList() {
        return null;
    }

    @Override
    public JSONObject delete(String id) {
        JSONObject ret = Utils.setResponse(-1, "异常", "null");
        if(id.isEmpty() || id.length() != 32){
            ret = Utils.setResponse(-1, "无此数据", "null");
            return ret;
        }
        try{
            int row =   FactoryDao.getTagDao().delete(id);
            if(row == 1){
                ret = Utils.setResponse(0, "删除成功", id);
                return ret;
            }
            ret = Utils.setResponse(0, "无此数据", id);
            return ret;
        }catch(Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public JSONObject edit(String id, String name, String clickNum) {
        JSONObject ret = Utils.setResponse(-1, "编辑失败", "null");

        //校验
        if( id == null || id.isEmpty() || id.length() == 0){
            ret = Utils.setResponse(-1, "无此数据","null");
            return ret;
        }

        if(name == null || name.isEmpty() || name.length() == 0){
            ret = Utils.setResponse(-1, "标签名不能为空","null");
            return ret;
        }
        if(clickNum != null && !clickNum.isEmpty() && !clickNum.trim().equals("")){
            ret = Utils.setResponse(-1, "点击数量必须为数字","null");
            return ret;
        }

        int count = 0;
        if(clickNum != null){
            count = FactoryDao.getTagDao().edit(id, name, Integer.parseInt(clickNum));
        }else{
            count = FactoryDao.getTagDao().edit(id, name, null);
        }
        if(count == 1){
            ret = Utils.setResponse(0, "编辑成功", id);
        }
        return ret;
    }
}
