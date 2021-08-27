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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uteq.sga.ScchoolarSystem.Entity.Actividad;
import uteq.sga.ScchoolarSystem.Entity.Tipousuario;
import uteq.sga.ScchoolarSystem.Entity.Usuario;
import uteq.sga.ScchoolarSystem.Services.ActividadService;
import uteq.sga.ScchoolarSystem.Services.ITipoUsuarioService;
import uteq.sga.ScchoolarSystem.Services.IUsuarioService;

/**
 *
 * @author capur
 */
@Controller
@RequestMapping("/Admin")
public class ActividadController {
    
    @Autowired
    private ActividadService activiSer;
    
    @Autowired
    private IUsuarioService userServ;
    
    @RequestMapping("/listaActividad")
    public String page(Model model) {
        List<Actividad> listaActividad = activiSer.listarTodos();
        model.addAttribute("actividades", "Listado de Actividades");
        model.addAttribute("actividad", listaActividad);
        return "/Admin/Actividades";
    }
    
    @GetMapping("/Create")
    public String crear(Model model){
        model.addAttribute("Create", "Crear Actividad");
        return "/Admin/ActividadAdd";
    }
    
    @GetMapping("/listusuarios")
    public String listusuario(Model model){
        List<Usuario> usuario = userServ.listarTodos();
        model.addAttribute("usuarios", "Lista de Usuarios");
        model.addAttribute("users", usuario);
        return "/Admin/Usuarios";
    }
    
    @Autowired
    private ITipoUsuarioService tipouser;
    
    @GetMapping("/createUsuario")
    public String crearUser(Model model){
        Usuario user = new Usuario();
        
        List<Tipousuario> tpus= tipouser.listarTodos();
        model.addAttribute("Titulo", "Nuevo Usuario");
        model.addAttribute("usuario", user);
        model.addAttribute("tipouser", tpus);
        
        return "/Admin/AddUsuario";
    }
    
    @PostMapping("/addTipoUser")
    public String guardaUsuario(@ModelAttribute Usuario user){
        userServ.guardar(user);
        System.out.println("usuario guardado con exito");
        return "redirect:/Admin/listusuarios";
    }
     @GetMapping("/editUsuario/{id}")
    public String EditarUser(@PathVariable("id") Integer iduser, Model model){
    
        Usuario tuser = userServ.buscaById(iduser);
        
        List<Tipousuario> listipoUser = tipouser.listarTodos();
        
        model.addAttribute("Titulo", "Editar Tipo de Usuario");
        model.addAttribute("tipouser", listipoUser);
        model.addAttribute("usuario", tuser);
       
        
        return "/Admin/AddUsuario";
    }
     @GetMapping("/deleteUsuario/{id}")
    public String deleteUser(@PathVariable("id") Short idtipou, Model model){
    tipouser.eliminar(idtipou);
       return "redirect:/Admin/listusuarios";
    }
    
    
    
    
    
    
    
    @GetMapping("/listatipousuario")
    public String listatipousuario(Model model){
        List<Tipousuario> tpus= tipouser.listarTodos();
        model.addAttribute("tusuarios", "Lista de Tipos de Usuarios");
        model.addAttribute("tipousuarios", tpus);
        return "/Admin/tipousuariolistar";
    }
    
     @GetMapping("/createTipoUsuario")
    public String crearTipoUser(Model model){
        Tipousuario tuser = new Tipousuario();
     model.addAttribute("Titulo", "Nuevo Tipo de Usuario");
        model.addAttribute("tusuario", tuser);
     return "/Admin/addtipoUser";
    }
    
    @PostMapping("/addtipousuario")
    public String addtipouser(@ModelAttribute Tipousuario tpuser){
        tipouser.guardar(tpuser);
        System.out.println("Guardado Exitosamente");
        return "redirect:/Admin/listatipousuario";
    }
    
     @GetMapping("/editTipoUsuario/{id}")
    public String EditarTipoUser(@PathVariable("id") Short idtipou, Model model){
    
        Tipousuario tuser = tipouser.buscaById(idtipou);
        
        List<Tipousuario> listipoUser = tipouser.listarTodos();
        
        model.addAttribute("Titulo", "Editar Tipo de Usuario");
        model.addAttribute("listatipo", listipoUser);
        model.addAttribute("tusuario", tuser);
       
        
        return "/Admin/addtipoUser";
    }
    
     @GetMapping("/deleteTipoUsuario/{id}")
    public String deleteTipoUser(@PathVariable("id") Short idtipou, Model model){
    tipouser.eliminar(idtipou);
       return "redirect:/Admin/listatipousuario";
    }
}
