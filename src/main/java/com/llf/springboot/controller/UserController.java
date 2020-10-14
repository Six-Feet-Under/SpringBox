package com.llf.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.llf.springboot.model.User;
import com.llf.springboot.service.UserService;
import com.llf.springboot.util.ResponseJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "用户信息接口", tags = {"用户信息接口"})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息接口", notes = "用户信息列表")
    @RequestMapping(value = "/user/selectAll", method = RequestMethod.POST)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "user", value = "用户", required = false,
//                    dataType = "json", paramType = "User"),
//    })
    public ResponseJSONResult selectAll(User user) {
        List<User> list = userService.selectList(user);
//        PagedResult result = new PagedResult();
//        if (page == null) {
//            page = 1;
//        }
//        if (pageSize == null) {
//            pageSize = 10;
//        }
//        int count = list.size();
//        if (count > 0) {
//            result.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
//            result.setPage(page);
//            result.setRecords(count);
//            result.setRows(list.subList(page == 1 ? 0 : (page - 1) * pageSize,
//                    count - (page == 1 ? 0 : (page - 1) * pageSize) > pageSize ?
//                            (page == 1 ? 0 : (page - 1) * pageSize) + pageSize : count));
//        }
        return ResponseJSONResult.ok(list);
    }

    @ApiOperation(value = "删除用户信息接口", notes = "删除用户信息")
    @RequestMapping(value = "/user/deleteByKey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
                    dataType = "string", paramType = "List")
    })
    public ResponseJSONResult deleteByKey(String strs) {
        int sum = 0;
        //strs="[{_id=\"8\" uid=\"z111111\" name=\"z111111\" pwd=\"94cc9d056a08cc894e79577ff94e31f2\" time=\"1593602583466\" timeOut=\"null\" timeMake=\"null\" phone=\"\" Abandon=\"false\" Grade=\"1\" PwdHint=\"\"}, {_id=\"1\" uid=\"000000\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1593758764185\" timeOut=\"null\" timeMake=\"1593595736930\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"false\"}, {_id=\"3\" uid=\"000001\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1594718739785\" timeOut=\"null\" timeMake=\"1593758999492\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"true\"}]";
        try {
            strs = strs.replace("=", ":");
            strs = strs.replace(" ", ",");
            Map map = JSON.parseObject(strs);
            userService.deleteByKey(map);
            String sumlog = "删除成功";
            return ResponseJSONResult.ok(sumlog);
        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }

    @ApiOperation(value = "增加用户信息接口", notes = "增加用户信息")
    @RequestMapping(value = "/user/insertkey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
                    dataType = "string", paramType = "List")
    })
    public ResponseJSONResult insertkey(String strs) {
        int sum = 0;
        int sumin = 0;
        int sumup = 0;
        //strs="[{_id=\"8\" uid=\"z111111\" name=\"z111111\" pwd=\"94cc9d056a08cc894e79577ff94e31f2\" time=\"1593602583466\" timeOut=\"null\" timeMake=\"null\" phone=\"\" Abandon=\"false\" Grade=\"1\" PwdHint=\"\"}, {_id=\"1\" uid=\"000000\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1593758764185\" timeOut=\"null\" timeMake=\"1593595736930\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"false\"}, {_id=\"3\" uid=\"000001\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1594718739785\" timeOut=\"null\" timeMake=\"1593758999492\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"true\"}]";
        try {
            strs = strs.replace("=", ":");
            strs = strs.replace(", ", ",");
            strs = strs.replace(" ", ",");
            strs = strs.replace("null", "-1");
            List lisMap = JSON.parseArray(strs);
            for (int i = 0; i < lisMap.size(); i++) {
                Map map = JSON.parseObject(lisMap.get(i).toString());
                sum++;
                if (userService.insertkey(map) == 1) {
                    sumin++;
                }
                if (userService.insertkey(map) == 2) {
                    sumup++;
                }
            }
            String sumlog = "总数：" + sum + "新增：" + sumin + "更新：" + sumup;
            return ResponseJSONResult.ok(sumlog);
        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }
}
