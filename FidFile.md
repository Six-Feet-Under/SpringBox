#文件信息接口

##查询接口 ：查询所有的文件数据

#### url:/fidFile/selectList

#### 参数 ：没有参数
     返回值：ResponseJSONResult  data里包含查询出的所有文件信息的list
     {
     	"status": 200,
     	"msg": "OK",
     	"data": [
     		{
     			"fid": "1",
     			"tag": "1",
     			"makeTime": 1,
     			"borrowNumber": 9,
     			"action": "000000",
     			"actionTime": 1595411202022,
     			"fileName": "1",
     			"fileDes": "1",
     			"creatId": "1",
     			"fileState": "在册",
     			"fileWhere": 1,
     			"fileAbandon": "true",
     			"dataStr": "1",
     			"filePermission": 1,
     			"fileAttribution": "1"
     		},
     		{
     			"fid": "2",
     			"tag": "1",
     			"makeTime": 1,
     			"borrowNumber": 1,
     			"action": "1",
     			"actionTime": 1,
     			"fileName": "1",
     			"fileDes": "1",
     			"creatId": "1",
     			"fileState": "1",
     			"fileWhere": 1,
     			"fileAbandon": "1",
     			"dataStr": "1",
     			"filePermission": 1,
     			"fileAttribution": "1"
     		},
     		{
     			"fid": "6",
     			"tag": null,
     			"makeTime": null,
     			"borrowNumber": null,
     			"action": null,
     			"actionTime": null,
     			"fileName": null,
     			"fileDes": null,
     			"creatId": "666545",
     			"fileState": null,
     			"fileWhere": null,
     			"fileAbandon": null,
     			"dataStr": "35351351351353535",
     			"filePermission": -1,
     			"fileAttribution": ""
     		}
     	],
     	"ok": null
     }
     
     
     
 ##删除接口:根据fid删除对应的数据
        
 ####url:/fidFile/deleteById
 
 ####参数 fid

| 参数名        | 类型    |  实例  |
| :--------:   | -----  | :----: |
|   fid     |  String    | 6   |
    
    返回值：ResponseJSONResult data里有删除是否成功
       {
        "status": 200,
        "msg": "OK",
        "data": "删除成功",
        "ok": null
       }
       
##查询接口：根据fid查询相应的文件数据

####url:/fidFile/selectById

####参数 fid

| 参数名        | 类型    |  实例  |
| :--------:   | -----  | :----: |
|   fid     |  String    | 6   |

    {
        "status": 200,
        "msg": "OK",
        "data": {
            "fid": "6",
            "tag": null,
            "makeTime": null,
            "borrowNumber": null,
            "action": null,
            "actionTime": null,
            "fileName": null,
            "fileDes": null,
            "creatId": "666545",
            "fileState": null,
            "fileWhere": null,
            "fileAbandon": null,
            "dataStr": "35351351351353535",
            "filePermission": -1,
            "fileAttribution": ""
        },
        "ok": null
    }
