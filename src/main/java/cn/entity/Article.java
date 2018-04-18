package cn.entity;

/**
 * 文章pojo
 */
public class Article {
    private Integer articleId;//主键id
    private Integer authorId;//作者id
    private String articleTitle;//标题
    private Integer lookCount;//观看次数
    private Integer giveGood;//点赞次数
    private String articleContent;//内容

    public Article() {
    }

    public Article(Integer articleId, String aricleTitle) {
        this.articleId = articleId;
        this.articleTitle = aricleTitle;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Integer getLookCount() {
        return lookCount;
    }

    public void setLookCount(Integer lookCount) {
        this.lookCount = lookCount;
    }

    public Integer getGiveGood() {
        return giveGood;
    }

    public void setGiveGood(Integer giveGood) {
        this.giveGood = giveGood;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}

