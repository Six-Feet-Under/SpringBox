package com.llf.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.llf.springboot.model.User;
import com.llf.springboot.service.UserService;
import com.llf.springboot.util.DateUtils;
import com.llf.springboot.util.PagedResult;
import com.llf.springboot.util.ResponseJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.lang.reflect.Method;
import java.util.*;


@RestController
@Api(value = "用户信息接口", tags = {"用户信息接口"})
public class UserController {

    @Autowired
    public UserService userService;
    public DateUtils dateUtils;

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
    @RequestMapping(value = "/user/insertKey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
                    dataType = "string", paramType = "List")
    })
    public ResponseJSONResult insertkey(String strs) {
        int sum = 0;
        int sumin = 0;
        int sumup = 0;
       // strs="[{id=\"11\" uid=\"z111111\" name=\"z111111\" pwd=\"94cc9d056a08cc894e79577ff94e31f2\" time=\"1593602583466\" timeOut=\"null\" timeMake=\"null\" phone=\"\" Abandon=\"false\" Grade=\"1\" PwdHint=\"\"}, {_id=\"111\" uid=\"000000\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1593758764185\" timeOut=\"null\" timeMake=\"1593595736930\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"false\"}, {_id=\"122\" uid=\"000001\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1594718739785\" timeOut=\"null\" timeMake=\"1593758999492\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"true\"}]";
       //strs="[{id=\"22\" uid=\"z111111\" name=\"z111111\" pwd=\"94cc9d056a08cc894e79577ff94e31f2\" time=\"1593602583466\" timeOut=\"null\" timeMake=\"null\" phone=\"\" abandon=\"false\" grade=\"1\" pwdhint=\"\"}]";
        try {
            strs = strs.replace("=", ":");
            strs = strs.replace(", ", ",");
            strs = strs.replace(" ", ",");
            strs = strs.replace("null", "-1");
            List lisMap = JSON.parseArray(strs);
            for (int i = 0; i < lisMap.size(); i++) {
                Map map = JSON.parseObject(lisMap.get(i).toString());
                sum++;
                if (userService.insertkey(map) == 1) {sumin++;}
                if (userService.insertkey(map) == 2) {sumup++;}
            }
            String sumlog = "总数：" + sum + "新增：" + sumin + "更新：" + sumup;
            return ResponseJSONResult.ok(sumlog);
        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }

    @ApiOperation(value = "注册用户信息接口", notes = "注册用户信息")
    @RequestMapping(value = "/user/registerKey", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "strs", value = "用户列表", required = true,
                    dataType = "string", paramType = "List")
    })
    public ResponseJSONResult registerkey(String strs) {
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
                if (userService.insertkey(map) == 1) {sumin++;}
                if (userService.insertkey(map) == 2) {sumup++;}
            }
            String sumlog = "总数：" + sum + "新增：" + sumin + "更新：" + sumup;
            return ResponseJSONResult.ok(sumlog);
        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
    }


    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseJSONResult login( String name, String pwd) {
        //name = request.getParameter("name");
        //pwd = request.getParameter("pwd");
        try{
            User user = userService.login(name, pwd);
            if (user.getGrade().equals("1") || user.getGrade().equals("3") ){
                //return 用户；
                return ResponseJSONResult.ok(user.getGrade());
            } else{
                return  ResponseJSONResult.errorSqlMsg("user为空");
            }
        }catch (Exception e ){
            return ResponseJSONResult.errorNullSql("sql错误");
        }

    }
