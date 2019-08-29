package com.wangzk.im.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: IndexController
 * @ProjectName: im
 * @PackageName: com.wangzk.im.controller
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 10:32
 */
@Log4j2
@Controller
public class IndexController {

    @RequestMapping("/websocket/{name}")
    public ModelAndView webSocket(@PathVariable String name){
        try{
            log.info("跳转到websocket的页面上");
            ModelAndView model = new ModelAndView("socket");
            model.addObject("username",name);
            return model;
        }
        catch (Exception e){
            log.info("跳转到websocket的页面上发生异常，异常信息是："+e.getMessage());
            return null;
        }
    }

}
