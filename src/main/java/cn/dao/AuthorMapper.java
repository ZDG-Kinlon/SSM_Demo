package cn.dao;

import cn.entity.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorMapper {
    //注册作者
    public int add(
            @Param("name") String name,
            @Param("nikeName") String nikeName,
            @Param("age") Integer age
    );

    //删除作者
    public int del(
            @Param("authorId") int authorId
    );

    //修改作者
    public int set(
            @Param("id") int authorId,
            @Param("name") String name,
            @Param("nikeName") String nikeName,
            @Param("age") Integer age
    );

    //获取作者信息
    public Author get(
            @Param("authorId") int authorId
    );

    //使用分页插件获取作者信息
    public List<Author> gets();
}
