package com.pedro.CadastroDeNinja.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas/")
public class NinjaController {


    private NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }


    @GetMapping("welcome")
    public String welcome(){
        return "Welcome to Cadastro de Ninja!";
    }
    //add ninja (Create)
    @PostMapping("Create")
    public NinjaDTO createNinja(@RequestBody NinjaDTO newNinja ){ // @RequestBody
        return ninjaService.createNinja(newNinja);
    }


    //search ninja by id (Read)
    @GetMapping("search/{id}")
    public NinjaDTO searchById(@PathVariable Long id){
        return ninjaService.searchById(id);
    }


    //change ninja data (Update)
    @PutMapping("update/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO updatedNinja){
        return ninjaService.updateNinja(id, updatedNinja);
    }
    //show all (Read)
    @GetMapping("showAll")
    public List<NinjaDTO> showAll(){
        return ninjaService.showAllNinjas();
    }

    //delete ninja (Deleted)
    @DeleteMapping("delete/{id}")
    public void deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }
}
