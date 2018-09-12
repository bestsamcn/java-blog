package me.best.main.dao;

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
}