//    @RequestMapping(value="/login",method=RequestMethod.POST)
//    public String  login( String name, String pwd) {
//
//        System.out.println("aaaaaaaaaaaaaaaaa"+name+pwd);
//            User user = userService.login(name, pwd);
//            System.out.println(user.getGrade());
//            return "1";
//
//    }
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String login(@Param("name") String name ,@Param("pwd") String pwd){
//			User user= userService.login(name,pwd);
//			if(user.getGrade().equals("0")){
//				return "Uindex";
//			}else if(user.getGrade().equals("1")){
//				return "Mindex";
//
//		}else{
//			return "error";
//		}
//	}

    @RequestMapping(value = "/user/deleteById",method= RequestMethod.POST)
    public ResponseJSONResult deleteUserById(int id){
        try{
            userService.deleteUserById(id);
            if(id == 0){
                return ResponseJSONResult.errorNullSql("id为空");
            }
            return ResponseJSONResult.ok(id);
        }catch (Exception e){
        //return  “sucess”
        return ResponseJSONResult.errorSqlMsg("sql错误");}
    }

    @ApiOperation(value = "根据Id查询用户接口",notes = "根据Id查询用户信息")
    @RequestMapping(value = "/user/selectById",method= RequestMethod.POST)
    public ResponseJSONResult selectById(Long id){
        try{
            User user = userService.selectById(id);
            if(user == null){
                return  ResponseJSONResult.errorNullSql("user为空");
            }
            return ResponseJSONResult.ok(user);
        }catch (Exception e){
            return ResponseJSONResult.errorSqlMsg("sql错误");
        }
    }


//    @RequestMapping(value = "/user/register",method= RequestMethod.POST)
//    public String registerUser(String uid,String name,String pwd,String grade,String abandon){
//        User user  = new User();
//        user.setUid(uid);
//        user.setName(name);
//        user.setPwd(pwd);
//        //user.setTimeMake((Long.parseLong(dateUtils.GetDate(new Date()))));
//        user.setGrade(grade);
//        user.setAbandon(abandon);
//        userService.registerUser(user);
//        return "login";
//    }

//    @RequestMapping(value = "/user/insert",method= RequestMethod.POST)
//    public String insertUser(String uid,String name,String pwd,String grade,String abandon){
//        User user  = new User();
//        user.setUid(uid);
//        user.setName(name);
//        user.setPwd(pwd);
//        //user.setTimeMake((Long.parseLong(dateUtils.GetDate(new Date()))));
//        user.setGrade(grade);
//        user.setAbandon(abandon);
//        userService.registerUser(user);
//        return "login";
//    }

//    @RequestMapping(value = "/user/update",method= RequestMethod.POST)
//    public String updateUser(Long id,String uid,String name,String pwd,String phone,String grade,String abandon){
//        User user = userService.selectUserById(id);
//        user.setUid(uid);
//        user.setName(name);
//        user.setPwd(pwd);
//        user.setPhone(phone);
//        user.setGrade(grade);
//        user.setAbandon(abandon);
//        userService.updateUser(user);
//        return "user";
//    }

    @RequestMapping(value = "/user/updateKey",method= RequestMethod.POST)
    public ResponseJSONResult updatekey(String strs){
        //strs="[{_id=\"8\" uid=\"z111111\" name=\"z111111\" pwd=\"94cc9d056a08cc894e79577ff94e31f2\" time=\"1593602583466\" timeOut=\"null\" timeMake=\"null\" phone=\"\" Abandon=\"false\" Grade=\"1\" PwdHint=\"\"}, {_id=\"1\" uid=\"000000\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1593758764185\" timeOut=\"null\" timeMake=\"1593595736930\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"false\"}, {_id=\"3\" uid=\"000001\" name=\"超级管理员\" pwd=\"5fa248d86523616ce115d1358312ebb9\" time=\"1594718739785\" timeOut=\"null\" timeMake=\"1593758999492\" phone=\"\" PwdHint=\"\" Grade=\"3\" Abandon=\"true\"}]";
        try {
            strs = strs.replace("=", ":");
            strs = strs.replace(", ", ",");
            strs = strs.replace(" ", ",");
            strs = strs.replace("null", "-1");
            Map map = JSON.parseObject(strs);
            if (userService.updateByKey(map) == 1) {
                return ResponseJSONResult.ok(1);
            } else {
                return ResponseJSONResult.ok(0);
            }
        } catch (Exception e) {
            return ResponseJSONResult.ok("格式错误");
        }
}}