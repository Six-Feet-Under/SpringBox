#日志接口

###新增接口
```
url：http://localhost:8080/log/insertkey

参数：String(字符串类型的JSON数据)

方法类型：int类型
方法参数类型：Map类型

返回类型：执行成功或失败返回成功或失败页面（以ResponseJSONResult类型返回和响应数据）

返回值：JSON的data数据
```
###删除接口
```
url：http://localhost:8080/log/deleteByKey

参数：Long类型的id值（原生的sql语句是update语句根据id进行更新）

方法类型：int类型
方法参数类型：Long类型传入id值

返回值：执行成功或失败返回成功或失败页面（以ResponseJSONResult类型返回和响应数据）
```
```
url：http://localhost:8080/log/deleteByid

参数：Long类型的id值（后增加的sql语句是delete语句根据id进行删除）

方法类型：int类型
方法参数类型：Long类型传入id值

返回类型：执行成功或失败返回成功或失败页面（以ResponseJSONResult类型返回和响应数据）
```
###查询接口
```
url：http://localhost:8080/log/selectList

参数：Log类型的对象（原生的sql语句是select语句查询所有）

方法类型：list类型
方法参数类型：Log类型传入log对象

返回类型：执行成功或失败返回成功或失败页面（以ResponseJSONResult类型返回和响应数据）
```

```
url：http://localhost:8080/log/selectLogById

参数：Log类型的对象（原生的sql语句是select语句根据id查询log列表）

方法类型：list类型
方法参数类型：Log类型传入id值

返回类型：执行成功或失败返回成功或失败页面（以ResponseJSONResult类型返回和响应数据）
```

###更新接口
```
url：http://localhost:8080/log/updateByKey

参数：Log类型的对象（原生的sql语句是update语句根据id更新log列表）

方法类型：int类型
方法参数类型：Log类型传入log对象

返回类型：执行成功或失败返回成功或失败页面（以ResponseJSONResult类型返回和响应数据）
```
###详细日志信息接口
```
url：http://localhost:8080/log/detailsLog

参数：Log类型的对象（原生的sql语句是select语句根据id查询log列表）

方法类型：Log类型
方法参数类型：Long类型传入id对象

返回类型：执行成功或失败返回成功或失败页面（以ResponseJSONResult类型返回和响应数据）
```