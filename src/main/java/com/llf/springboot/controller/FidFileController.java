package com.llf.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.llf.springboot.model.FidFile;
import com.llf.springboot.service.FidFileService;
import com.llf.springboot.util.ExcelUtil;
import com.llf.springboot.util.ResponseJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "文件信息接口", tags = {"文件信息接口"})
public class FidFileController {

    @Autowired
    private FidFileService fidFileService;

    @ApiOperation(value = "获取文件信息接口", notes = "文件信息Map")
    @RequestMapping(value = "/fidFile/selectAll", method = RequestMethod.POST)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="fidFile", value="文件", required=false,
//                    dataType="json", paramType="FidFile")
//    })
    public ResponseJSONResult selectAll(FidFile fidFile) {
        List<FidFile> list = fidFileService.selectList(fidFile);
        return ResponseJSONResult.ok(list);
    }

    @ApiOperation(value = "获取所有文件信息", notes = "文件信息Map")
    @RequestMapping(value = "/fidFile/selectList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "查询第几页",required = true,
            dataType = "Integer",paramType = "list"),
            @ApiImplicitParam(name = "countNum",value = "每页的数据条数",required = true,
            dataType = "Integer",paramType = "list"),
            @ApiImplicitParam(name = "txt",value = "过滤条件",required = false,
            dataType = "String",paramType = "list")
    })
    public ResponseJSONResult selectList(Integer pageNum, Integer countNum,String txt) {
        try {
            pageNum = (pageNum-1)*countNum;
            return ResponseJSONResult.ok(fidFileService.selectAll(pageNum,countNum));
        }catch (Exception e){
            return ResponseJSONResult.errorMsg("信息错误");
        }

    }

    @ApiOperation(value = "新增文件信息接口", notes = "文件信息Map")
    @RequestMapping(value = "/fidFile/insertkey", method = RequestMethod.POST)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
