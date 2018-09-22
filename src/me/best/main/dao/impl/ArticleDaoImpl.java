package me.best.main.dao.impl;

import me.best.main.dao.ArticleDao;
import me.best.main.dao.BaseDao;
import me.best.main.models.Article;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/21 18:36
 */
public class ArticleDaoImpl extends BaseDao<Article> implements ArticleDao{
    @Override
    public int add(Article article) {
        String sql = "insert into public.article (id, creator, category, \"categoryName\", tag, \"tagName\", thumbnail, poster, title, content"
                +", \"codeContent\", \"previewText\", \"createTime\", \"lastEditTime\", pinyin, \"readNum\", \"commentNum\", \"likeNum\", \"isPrivate\" )"
                +"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return super.update(sql, article.getId(), article.getCreator(), article.getCategory(), article.getCategoryName(), article.getTag(),
                article.getTagName(), article.getThumbnail(), article.getPoster(), article.getTitle(),
                article.getContent(), article.getCodeContent(), article.getPreviewText(), article.getCreateTime(), article.getLastEditTime(),
                article.getPinyin(), article.getReadNum(), article.getCommentNum(), article.getLikeNum(), article.getIsPrivate());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from public.article where id=?";
        return super.update(sql, id);
    }

    @Override
    public int edit(Article article) {
        String sql = "update public.article set creator=?, category=?, \"categoryName\"=?, tag=?, \"tagName\"=?, thumbnail=?, poster=?, title=?, content=?"
                +", \"codeContent\"=?, \"previewText\"=?, \"createTime\"=?, \"lastEditTime\"=?, pinyin=?, \"readNum\"=?, \"commentNum\"=?, \"likeNum\"=?, " +
                "\"isPrivate\"=? "
                +"where id=?";
        return super.update(sql, article.getCreator(), article.getCategory(), article.getCategoryName(), article.getTag(),
                article.getTagName(), article.getThumbnail(), article.getPoster(), article.getTitle(),
                article.getContent(), article.getCodeContent(), article.getPreviewText(), article.getCreateTime(), article.getLastEditTime(),
                article.getPinyin(), article.getReadNum(), article.getCommentNum(), article.getLikeNum(), article.getIsPrivate(), article.getId());
    }

    @Override
    public List<Article> getList(int pageIndex, int pageSize) {
        String sql = "select * from public.article order by public.article.\"lastEditTime\" limit ? offset ?";
        return super.getList(sql, pageSize, (pageIndex-1)*pageSize);
    }

    @Override
    public Object getDetail(String id) {
        String  sql = "select public.article.* "
                +"from public.article "
                +"where public.article.id=?";
        return super.get(sql, id);
    }

    @Override
    public long getTotal(){
        String sql = "select count(id) from public.article";
        return (long) super.getValue(sql);
    }
}
