package com.llf.springboot.controller;

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
@Api(value = "日志信息接口", tags = {"日志信息接口"})
public class LogController {

    @Autowired
    private LogService logService;

    @ApiOperation(value = "增加日志信息接口", notes = "增加日志信息")
    @RequestMapping(value = "/log/insertkey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
                    dataType = "string", paramType = "List")
    })
    public ResponseJSONResult insertkey(String strs) {
        strs = "{type=\"1\" actionId=\"超级管理员\" uid=\"超级管理员\" time=\"1594785056188\" dataStr=\"[超级管理员] 修改账号 [超级管理员]\"}";
        try {
            strs = strs.replace("=", ":");
            strs = strs.replace(" ", ",");
            Map map = JSON.parseObject(strs);
            System.out.println(map);
            if (logService.insertkey(map) == 1) {
                return ResponseJSONResult.ok(1);
            } else {
                return ResponseJSONResult.ok(0);
            }

        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }

    @RequestMapping(value = "/log/deleteByKey")
    public String deleteById(Long id) {
        logService.deleteByKey(id);
        return "1";
    }
}
