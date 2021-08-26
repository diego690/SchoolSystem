/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author capur
 */
@Controller
public class NewController {
    
    @RequestMapping("/url")
    public String page() {
        
        return "index1";
    }
    
    @GetMapping("/Admin/home")
    public String home(){
        return "home";
    }
    
    @GetMapping("/logout")
    public String logout(){
        return "index1";
    }
}
