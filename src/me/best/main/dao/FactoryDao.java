package me.best.main.dao;

public class FactoryDao {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }

    public static TagDao getTagDao(){
        return new TagDaoImpl();
    }
}
