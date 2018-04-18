package cn.service;

import cn.common.MsgResponse;
import cn.entity.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {
    //添加文章
    public MsgResponse<String> add(Integer authorId, String articleTitle, String articleContent);

    //删除文章
    public MsgResponse<String> del(Integer articleId);

    //修改文章
    public MsgResponse<String> set(Integer articleId, Integer authorId, String articleTitle, String articleContent);

    //查询文章
    public MsgResponse<Article> get(Integer articleId);

    //查询全部文章
    public MsgResponse<List<Article>> gets();

    //查询全部文章（分页）
    public MsgResponse<PageInfo<List<Article>>> gets(Integer pageNo, Integer pageSize);

    //查询作者的全部文章（分页）
    public MsgResponse<PageInfo<List<Article>>>getsByAuthorId(Integer authorId,Integer pageNo,Integer pageSize);

    //增加浏览次数
    public MsgResponse<String> plusLookCount(Integer authorId);

    //点赞
    public MsgResponse<String> plusGiveGood(Integer authorId);
}
