package com.llf.springboot.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.llf.springboot.model.FidFile;
import com.llf.springboot.model.Log;
import com.llf.springboot.service.FidFileService;
import com.llf.springboot.service.LogService;
import com.llf.springboot.util.ExcelUtil;
import com.llf.springboot.util.PagedResult;
import com.llf.springboot.util.ResponseJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "日志信息接口",tags = {"日志信息接口"})
public class LogController {

    @Autowired
    private LogService logService;

    @ApiOperation(value="增加日志信息接口", notes="增加日志信息")
    @RequestMapping(value = "/log/insertkey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
                    dataType = "string", paramType = "Map")
    })
    public ResponseJSONResult insertkey(String strs) {
        //strs="{types=\"3\" actionId=\"超级管理员\" uid=\"1\" time=\"1594785056188\" dataStr=\"[超级管理员] 修改账号 [超级管理员]\"}";
        try {
            strs = strs.replace("=", ":");
            strs = strs.replace(" ", ",");
            Map map=JSON.parseObject(strs);
            if(logService.insertkey(map) == 1) {
                return ResponseJSONResult.ok(1);
            } else {
                return ResponseJSONResult.ok(0);
            }

        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }


    @ApiOperation(value="增加日志信息接口", notes="增加日志信息")
    @RequestMapping(value = "/log/insertLog", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "log", value = "private Long id;             // 数据库主键\n" +
                    "    private String types;        // 日志类型\n" +
                    "    private String actionId;        // 操作Id\n" +
                    "    private String actionResult;    // 操作结果 0 无, -1失败, 1成功\n" +
                    "    private String uid;          // 用户id\n" +
                    "    private String target;       // 目标\n" +
                    "    private Long time;           // 操作时间\n" +
                    "    private String dataStr;      // 备用数据", required = true,
                    dataType = "Log", paramType = "int")

    })
    public ResponseJSONResult insertLog(Log log) {
        try {

            if(logService.insertLog(log) == 1) {
                return ResponseJSONResult.ok(1);
            } else {
                return ResponseJSONResult.ok(0);
            }

        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }

    @ApiOperation(value="删除日志信息接口", notes="删除日志信息")
    @RequestMapping(value = "/log/deleteByKey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户列表", required = true,
                    dataType = "Long", paramType = "int")
    })
    public ResponseJSONResult deleteByKey(Long id) {
        try {
            if (logService.deleteByKey(id) != 1) {
                return ResponseJSONResult.ok(0);
            } else {
                return ResponseJSONResult.ok(1);
            }
        } catch (Exception e) {
            return ResponseJSONResult.errorSqlMsg("语句错误");
        }

    }

    @ApiOperation(value="删除日志信息接口", notes="删除日志信息")
    @RequestMapping(value = "/log/deleteByid", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户列表", required = true,
                    dataType = "Long", paramType = "int")
    })
    public ResponseJSONResult deleteByid(Long id) {

        if (logService.deleteByid(id) != 1) {
            return ResponseJSONResult.ok(0);
        } else {
            return ResponseJSONResult.ok(1);
        }

    }

    @ApiOperation(value="查找日志信息接口", notes="查找日志信息")
    @RequestMapping(value = "/log/selectList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageSize", value = "当前页数", required = true,
                    dataType = "Integer", paramType = "List"),
            @ApiImplicitParam(name = "pageCount", value = "显示的条数", required = true,
            dataType = "Integer", paramType = "List")
    })

    public ResponseJSONResult selectList(@Param("pageSize") Integer pageSize , @Param("pageCount") Integer pageCount){
        /*int count = list.size();
        int pageSize =  10;
        int page = count / pageSize;
        PagedResult result = new PagedResult();
        if (page == 0) {
            page = 1;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        if (count > 0) {
            result.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
            result.setPage(page);
            result.setRecords(count);
            result.setRows(list.subList(page == 1 ? 0 : (page - 1) * pageSize,
                    count - (page == 1 ? 0 : (page - 1) * pageSize) > pageSize ?
                            (page == 1 ? 0 : (page - 1) * pageSize) + pageSize : count));
        }*/
        try {

            return ResponseJSONResult.ok(logService.selectList((pageSize - 1) * pageCount, pageCount));
        } catch (Exception e) {
            return ResponseJSONResult.errorMsg("信息错误");
        }
        //return ResponseJSONResult.ok(logService.selectList((pageSize-1)*pageCount,pageCount));
    }

    @ApiOperation(value="查找日志信息接口", notes="查找日志信息")
    @RequestMapping(value = "/log/selectAll", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "", value = "", required = true,
                    dataType = "", paramType = "List")
    })

    public ResponseJSONResult selectAll(){
        /*int count = list.size();
        int pageSize =  10;
        int page = count / pageSize;
        PagedResult result = new PagedResult();
        if (page == 0) {
            page = 1;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        if (count > 0) {
            result.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
            result.setPage(page);
            result.setRecords(count);
            result.setRows(list.subList(page == 1 ? 0 : (page - 1) * pageSize,
                    count - (page == 1 ? 0 : (page - 1) * pageSize) > pageSize ?
                            (page == 1 ? 0 : (page - 1) * pageSize) + pageSize : count));
        }*/
        try {

            return ResponseJSONResult.ok(logService.selectAll());
        } catch (Exception e) {
            return ResponseJSONResult.errorMsg("信息错误");
        }
        //return ResponseJSONResult.ok(logService.selectList((pageSize-1)*pageCount,pageCount));
    }

    @ApiOperation(value="根据日志id查找日志信息接口", notes="根据日志id查找日志信息")
    @RequestMapping(value = "/log/selectLogById", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户列表", required = true,
                    dataType = "Long", paramType = "List")
    })

    public ResponseJSONResult selectLogById(Long id){
        List<Log> list = logService.selectLogById(id);
        PagedResult result = new PagedResult();
        /*if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        int count = list.size();
        if (count > 0) {
            result.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
            result.setPage(page);
            result.setRecords(count);
            result.setRows(list.subList(page == 1 ? 0 : (page - 1) * pageSize,
                    count - (page == 1 ? 0 : (page - 1) * pageSize) > pageSize ?
                            (page == 1 ? 0 : (page - 1) * pageSize) + pageSize : count));
        }*/
        return ResponseJSONResult.ok(list);
    }

    @ApiOperation(value="更新日志信息接口", notes="更新日志信息")
    @RequestMapping(value = "/log/updateByKey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "log", value = "private Long id;             // 数据库主键\n" +
                    "    private String types;        // 日志类型\n" +
                    "    private String actionId;        // 操作Id\n" +
                    "    private String actionResult;    // 操作结果 0 无, -1失败, 1成功\n" +
                    "    private String uid;          // 用户id\n" +
                    "    private String target;       // 目标\n" +
                    "    private Long time;           // 操作时间\n" +
                    "    private String dataStr;      // 备用数据", required = true,
                    dataType = "Log", paramType = "int")
    })
    public ResponseJSONResult updateByKey(Log log) {

        if (logService.updateByKey(log) != 1) {
            return ResponseJSONResult.ok(0);
        } else {
            return ResponseJSONResult.ok(1);
        }

    }

    @ApiOperation(value="更新日志信息接口", notes="更新日志信息")
    @RequestMapping(value = "/log/updateById", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "log", value = "private Long id;             // 数据库主键\n" +
                    "    private String types;        // 日志类型\n" +
                    "    private String actionId;        // 操作Id\n" +
                    "    private String actionResult;    // 操作结果 0 无, -1失败, 1成功\n" +
                    "    private String uid;          // 用户id\n" +
                    "    private String target;       // 目标\n" +
                    "    private Long time;           // 操作时间\n" +
                    "    private String dataStr;      // 备用数据", required = true,
                    dataType = "Log", paramType = "int")
    })
    public ResponseJSONResult updateById(Log log) {

        if (logService.updateById(log) != 1) {
            return ResponseJSONResult.ok(0);
        } else {
            return ResponseJSONResult.ok(1);
        }

    }

    @ApiOperation(value="详细信息日志信息接口", notes="详细信息日志信息")
    @RequestMapping(value = "/log/detailsLog", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "log", value = "private Long id;             // 数据库主键\n" +
                    "    private String types;        // 日志类型\n" +
                    "    private String actionId;        // 操作Id\n" +
                    "    private String actionResult;    // 操作结果 0 无, -1失败, 1成功\n" +
                    "    private String uid;          // 用户id\n" +
                    "    private String target;       // 目标\n" +
                    "    private Long time;           // 操作时间\n" +
                    "    private String dataStr;      // 备用数据", required = true,
                    dataType = "Log", paramType = "Log")
    })
    public ResponseJSONResult detailsLog(Log log) {

        return ResponseJSONResult.ok(logService.detailsLog(log));

    }


    /**
     * 导出t_site为Excel
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/log/exportExcelOfSite", method = RequestMethod.GET)

    public void exportExcelOfSite(HttpServletResponse response) throws Exception {
        //要导出文件的list集合
        List<Map> list = new ArrayList();
        list = logService.selectAll();
        String fileName = "日志列表·" + System.currentTimeMillis() + ".xlsx";

        //sheet名
        String sheetName = "日志";
        String[][] content = new String[list.size()][8];

        for (int i = 0; i < list.size(); i++) {

            Map obj = list.get(i);

            ExcelUtil su = new ExcelUtil();
            content[i][0] = su.cecknull(String.valueOf(obj.get("id")));
            content[i][1] = su.cecknull(String.valueOf(obj.get("types")));
            content[i][2] = su.cecknull(String.valueOf(obj.get("actionId")));
            content[i][3] = su.cecknull(String.valueOf(obj.get("actionResult")));
            content[i][4] = su.cecknull(String.valueOf(obj.get("uid")));
            content[i][5] = su.cecknull(String.valueOf(obj.get("target")));
            content[i][5] = su.cecknull(String.valueOf(obj.get("time")));
            content[i][5] = su.cecknull(String.valueOf(obj.get("dataStr")));
        }

        //创建HSSFWorkbook
        SXSSFWorkbook wb = ExcelUtil.getSXSSFWorkbook(sheetName, new String[]{"日志id", "日志类型", "操作Id","操作结果" ,"用户id","目标","操作时间","详细数据"}, content, null);

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
