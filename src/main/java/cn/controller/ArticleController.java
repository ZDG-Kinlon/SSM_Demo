package cn.controller;

import cn.common.MsgResponse;
import cn.entity.Article;
import cn.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 增加文章
     * <p>
     * 链接：http://127.0.0.1:8080/article
     * 请求：POST
     * 参数：authorId、articleTitle、articleContent
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    @ResponseBody
    public MsgResponse<String> addRESTful(Article article) {
        Integer authorId = article.getAuthorId();
        String articleTitle = article.getArticleTitle();
        String articleContent = article.getArticleContent();
        return articleService.add(authorId, articleTitle, articleContent);
    }

    /**
     * 删除文章
     * <p>
     * 链接：http://127.0.0.1:8080/article/[文章id]
     * 请求：DELETE
     * 参数：
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.DELETE)
    @ResponseBody
    public MsgResponse<String> delRESTful(@PathVariable("articleId") String articleId) {
        Integer aId = Integer.valueOf(articleId);
        return articleService.del(aId);
    }

    /**
     * 修改文章
     * <p>
     * 链接：http://127.0.0.1:8080/article/[文章id]
     * 请求：PUT
     * 参数：authorId、articleTitle、articleContent
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.PUT)
    @ResponseBody
    public MsgResponse<String> setRESTful(Article article) {
        Integer articleId = article.getArticleId();
        Integer authorId = article.getAuthorId();
        String articleTitle = article.getArticleTitle();
        String articleContent = article.getArticleContent();
        return articleService.set(articleId, authorId, articleTitle, articleContent);
    }

    /**
     * 查询文章，浏览次数加1
     * <p>
     * 链接：http://127.0.0.1:8080/article/[文章id]
     * 请求：GET
     * 参数：
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public MsgResponse<Article> getRESTful(@PathVariable("articleId") String articleId) {
        Integer aId = Integer.valueOf(articleId);
        //get是只读事物，修改浏览次数不能在只读环境中，先增加浏览次数，再返回短文
        if (articleService.plusLookCount(aId).isSuccess()){
            return articleService.get(aId);
        }else{
            return MsgResponse.createError("文章不存在",null);
        }
    }

    /**
     * 查询全部文章
     * <p>
     * 链接：http://127.0.0.1:8080/all/article
     * 请求：GET
     * 参数：
     *
     * @return
     */
    @RequestMapping(value = "/all/article", method = RequestMethod.GET)
    @ResponseBody
    public MsgResponse<List<Article>> gets() {
        return articleService.gets();
    }

    /**
     * 查询全部文章（分页）
     * <p>
     * 链接：http://127.0.0.1:8080/pages/article
     * 请求：GET
     * 参数：pageNo、pageSize
     *
     * @param pageNo   默认首页
     * @param pageSize 默认每页10条
     * @return
     */
    @RequestMapping(value = "/pages/article", method = RequestMethod.GET)
    @ResponseBody
    public MsgResponse<PageInfo<List<Article>>> gets(
            @RequestParam(value = "pageNo", defaultValue = "1") String pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") String pageSize
    ) {
        Integer pNo = Integer.valueOf(pageNo);
        Integer pSize = Integer.valueOf(pageSize);
        return articleService.gets(pNo, pSize);
    }

    /**
     * 查询作者的全部文章（分页）
     * <p>
     * 链接：http://127.0.0.1:8080/pages/article/[作者id]
     * 请求：GET
     * 参数：pageNo、pageSize
     *
     * @param authorId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/pages/article/{authorId}")
    @ResponseBody
    public MsgResponse<PageInfo<List<Article>>> getsByAuthorId(
            @PathVariable(value = "authorId") String authorId,
            @RequestParam(value = "pageNo", defaultValue = "1") String pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") String pageSize
    ) {
        Integer aId = Integer.valueOf(authorId);
        Integer pNo = Integer.valueOf(pageNo);
        Integer pSize = Integer.valueOf(pageSize);
        return articleService.getsByAuthorId(aId, pNo, pSize);
    }

    /**
     * 点赞
     * <p>
     * 链接：http://127.0.0.1:8080/action/giveGood/[文章id]
     * 请求：PUT
     * 参数：
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/action/giveGood/{articleId}", method = RequestMethod.PUT)
    @ResponseBody
    public MsgResponse<String> plusGiveGood(
            @PathVariable("articleId") String articleId
    ) {
        Integer aId = Integer.valueOf(articleId);
        return articleService.plusGiveGood(aId);
    }
}
