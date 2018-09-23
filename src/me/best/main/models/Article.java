package me.best.main.models;
import java.sql.Timestamp;

/**
 * @Author: Sam
 * @Date: 2018/9/21 18:32
 */
public class Article {
    private String id;
    private String creator;
    private String category;
    private String categoryName;
    private String tag;
    private String tagName;
    private String thumbnail;
    private String poster;
    private String title;
    private String pinyin;
    private String content;
    private Timestamp createTime;
    private Timestamp lastEditTime;
    private int readNum;
    private int commentNum;
    private String codeContent;
    private String previewText;
    private int likeNum;
    private boolean isPrivate;
    public Article(){
        super();
    }
    public Article(String id, String creator, String category, String categoryName, String tag, String tagName, String thumbnail, String poster, String title, String pinyin, String content, Timestamp createTime, Timestamp lastEditTime, int readNum, int commentNum, String codeContent, String previewText, int likeNum, boolean isPrivate) {
        this.id = id;
        this.creator = creator;
        this.category = category;
        this.categoryName = categoryName;
        this.tag = tag;
        this.tagName = tagName;
        this.thumbnail = thumbnail;
        this.poster = poster;
        this.title = title;
        this.pinyin = pinyin;
        this.content = content;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
        this.readNum = readNum;
        this.commentNum = commentNum;
        this.codeContent = codeContent;
        this.previewText = previewText;
        this.likeNum = likeNum;
        this.isPrivate = isPrivate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Timestamp lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getCodeContent() {
        return codeContent;
    }

    public void setCodeContent(String codeContent) {
        this.codeContent = codeContent;
    }

    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}

