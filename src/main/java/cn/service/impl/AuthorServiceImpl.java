package cn.service.impl;

import cn.common.MsgResponse;
import cn.dao.AuthorMapper;
import cn.entity.Author;
import cn.service.AuthorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public MsgResponse<String> add(String name, String nikeName, Integer age) {
        if (name == null) {
            return MsgResponse.createILLEGAL("缺少参数，作者姓名");
        } else if (age < 8 || age > 150) {
            return MsgResponse.createError("参数错误，年龄范围8-150");
        } else {
            if (authorMapper.add(name, nikeName, age) == 1) {
                return MsgResponse.createSuccess(name + "注册成功");
            } else {
                return MsgResponse.createError(name + "注册失败");
            }
        }
    }

    @Override
    public MsgResponse<String> del(Integer authorid) {
        if (authorid == null) {
            return MsgResponse.createILLEGAL("参数缺少，作者id");
        } else {
            if (authorMapper.del(authorid) == 1) {
                return MsgResponse.createSuccess("删除成功");
            } else {
                return MsgResponse.createError("删除失败");
            }
        }
    }

    @Override
    public MsgResponse<String> set(Integer id, String name, String nikeName, Integer age) {
        if (id == null) {
            return MsgResponse.createILLEGAL("参数缺少，作者id");
        } else if (name == null) {
            return MsgResponse.createILLEGAL("参数缺少，作者姓名");
        } else if (age < 8 || age > 150) {
            return MsgResponse.createError("参数错误，年龄范围8-150");
        } else {
            if (authorMapper.set(id, name, nikeName, age) == 1) {
                return MsgResponse.createSuccess(name + "修改成功");
            } else {
                return MsgResponse.createError(name + "修改失败");
            }
        }
    }

    @Override
    public MsgResponse<Author> get(Integer authorid) {
        if (authorid == null) {
            //避免null转换基本数据类型异常
            return MsgResponse.createILLEGAL("参数缺少，作者id");
        } else {
            return MsgResponse.createSuccess("获取成功", authorMapper.get(authorid));
        }
    }

    @Override
    public MsgResponse<List<Author>> gets() {
        List<Author> list=authorMapper.gets();
        return MsgResponse.createSuccess("获取成功",list);
    }

    @Override
    public MsgResponse<PageInfo<List<Author>>> gets(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageSize == null) {
            return MsgResponse.createILLEGAL("参数缺少，当前页码，每页记录数");
        } else {
            //初始化分页插件
            PageHelper.startPage(pageNo, pageSize);
            //获取结果
            List<Author> list = authorMapper.gets();
            //封装结果，预加载5个页码
            PageInfo<List<Author>> pageInfo = new PageInfo(list, 5);
            return MsgResponse.createSuccess("获取成功", pageInfo);
        }
    }
}
