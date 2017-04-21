package com.bds.cp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vivek Tripathi on 17/02/17.
 */

@Controller
@RequestMapping("/index")
public class CPController{

    @RequestMapping(method = RequestMethod.GET)
    public String indexClass(ModelMap modelMap){
        modelMap.addAttribute("message","This is the server saying hello from host.");
        return "main";
    }
}
