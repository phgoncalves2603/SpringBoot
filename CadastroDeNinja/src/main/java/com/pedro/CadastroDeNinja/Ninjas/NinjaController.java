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
    @PostMapping("/Create")
    public ninjaModel createNinja(@RequestBody ninjaModel newNinja ){ // @RequestBody
        return ninjaService.createNinja(newNinja);
    }


    //search ninja by id (Read)
    @GetMapping("/search/{id}")
    public ninjaModel searchById(@PathVariable Long id){
        return ninjaService.searchById(id);
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
