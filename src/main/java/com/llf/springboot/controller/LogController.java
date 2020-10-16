package com.llf.springboot.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.llf.springboot.model.FidFile;
import com.llf.springboot.model.Log;
import com.llf.springboot.service.FidFileService;
import com.llf.springboot.service.LogService;
import com.llf.springboot.util.PagedResult;
import com.llf.springboot.util.ResponseJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @ApiOperation(value="删除日志信息接口", notes="删除日志信息")
    @RequestMapping(value = "/log/deleteByKey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户列表", required = true,
                    dataType = "Long", paramType = "list")
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
                    dataType = "Long", paramType = "list")
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
            @ApiImplicitParam(name = "log", value = "用户列表", required = true,
                    dataType = "Log", paramType = "List")
    })

    public ResponseJSONResult selectList(Log log){
        List<Log> list = logService.selectList(log);
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
            @ApiImplicitParam(name = "log", value = "用户列表", required = true,
                    dataType = "Log", paramType = "list")
    })
    public ResponseJSONResult updateByKey(Log log) {

        if (logService.updateByKey(log) != 1) {
            return ResponseJSONResult.ok(0);
        } else {
            return ResponseJSONResult.ok(1);
        }

    }

    @ApiOperation(value="详细信息日志信息接口", notes="详细信息日志信息")
    @RequestMapping(value = "/log/detailsLog", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "log", value = "用户列表", required = true,
                    dataType = "Log", paramType = "list")
    })
    public ResponseJSONResult detailsLog(Log log) {

        return ResponseJSONResult.ok(logService.detailsLog(log));

    }
}
