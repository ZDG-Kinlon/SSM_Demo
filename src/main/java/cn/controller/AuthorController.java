package cn.controller;

import cn.common.MsgResponse;
import cn.entity.Author;
import cn.service.AuthorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 作者模块控制器
 */
@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    /**
     * 增加作者
     * <p>
     * 链接：http://127.0.0.1:8080/author
     * 请求：POST
     * 参数：authorName、authorNickName、authorAge
     *
     * @param author
     * @return
     */
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @ResponseBody
    public MsgResponse<String> addRESTful(Author author) {
        String authorName = author.getAuthorName();
        String authorNickName = author.getAuthorNickName();
        Integer authorAge = author.getAuthorAge();
        return authorService.add(authorName, authorNickName, authorAge);
    }

    /**
     * 删除作者
     * <p>
     * 链接：http://127.0.0.1:8080/author/[作者id]
     * 请求：DELETE
     * 参数：
     *
     * @param authorId
     * @return
     */
    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.DELETE)
    @ResponseBody
    public MsgResponse<String> delRESTful(@PathVariable("authorId") String authorId) {
        Integer aId = Integer.valueOf(authorId);
        return authorService.del(aId);
    }

    /**
     * 修改作者信息
     * <p>
     * 链接：http://127.0.0.1:8080/author/[作者id]
     * 请求：PUT
     * 参数：authorName、authorNickName、authorAge
     *
     * @param author
     * @return
     */
    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.PUT)
    @ResponseBody
    public MsgResponse<String> setRESTful(Author author) {
        Integer authorId = author.getAuthorId();
        String authorName = author.getAuthorName();
        String authorNickName = author.getAuthorNickName();
        Integer authorAge = author.getAuthorAge();
        return authorService.set(authorId, authorName, authorNickName, authorAge);

    }

    /**
     * 获取作者信息
     * <p>
     * 链接：http://127.0.0.1:8080/author/[作者id]
     * 请求：GET
     * 参数：
     *
     * @param authorId
     * @return
     */
    @RequestMapping(value = "/author/{authorId}", method = RequestMethod.GET)
    @ResponseBody
    public MsgResponse<Author> getRESTful(@PathVariable String authorId) {
        Integer aId = Integer.valueOf(authorId);
        return authorService.get(aId);
    }

    /**
     * 查询全部作者
     * <p>
     * 链接：http://127.0.0.1:8080/all/author
     * 请求：GET
     * 参数：
     *
     * @return
     */
    @RequestMapping(value = "/all/author", method = RequestMethod.GET)
    @ResponseBody
    public MsgResponse<List<Author>> gets() {
        return authorService.gets();
    }

    /**
     * 查询全部作者（分页）
     * <p>
     * 链接：http://127.0.0.1:8080/pages/author
     * 请求：GET
     * 参数：pageNo、pageSize
     *
     * @param pageNo   默认首页
     * @param pageSize 默认每页5条
     * @return
     */
    @RequestMapping(value = "/pages/author", method = RequestMethod.GET)
    @ResponseBody
    public MsgResponse<PageInfo<List<Author>>> getsRESTful(
            @RequestParam(value = "pageNo", defaultValue = "1") String pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5") String pageSize) {
        Integer pNo = Integer.valueOf(pageNo);
        Integer pSize = Integer.valueOf(pageSize);
        return authorService.gets(pNo, pSize);
    }
}
