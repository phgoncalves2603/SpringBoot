package com.pedro.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
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
    public String showAll(){
        return "Ninja Created";
    }

    //delete ninja (Deleted)
    @DeleteMapping("/deleteID")
    public String delete(){
        return "Ninja Created";
    }
}
