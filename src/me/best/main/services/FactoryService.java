package me.best.main.services;

public class FactoryService {
    public static TagService getTagService() {
        return new TagServiceImpl();
    }
}
