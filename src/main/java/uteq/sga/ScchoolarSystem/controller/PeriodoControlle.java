/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.ScchoolarSystem.Entity.Periodo;
import uteq.sga.ScchoolarSystem.Services.IPeriodoService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Periodo")
public class PeriodoControlle {
    
    @Autowired
    private IPeriodoService periodoserv;
    
    @RequestMapping("/listPeriodo")
    public String page(Model model) {
        List<Periodo> period= periodoserv.listarTodos();
        model.addAttribute("Titulo", "Listado de Periodos Academicos");
        model.addAttribute("periodos", period);
        return "/Admin/periodolist";
    }
    
}
