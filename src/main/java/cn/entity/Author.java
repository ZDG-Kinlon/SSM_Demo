package cn.entity;

/**
 * 作者pojo
 */
public class Author {

    private Integer authorId;//主键id
    private java.lang.String authorName;//姓名
    private java.lang.String authorNickName;//昵称
    private Integer authorAge;//年龄

    public Author() {
    }

    public Author(Integer authorId, java.lang.String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public java.lang.String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(java.lang.String authorName) {
        this.authorName = authorName;
    }

    public java.lang.String getAuthorNickName() {
        return authorNickName;
    }

    public void setAuthorNickName(java.lang.String authorNickName) {
        this.authorNickName = authorNickName;
    }

    public Integer getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(Integer authorAge) {
        this.authorAge = authorAge;
    }
}
