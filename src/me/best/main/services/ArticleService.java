package me.best.main.services;

import net.sf.json.JSONObject;

public interface ArticleService {
    public JSONObject add(String creator, String tag, String tagName, String category, String categoryName, String title, String previewText, String content,
                          String codeContent, String poster);
}
