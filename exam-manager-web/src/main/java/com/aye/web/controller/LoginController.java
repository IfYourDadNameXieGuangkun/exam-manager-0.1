package com.aye.web.controller;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author Aye
 * @Description:
 * @Date: Created in 21:58 2019/4/18
 * @Version: V1.0
 */
@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    @PostMapping(value = "/user/login")
    public String login (@RequestParam("username")String username,
                         @RequestParam("password")String password,
                         Map<String,Object> map,
                         HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            logger.info("这是我的日志框架");

            //登录成功防止重复提交 重定向页面
            return "redirect:/main.html";
        }else {
            map.put("msg","登录失败!");
            return "login";
        }
    }
}
