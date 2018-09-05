package com.inca.editor.controller;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inca.editor.ActionEnter;
 
/**
 * Created by ldb on 2017/4/9.
 */
@Controller
public class UEditorController {
 
 
    @RequestMapping("/")
    private String showPage(){
        return "index";
    }
    
    @RequestMapping(value="/static")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            String exec = new ActionEnter(request).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @RequestMapping("/save")
	private String save(String content) {
		System.out.println("content=" + content);
		return "index";
	}

 
}
