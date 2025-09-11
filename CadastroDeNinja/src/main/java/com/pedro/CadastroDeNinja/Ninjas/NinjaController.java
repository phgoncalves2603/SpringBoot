package com.pedro.CadastroDeNinja.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO newNinja ){ // @RequestBody
        NinjaDTO ninjaDTO =  ninjaService.createNinja(newNinja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Successfully created: "+ newNinja.getName()+" (ID): "+newNinja.getId());

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
    public ResponseEntity<String> deleteNinja(@PathVariable Long id){
        if (ninjaService.searchById(id)!=null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja Successfully deleted (ID): " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja (ID): "+id+" not found");

    }
}