//                    dataType = "string", paramType = "List")
//    })
    public ResponseJSONResult insertkey(FidFile fidFile) {
        try {
            return ResponseJSONResult.ok(fidFileService.insertkey(fidFile));
        } catch (Exception e) {
            return ResponseJSONResult.ok("数据错误");
        }
    }

    @ApiOperation(value = "新增文件信息接口", notes = "FidFile实体类")
    @RequestMapping(value = "/fidFile/insertfidFile",method = RequestMethod.POST)
    @ApiImplicitParam(name = "fidFile",value = " /** 自增主键*/\n" +
            "    private String fid;\n" +
            "\t/** 文件标签&分类*/\n" +
            "\tprivate String  tag ;\n" +
            "\t/** 创建时间 */\n" +
            "\tprivate Long  makeTime;\n" +
            "\t/** 借阅次数 */\n" +
            "\tprivate Long  borrowNumber;\n" +
            "\t/** 操作Id */\n" +
            "\tpublic String action;\n" +
            "\t/** 操作时间 */\n" +
            "\tprivate Long  actionTime ;\n" +
            "\t/** 文件名称 */\n" +
            "\tprivate String fileName;\n" +
            "\n" +
            "\t/** 文件描述 */\n" +
            "\tprivate String fileDes;\n" +
            "\t/** 创建Id */\n" +
            "\tprivate String creatId;\n" +
            "\t/** 文件状态 */\n" +
            "\tprivate String fileState;\n" +
            "\t/** 文件位置 */\n" +
            "\tprivate Long fileWhere;\n" +
            "\t/** 文件标志 */\n" +
            "\tprivate String fileAbandon;\n" +
            "\t/** 其他信息 */\n" +
            "\tprivate String dataStr;\n" +
            "\t/** 文件权限 */\n" +
            "\tpublic int filePermission = -1;\n" +
            "\t/** 文件归属 */\n" +
            "\tpublic String fileAttribution = \"\";",required = true,
    dataType = "FidFile",paramType = "int")
    public ResponseJSONResult insertfidFile(FidFile fidFile){

        try {
            return ResponseJSONResult.ok(fidFileService.insertfidFile(fidFile));
        }catch (Exception e){
            return ResponseJSONResult.errorSqlMsg("sql语句错误");
        }
    }

    @ApiOperation(value = "更新文件信息接口", notes = "文件信息列表")
    @RequestMapping(value = "/fidFile/updatekey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
                    dataType = "string", paramType = "List"),
    })
    public ResponseJSONResult updatekey(String strs) {
        //strs="{fid=\"1\" fileWhere=\"1\" actionTime=\"1595411202022\" action=\"000000\" fileState=\"在册\" fileAbandon=\"true\" borrowNumber=\"9\" }";
        try {
            strs = strs.replace("=", ":");
            strs = strs.replace(" ", ",");
            System.out.println(strs);
            Map map = JSON.parseObject(strs);
            if (fidFileService.updateByKey(map) == 1) {
                return ResponseJSONResult.ok(1);
            } else {
                return ResponseJSONResult.ok(0);
            }
        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }

    @ApiOperation(value = "更新文件信息接口", notes = "文件实体类")
    @RequestMapping(value = "/fidFile/updatefidFile", method = RequestMethod.POST)
    @ApiImplicitParam(name = "fidFile",value = " /** 自增主键*/\n" +
            "    private String fid;\n" +
            "\t/** 文件标签&分类*/\n" +
            "\tprivate String  tag ;\n" +
            "\t/** 创建时间 */\n" +
            "\tprivate Long  makeTime;\n" +
            "\t/** 借阅次数 */\n" +
            "\tprivate Long  borrowNumber;\n" +
            "\t/** 操作Id */\n" +
            "\tpublic String action;\n" +
            "\t/** 操作时间 */\n" +
            "\tprivate Long  actionTime ;\n" +
            "\t/** 文件名称 */\n" +
            "\tprivate String fileName;\n" +
            "\n" +
            "\t/** 文件描述 */\n" +
            "\tprivate String fileDes;\n" +
            "\t/** 创建Id */\n" +
            "\tprivate String creatId;\n" +
            "\t/** 文件状态 */\n" +
            "\tprivate String fileState;\n" +
            "\t/** 文件位置 */\n" +
            "\tprivate Long fileWhere;\n" +
            "\t/** 文件标志 */\n" +
            "\tprivate String fileAbandon;\n" +
            "\t/** 其他信息 */\n" +
            "\tprivate String dataStr;\n" +
            "\t/** 文件权限 */\n" +
            "\tpublic int filePermission = -1;\n" +
            "\t/** 文件归属 */\n" +
            "\tpublic String fileAttribution = \"\";",required = true,
            dataType = "FidFile",paramType = "int")
    public ResponseJSONResult updatefidFile(FidFile fidFile){
        try {
            return ResponseJSONResult.ok(fidFileService.updatefidFile(fidFile));
        }catch (Exception e){
            return ResponseJSONResult.errorSqlMsg("0");
        }
    }

    @ApiOperation(value = "根据fid删除文件信息", notes = "成功与否")
    @RequestMapping(value = "/fidFile/deleteById", method = RequestMethod.POST)
    public ResponseJSONResult deleteById(String fid) {
        fidFileService.deleteById(fid);
        return ResponseJSONResult.ok("删除成功");
    }

    @ApiOperation(value = "根据fid查询文件信息", notes = "文件信息Map")
    @RequestMapping(value = "/fidFile/selectById", method = RequestMethod.POST)
    public ResponseJSONResult selectById(String fid) {
        return ResponseJSONResult.ok(fidFileService.selectById(fid));
    }

    /**
     * 导出t_site为Excel
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/exportExcelOfSite", method = RequestMethod.POST)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "response",required = true,
            dataType = "reponse",paramType = "Excel")

    )
    public void exportExcelOfSite(HttpServletResponse response, String user_site) throws Exception {

        Map map = new HashMap();
        map.put("user_site",user_site);
        //要导出文件的list集合
        List<Map> list = new ArrayList();
        //list = deviceGroupService.listSite(map);
        list = fidFileService.listFile();
        String fileName = "文件列表·" + System.currentTimeMillis() + ".xlsx";

        //sheet名
        String sheetName = "文件信息";

        String[][] content = new String[list.size()][8];

        for (int i = 0; i < list.size(); i++) {

            Map obj = list.get(i);
            String state = null;//状态

            ExcelUtil su = new ExcelUtil();
            content[i][0] = su.cecknull(String.valueOf(obj.get("fid")));
            content[i][1] = su.cecknull(String.valueOf(obj.get("fileName")));
            content[i][2] = su.cecknull(String.valueOf(obj.get("tag")));
            content[i][3] = su.cecknull(String.valueOf(obj.get("fileDes")));
            content[i][4] = su.cecknull(String.valueOf(obj.get("fileWhere")));
            content[i][5] = su.cecknull(String.valueOf(obj.get("fileState")));
        }

        //创建HSSFWorkbook
        SXSSFWorkbook wb = ExcelUtil.getSXSSFWorkbook(sheetName, new String[]{"文件id", "文件名", "类型", "说明","位置","状态"}, content, null);

        //响应到客户端
        try {
            ExcelUtil.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
