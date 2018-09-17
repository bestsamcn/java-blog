package me.best.main.services;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Category;
import me.best.main.models.Tag;
import me.best.main.utils.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class CategoryServiceImpl implements CategoryService{
    static final int PAGE_SIZE= 10;

    @Override
    public JSONObject add(String name) {
        JSONObject ret = null;

        //校验
        if(name == null || name.isEmpty()  || name.length() == 0){
            ret = Utils.setResponse(-1, "标签名不能为空","null");
            return ret;
        }

        //唯一性
        long count =  FactoryDao.getCategoryDao().getCountByName(name);
        if(count != 0){
            ret = Utils.setResponse(-1, "标签名已存在","null");
            return ret;
        }

        Timestamp createTime = new Timestamp(new Date().getTime());
        Category category = new Category(Utils.getUUID(), name, 0, createTime);
        try{

            //新增操作
            int row = FactoryDao.getCategoryDao().add(category);
            if(row == 1){
                ret = Utils.setResponse(0, "添加成功", category.getId());
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
        if(  id == null || id.isEmpty() || id.length() != 32){
            ret = Utils.setResponse(-1, "无此记录","null");
            return ret;
        }
        Category category = FactoryDao.getCategoryDao().getById(id);
        if(category == null){
            ret = Utils.setResponse(-1, "无此记录","null");
            return ret;
        }

        //将实体转换为JSONObject类型
        JSONObject _tag = JSONObject.fromObject(category);

        //修改createTime的类型转为long时间戳
        _tag.replace("createTime", category.getCreateTime().getTime());
        ret = Utils.setResponse(-1, "查询成功",_tag);
        return ret;
    }

    @Override
    public JSONObject getList(String pageIndex, String pageSize) {
        JSONObject ret = Utils.setResponse(-1, "异常", "null");
        int _pageIndex = 0;
        int _pageSize = PAGE_SIZE;

        //页码校验
        if(pageIndex == null || pageIndex.trim().isEmpty() || !Utils.isNumber(pageIndex)){
            ret = Utils.setResponse(-1, "页码必须为数字", "null");
            return ret;
        }

        //体积校验
        if(pageSize == null || pageSize.trim().isEmpty() || !Utils.isNumber(pageSize)){
            ret = Utils.setResponse(-1, "页码体积必须为数字", "null");
            return ret;
        }
        _pageIndex = Integer.parseInt(pageIndex.trim());
        _pageSize = Integer.parseInt(pageSize.trim());

        if(_pageIndex <= 0){
            _pageIndex = 1;
        }
        if(_pageSize <= 0){
            _pageSize=PAGE_SIZE;
        }
        List<Category> tagList = FactoryDao.getCategoryDao().getList(_pageIndex, _pageSize);
        long total = FactoryDao.getCategoryDao().getTotal();

        //转换时间戳
        JSONArray _tagList = JSONArray.fromObject(tagList);
        JSONArray _retList = new JSONArray();
        for(int i=0; i<_tagList.size(); i++){
            JSONObject obj = _tagList.getJSONObject(i);
            obj.replace("createTime", obj.getJSONObject("createTime").get("time"));
            _retList.add(obj);
        }
        ret = Utils.setResponse(0, "查询成功", _retList);
        ret.put("total", total);
        return ret;
    }

    @Override
    public JSONObject getAll(){
        JSONObject ret = Utils.setResponse(-1, "异常", "null");
        List<Category> tagList = FactoryDao.getCategoryDao().getAll();

        //转换时间戳
        JSONArray _tagList = JSONArray.fromObject(tagList);
        JSONArray _retList = new JSONArray();
        for(int i=0; i<_tagList.size(); i++){
            JSONObject obj = _tagList.getJSONObject(i);
            obj.replace("createTime", obj.getJSONObject("createTime").get("time"));
            _retList.add(obj);
        }
        ret = Utils.setResponse(0, "查询成功", _retList);
        return ret;
    }

    @Override
    public JSONObject delete(String id) {
        JSONObject ret = Utils.setResponse(-1, "异常", "null");
        if(id.isEmpty() || id.length() != 32){
            ret = Utils.setResponse(-1, "无此数据", "null");
            return ret;
        }
        try{
            int row =   FactoryDao.getCategoryDao().delete(id);
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
            count = FactoryDao.getCategoryDao().edit(id, name, Integer.parseInt(clickNum));
        }else{
            count = FactoryDao.getCategoryDao().edit(id, name, null);
        }
        if(count == 1){
            ret = Utils.setResponse(0, "编辑成功", id);
        }
        return ret;
    }
}
