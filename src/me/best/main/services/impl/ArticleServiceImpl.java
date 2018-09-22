package me.best.main.services.impl;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Article;
import me.best.main.services.ArticleService;
import me.best.main.utils.Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    private static final int PAGE_SIZE=10;
    @Override
    public JSONObject add(String creator, String tag, String tagName, String category, String categoryName, String title, String previewText, String content, String codeContent, String poster) {
        JSONObject ret = Utils.setResponse(-1, "新增失败", "null");
        if(creator == null || creator.trim().isEmpty()){
            ret.replace("msg", "作者不能为空");
            return ret;
        }

        if(tag == null || tag.trim().isEmpty() || tagName == null || tagName.trim().isEmpty()){
            ret.replace("msg", "标签不能为空");
            return ret;
        }

        if(category == null || category.trim().isEmpty() || categoryName == null || categoryName.trim().isEmpty()){
            ret.replace("msg", "分类签不能为空");
            return ret;
        }

        if(title == null || title.trim().isEmpty()){
            ret.replace("msg", "标题不能为空");
            return ret;
        }

        if(title.trim().length() > 255){
            ret.replace("msg", "标题过长");
            return ret;
        }

        if(previewText != null && previewText.trim().length() > 255){
            ret.replace("msg", "摘要过长");
            return ret;
        }

        if(content == null || content.trim().isEmpty() || codeContent == null || codeContent.trim().isEmpty()){
            ret.replace("msg", "内容不能为空");
            return ret;
        }

        Article article = new Article();

        article.setId(Utils.getUUID());
        article.setCreator(creator);
        article.setCategory(category);
        article.setCategoryName(categoryName);
        article.setTag(tag);
        article.setTagName(tagName);
        article.setTitle(title);
        article.setPreviewText(previewText);
        article.setContent(content);
        article.setCodeContent(codeContent);
        article.setLikeNum(0);
        article.setReadNum(0);
        article.setCommentNum(0);
        article.setLastEditTime(new Timestamp(new Date().getTime()));
        article.setCreateTime(new Timestamp(new Date().getTime()));
        article.setPinyin("");
        article.setPoster(poster);
        article.setThumbnail("");
        article.setIsPrivate(false);
        try{
            int count = FactoryDao.getArticleDao().add(article);
            if(count == 1){
                ret = Utils.setResponse(0, "新增成功", article.getId());
                return ret;
            }
            return ret;
        }catch (Exception e){
            ret.replace("msg", "异常");
            return ret;
        }
    }

    @Override
    public JSONObject edit(String id, String creator, String tag, String tagName, String category, String categoryName, String title, String previewText,
                           String content, String codeContent, String poster) {
        JSONObject ret = Utils.setResponse(-1, "编辑失败", "null");

        if(id == null || id.trim().length() !=32){
            ret.replace("msg", "无此记录");
            return ret;
        }

        if(creator == null || creator.trim().isEmpty()){
            ret.replace("msg", "作者不能为空");
            return ret;
        }

        if(tag == null || tag.trim().isEmpty() || tagName == null || tagName.trim().isEmpty()){
            ret.replace("msg", "标签不能为空");
            return ret;
        }

        if(category == null || category.trim().isEmpty() || categoryName == null || categoryName.trim().isEmpty()){
            ret.replace("msg", "分类签不能为空");
            return ret;
        }

        if(title == null || title.trim().isEmpty()){
            ret.replace("msg", "标题不能为空");
            return ret;
        }

        if(title.trim().length() > 255){
            ret.replace("msg", "标题过长");
            return ret;
        }

        if(previewText != null && previewText.trim().length() > 255){
            ret.replace("msg", "摘要过长");
            return ret;
        }

        if(content == null || content.trim().isEmpty() || codeContent == null || codeContent.trim().isEmpty()){
            ret.replace("msg", "内容不能为空");
            return ret;
        }

        Article article = (Article) FactoryDao.getArticleDao().getDetail(id);
        article.setCreator(creator);
        article.setCategory(category);
        article.setCategoryName(categoryName);
        article.setTag(tag);
        article.setTagName(tagName);
        article.setTitle(title);
        article.setPreviewText(previewText);
        article.setContent(content);
        article.setCodeContent(codeContent);
        article.setLastEditTime(new Timestamp(new Date().getTime()));
        article.setPinyin("");
        article.setPoster(poster);
        article.setThumbnail("");
        article.setIsPrivate(false);
        try{
            int count = FactoryDao.getArticleDao().edit(article);
            if(count == 1){
                ret = Utils.setResponse(0, "编辑成功", article.getId());
                return ret;
            }
            return ret;
        }catch (Exception e){
            ret.replace("msg", "异常");
            return ret;
        }
    }

    @Override
    public JSONObject getDetail(String id){
        JSONObject ret = Utils.setResponse(-1, "查询失败", "null");
        if(id == null || id.trim().length() != 32){
            ret.replace("msg", "无此记录");
            return ret;
        }
        try{
            JSONObject article = JSONObject.fromObject(FactoryDao.getArticleDao().getDetail(id));
            if(article != null){
                article.replace("createTime", article.getJSONObject("createTime").get("time"));
                article.replace("lastEditTime", article.getJSONObject("lastEditTime").get("time"));
                article.replace("isPrivate", null);
                ret = Utils.setResponse(0, "查询成功", article);
                return ret;
            }
        }catch(Exception e){
            ret.replace("msg", "异常");
         }
        return ret;
    }

    @Override
    public JSONObject getList(String pageIndex, String pageSize){
        JSONObject ret = Utils.setResponse(-1, "查询失败", "null");
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
        List<Article> list = FactoryDao.getArticleDao().getList(_pageIndex, _pageSize);
        long total = FactoryDao.getArticleDao().getTotal();

        //转换时间戳
        JSONArray _list = JSONArray.fromObject(list);
        JSONArray _retList = new JSONArray();
        for(int i=0; i<_list.size(); i++){
            JSONObject obj = _list.getJSONObject(i);
            obj.replace("createTime", obj.getJSONObject("createTime").get("time"));
            obj.replace("lastEditTime", obj.getJSONObject("lastEditTime").get("time"));
            _retList.add(obj);
        }
        ret = Utils.setResponse(0, "查询成功", _retList);
        ret.put("total", total);
        return ret;
    }

    @Override
    public JSONObject delete(String id){
        JSONObject ret = Utils.setResponse(-1, "查询失败", "null");
        if(id == null || id.trim().length() != 32){
            ret.replace("msg", "无此记录");
            return ret;
        }
        try{
            //应该还需要把相关评论删除的
            int count = FactoryDao.getArticleDao().delete(id);
            if(count == 1){
                ret = Utils.setResponse(0, "删除成功", "null");
            }
        }catch(Exception e){
            ret.replace("msg", "异常");
        }
        return ret;
    }

    @Override
    public JSONObject addPoster(HttpServletRequest req) {
        JSONObject ret = Utils.setResponse(-1, "上传失败", "null");



        return ret;
    }
}
