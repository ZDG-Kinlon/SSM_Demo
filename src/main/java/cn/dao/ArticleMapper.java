package cn.dao;


import cn.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    //添加文章
    public int add(
            @Param("authorid") int authorid,
            @Param("articleTitle") String articleTitle,
            @Param("articleContent") String articleContent
    );

    //修改文章
    public int set(
            @Param("articleId") int articleId,
            @Param("authorid") int authorid,
            @Param("articleTitle") String articleTitle,
            @Param("articleContent") String articleContent
    );

    //删除文章
    public int del(
            @Param("articleId") int articleId
    );

    //查询文章
    public Article get(
            @Param("articleId") int articleId
    );

    //查询全部文章
    public List<Article> gets();

    //查询作者的全部文章
    public List<Article> getsByAuthorId(
            @Param("authorId") Integer authorId
    );

    //增加浏览次数
    public int plusLookCount(
            @Param("articleId") int articleId
    );

    //增加赞次数
    public int plusgiveGood(
            @Param("articleId") int articleId
    );
}
