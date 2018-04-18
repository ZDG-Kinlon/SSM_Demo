package cn.service.impl;

import cn.common.MsgResponse;
import cn.dao.ArticleMapper;
import cn.entity.Article;
import cn.service.ArticleService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public MsgResponse<String> add(Integer authorId, String articleTitle, String articleContent) {
        if (authorId == null) {
            return MsgResponse.createILLEGAL("参数缺少，作者id");
        } else if (articleTitle == null) {
            return MsgResponse.createILLEGAL("参数缺少，文章标题");
        } else if (articleContent != null && articleContent.length() > 2_0000) {
            return MsgResponse.createILLEGAL("参数非法，文章内容最大字数20000");
        } else {
            if (articleMapper.add(authorId, articleTitle, articleContent) == 1) {
                return MsgResponse.createSuccess("添加文章成功");
            } else {
                return MsgResponse.createError("添加文章失败");
            }
        }
    }

    @Override
    public MsgResponse<String> del(Integer articleId) {
        if (articleId == null) {
            return MsgResponse.createILLEGAL("参数缺少，文章id");
        } else {
            if (articleMapper.del(articleId) == 1) {
                return MsgResponse.createSuccess("删除成功");
            } else {
                return MsgResponse.createError("删除失败");
            }
        }
    }

    @Override
    public MsgResponse<String> set(Integer articleId, Integer authorId, String articleTitle, String articleContent) {
        if (articleId == null) {
            return MsgResponse.createILLEGAL("参数缺少，文章id");
        } else if (authorId == null) {
            return MsgResponse.createILLEGAL("参数缺少，作者id");
        } else if (articleTitle == null) {
            return MsgResponse.createILLEGAL("参数缺少，文章标题");
        } else if (articleContent != null && articleContent.length() > 2_0000) {
            return MsgResponse.createILLEGAL("参数非法，文章内容最大字数20000");
        } else {
            if (articleMapper.set(articleId, authorId, articleTitle, articleContent) == 1) {
                return MsgResponse.createSuccess("文章修改成功");
            } else {
                return MsgResponse.createError("文章修改失败");
            }
        }
    }

    @Override
    public MsgResponse<Article> get(Integer articleId) {
        if (articleId == null) {
            return MsgResponse.createILLEGAL("参数缺少，文章id");
        } else {
            return MsgResponse.createSuccess("获取成功", articleMapper.get(articleId));
        }
    }

    @Override
    public MsgResponse<List<Article>> gets() {
        List<Article> list = articleMapper.gets();
        return MsgResponse.createSuccess("获取成功", list);
    }

    @Override
    public MsgResponse<PageInfo<List<Article>>> gets(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageSize == null) {
            return MsgResponse.createILLEGAL("参数缺少，当前页码，每页记录数");
        } else {
            PageHelper.startPage(pageNo, pageSize);
            List<Article> list = articleMapper.gets();
            PageInfo<List<Article>> pageInfo = new PageInfo(list, 5);
            return MsgResponse.createSuccess("获取成功", pageInfo);
        }
    }

    @Override
    public MsgResponse<PageInfo<List<Article>>> getsByAuthorId(Integer authorId, Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageSize == null) {
            return MsgResponse.createILLEGAL("参数缺少，当前页码，每页记录数");
        } else if (authorId == null) {
            return MsgResponse.createILLEGAL("参数缺少，作者id");
        } else {
            PageHelper.startPage(pageNo, pageSize);
            List<Article> list = articleMapper.getsByAuthorId(authorId);
            PageInfo<List<Article>> pageInfo = new PageInfo(list, 5);
            return MsgResponse.createSuccess("获取成功", pageInfo);
        }
    }

    @Override
    public MsgResponse<String> plusLookCount(Integer authorId) {
        if (authorId == null) {
            return MsgResponse.createILLEGAL("参数缺少，文章id");
        } else {
            if (articleMapper.plusLookCount(authorId) == 1) {
                return MsgResponse.createSuccess("浏览次数添加成功");
            } else {
                return MsgResponse.createSuccess("浏览次数添加失败");
            }
        }
    }


    @Override
    public MsgResponse<String> plusGiveGood(Integer authorId) {
        if (authorId == null) {
            return MsgResponse.createILLEGAL("参数缺少，文章id");
        } else {
            if (articleMapper.plusLookCount(authorId) == 1) {
                return MsgResponse.createSuccess("点赞成功");
            } else {
                return MsgResponse.createSuccess("点赞失败");
            }
        }
    }
}
