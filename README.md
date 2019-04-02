
# Gateway2.0

## 此例程是Gateway2.0的中台微服务程序
- 依赖微服务管理中心：/conf/mic-registry.json，如果想取消则设为失活
- 依赖私服仓库（请下载到本地并安装nexus，建立netos宿主仓指定你下载的本地仓目录）https://github.com/carocean/cj.studio.nexus.artifact

## 用法：
	下载源码导入eclipse
	配置eclipse 的gradle
	运行cj.studio.gateway.examples.backend.debug项目中的main函数,此时一定报错，不必担心，打开debug选项，添加参数：
	-debug /xx/xx/xx/cj.studio.gateway.examples.backend/cmdtools/gateway 此为gateway所在位置
	
## 访问：http://localhost:9090/uc/
结果显示本中台程序内所含的微服务api,如下：

******************************************************
       usercenter
         标识：3AD05D29-80AE-440B-AC52-C9D9150F9797
         版本：1.0.0.0
         产品：cj.studio.gateway.examples.backend.usercenter
         公司：cj工作室
         版权：Copyright 2011
         描述：cj工作室出品，lns平台制造
******************************************************
/uc/dept/
    cj.studio.gateway.examples.backend.usercenter.stub.IDeptStub
    用法:部门管理

    save
        用法:xx
        方法别名:
        命令:post
        协议:http/1.1
        参数:
                arg0
                    类型:cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO
                    方式：InContent
                    用法:xx

    testArg
        用法:xx
        方法别名:
        命令:post
        协议:http/1.1
        参数:
                arg0
                    类型:cj.studio.gateway.examples.backend.usercenter.bo.DeptmentBO
                    方式：InContent
                    用法:json格式

    getAll
        用法:xx
        返回值类型:java.util.ArrayList,说明:xx
        方法别名:
        命令:get
        协议:http/1.1
        参数:


/uc/user/
    cj.studio.gateway.examples.backend.usercenter.stub.IUserStub
    用法:用户管理

    delete
        用法:保存
        方法别名:delete
        命令:get
        协议:http/1.1
        参数:
                arg0
                    类型:long
                    方式：InHeader User-ID
                    用法:用户标识

    save
        用法:保存
        返回值类型:java.lang.Long,说明:返回自增长标识
        方法别名:save
        命令:post
        协议:http/1.1
        参数:
                arg0
                    类型:cj.studio.gateway.examples.backend.usercenter.bo.UserBO
                    方式：InContent
                    用法:用户实体UserBO

    query
        用法:保存
        返回值类型:java.util.ArrayList,说明:返回用户列表
        方法别名:query2
        命令:get
        协议:http/1.1
        参数:
                arg0
                    类型:java.lang.String
                    方式：InParameter name
                    用法:姓名
                arg1
                    类型:int
                    方式：InParameter age
                    用法:年龄

    query
        用法:保存
        返回值类型:java.util.ArrayList,说明:返回用户列表
        方法别名:query
        命令:get
        协议:http/1.1
        参数:

    getUser
        用法:获取用户
        返回值类型:cj.studio.gateway.examples.backend.usercenter.bo.UserBO,说明:xxx
        方法别名:getUser
        命令:get
        协议:http/1.1
        参数:
                arg0
                    类型:long
                    方式：InParameter id
                    用法:xx


