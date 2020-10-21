#用户信息接口

##登录              接口：/user/login             param:String name, String pwd

##通过key新增用户     接口：/user/insertKey         param:String strs 
##新增用户           接口：/user/insertUser        param:String strs
##注册用户           接口：/user/registerKey       param:User user

##通过key删除用户     接口：/user/deleteByKey       param:String strs
##通过id删除用户      接口：/user/deleteById        param:Long `id`
##通过id批量删除用户   接口：/user/batchDelete       param:request 获取前端items

##更新用户           接口：/user/updateKey         param:User user

##查询所有用户        接口：/user/selectAll         param:User user
##通过Id查询用户      接口：/user/selectById        param:Long id
##分页查询用户        接口：/user/selectPageAll     param:int pageNum,int countNum




