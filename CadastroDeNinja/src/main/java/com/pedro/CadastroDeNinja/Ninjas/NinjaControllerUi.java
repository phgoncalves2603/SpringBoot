package com.pedro.CadastroDeNinja.Ninjas;

import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui/")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }
    @GetMapping("showAll")
    public String showAll(Model model){
        List<NinjaDTO> ninjas = ninjaService.showAllNinjas();
        model.addAttribute("ninjas",ninjas);
        return "showAllNinjas";
    }

    @GetMapping("delete/{id}")
    public String deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
        return "redirect:/ninjas/ui/showAll";

    }

    @GetMapping("search/{id}")
    public String searchById(@PathVariable Long id, Model model){
        NinjaDTO ninja= ninjaService.searchById(id);

        if (ninja!=null){
            model.addAttribute("ninja",ninja);
            return "ninjaDetails";
        }else{
            model.addAttribute("mensagem","Ninja not found");
            return "showAllNinjas";
        }
    }



}
