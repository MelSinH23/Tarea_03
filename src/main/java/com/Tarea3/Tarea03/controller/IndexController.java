package com.Tarea3.Tarea03.controller;

import com.Tarea3.Service.PaisService;
import com.Tarea3.dao.PaisDao;
import com.Tarea3.domain.Pais;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/")
    public String inicio(Model model) {
       // log.info("Ahora se usa arquitectura MVC");

        var paises = paisService.getPaises();/////////////////////////////////23
        
        model.addAttribute("paises", paises);

        return "index";
    }

    @GetMapping("/nuevoPais")
    public String nuevoPais(Pais pais) {
        return "modificarPais";
    }

    @PostMapping("/guardarPais")
    public String guardarPais(Pais pais) {
        paisService.save(pais);
        return "redirect:/";
    }

    @GetMapping("/modificarPais/{idPais}")
    public String modificarPais(Pais pais, Model model) {
        pais = paisService.getPais(pais);
        model.addAttribute("pais", pais);
        return "modificarPais";
    }

    @GetMapping("/eliminarPais/{idPais}")
    public String eliminarPais(Pais pais) {
        paisService.delete(pais);
        return "redirect:/";
    }
}
