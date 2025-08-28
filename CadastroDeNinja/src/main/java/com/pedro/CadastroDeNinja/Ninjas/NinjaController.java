package com.pedro.CadastroDeNinja.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {


    private NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }


    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Cadastro de Ninja!";
    }
    //add ninja (Create)
    @GetMapping("/Create")
    public String create(){
        return "Ninja Created";
    }


    //search ninja by id (Read)
    @GetMapping("/searchID")
    public String search(){
        return "Ninja Created";
    }


    //change ninja data (Update)
    @PutMapping("/updateID")
    public String update(){
        return "Ninja Created";
    }
    //show all (Read)
    @GetMapping("/showAll")
    public List<ninjaModel> showAll(){
        return ninjaService.showAllNinjas();
    }

    //delete ninja (Deleted)
    @DeleteMapping("/deleteID")
    public String delete(){
        return "Ninja Created";
    }
}
