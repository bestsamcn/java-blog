package me.best.main.services.impl;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Article;
import me.best.main.services.ArticleService;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

public class ArticleServiceImpl implements ArticleService {
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
                ret = Utils.setResponse(0, "新增成功", "null");
                return ret;
            }
            return ret;
        }catch (Exception e){
            ret.replace("msg", "异常");
            return ret;
        }
    }
}
