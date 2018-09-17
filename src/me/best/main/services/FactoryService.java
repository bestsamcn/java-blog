package me.best.main.services;


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
}
