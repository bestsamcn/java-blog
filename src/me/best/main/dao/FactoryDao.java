package me.best.main.dao;

import me.best.main.dao.impl.*;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class FactoryDao {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }

    public static TagDao getTagDao(){
        return new TagDaoImpl();
    }

    public static CategoryDao getCategoryDao(){ return new CategoryDaoImpl();}

    public static ArticleDao getArticleDao(){ return new ArticleDaoImpl();}

    public static PosterDao getPosterDao(){ return new PosterDaoImpl();}
}
