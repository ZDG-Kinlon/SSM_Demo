# SSM_Demo
基于SpringMVC、Spring、MyBatis的一个入门示例，附加pageHellper插件

测试结果
【作者模块】
增加接口：
 * 链接：http://127.0.0.1:8080/author
 * 请求：POST
 * 参数：authorName、authorNickName、authorAge
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/增加作者.jpg)
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/增加作者-年龄错误.jpg)
删除接口：
 * 链接：http://127.0.0.1:8080/author/[作者id]
 * 请求：DELETE
 * 参数：
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/删除作者.jpg)
修改接口：
 * 链接：http://127.0.0.1:8080/author/[作者id]
 * 请求：PUT
 * 参数：authorName、authorNickName、authorAge
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/修改作者.jpg)
查询接口：
 * 链接：http://127.0.0.1:8080/author/[作者id]
 * 请求：GET
 * 参数：
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/查询作者.jpg)
查询全部接口：
 * 链接：http://127.0.0.1:8080/all/author
 * 请求：GET
 * 参数：
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/查询全部作者.jpg)
分页查询接口：
 * 链接：http://127.0.0.1:8080/pages/author
 * 请求：GET
 * 参数：pageNo、pageSize
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/分页查询作者.jpg)

【文章模块】
增加接口：
 * 链接：http://127.0.0.1:8080/article
 * 请求：POST
 * 参数：authorId、articleTitle、articleContent
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/添加文章.jpg)
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/添加文章-超字数.jpg)
删除接口：
 * 链接：http://127.0.0.1:8080/article/[文章id]
 * 请求：DELETE
 * 参数：
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/删除文章.jpg)
修改接口：
 * 链接：http://127.0.0.1:8080/article/[文章id]
 * 请求：PUT
 * 参数：authorId、articleTitle、articleContent
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/修改文章.jpg)
查询接口：
 * 链接：http://127.0.0.1:8080/article/[文章id]
 * 请求：GET
 * 参数：
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/查询文章.jpg)
查询全部接口：
 * 链接：http://127.0.0.1:8080/all/article
 * 请求：GET
 * 参数：
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/查询全部文章.jpg)
分页查询接口：
 * 链接：http://127.0.0.1:8080/pages/article
 * 请求：GET
 * 参数：pageNo、pageSize
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/分页查询文章.jpg)
分页查询指定作者接口：
 * 链接：http://127.0.0.1:8080/pages/article/[作者id]
 * 请求：GET
 * 参数：pageNo、pageSize
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/分页查询指定作者的全部文章.jpg)
点赞接口：
 * 链接：http://127.0.0.1:8080/action/giveGood/[文章id]
 * 请求：PUT
 * 参数：
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/点赞成功.jpg)
![Image text](https://raw.githubusercontent.com/ZDG-Kinlon/SSM_Demo/master/etc/点赞失败-文章不存在.jpg)
