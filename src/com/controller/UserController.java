package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/insert")
    public String insert(Model model,
                         @RequestParam(value = "username", required = false) String username,
                         @RequestParam(value = "userpassword", required = false) String userpassword,
                         @RequestParam(value = "usermessage", required = false) String usermessage,
                         HttpServletRequest request,
                         HttpSession session) throws Exception {
        User u = new User();
        u.setUsername(username);
        u.setUserpassword(userpassword);
        u.setUsermessage(usermessage);
        userService.insertUser(u);
        return "success";
    }

    @RequestMapping(value = "/check")
    public  String check (Model model,
                          @RequestParam(value = "searchtext",required = false) String searchtext,
                          HttpServletRequest request) throws  Exception {
        System.out.println(searchtext +"?");

        List<User> users =userService.checkUser(searchtext);
        System.out.println(users);
        model.addAttribute("users",users);
        return "index";
    }

    @RequestMapping(value = "/reqJson")
     public  @ResponseBody String   reqJson(@RequestBody String u){

        System.out.println("SUccees Here"+u);
        return  u;
     }

// User u  内的字段名相同的 依次有值
//    @RequestMapping(value = "/reqJson")
//    public  @ResponseBody User   reqJson(@RequestBody User u){
//
//        System.out.println("SUccees Here"+u);
//        return  u;
//    }

    @RequestMapping(value = "/responseJson")
    public  @ResponseBody User   responseJson( User u){

        System.out.println("SUccees Here2"+u);
        return  u;
    }

//    servlet 方式
    @RequestMapping(value = "/checkUserName",method = RequestMethod.POST ,produces = "application/json; charset=utf-8")
    public  void  checkUserName( @RequestBody String  u , HttpServletResponse response,HttpServletRequest request) throws  Exception
    {

        System.out.println(u+"..........");

        JSONObject jsonObject = JSONObject.fromObject(u);
        System.out.println(jsonObject.get("username"));
        Map<String,String> map = new HashMap<>();
        map.put("info","123");
        //       response.setCharacterEncoding("utf-8"); 解决中文jsp乱码问题
//        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        System.out.println(JSON.toJSON(map));
        printWriter.print(JSON.toJSON(map));
        printWriter.flush();
        printWriter.close();

    }




}
