package me.best.main.services;


import me.best.main.services.impl.*;

/**
 * @Author: Sam
 * @Date: 2018/9/12 21:39
 */
public class FactoryService {
    public static TagService getTagService() {
        return new TagServiceImpl();
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl();
    }
    public static UserService getUserService(){
        return new UserServiceImpl();
    }

    public static ArticleService getArticleService(){
        return new ArticleServiceImpl();
    }

    public static PosterService getPosterService(){
        return new PosterServiceImpl();
    }
}
