package cn.service;

import cn.common.MsgResponse;
import cn.entity.Author;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface AuthorService {
    //添加作者
    public MsgResponse<String> add(String name, String nikeName, Integer age);

    //删除作者
    public MsgResponse<String> del(Integer authorid);

    //修改作者
    public MsgResponse<String> set(Integer id, String name, String nikeName, Integer age);

    //获取作者信息
    public MsgResponse<Author> get(Integer authorid);

    //查询作者
    public MsgResponse<List<Author>> gets();

    //分页查询作者
    public MsgResponse<PageInfo<List<Author>>> gets(Integer pageNo, Integer pageSize);
}
