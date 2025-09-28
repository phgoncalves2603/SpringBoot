package com.pedro.CadastroDeNinja.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas/")
public class NinjaController {


    private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }



    //add ninja (Create)
    @PostMapping("create")
    @Operation(
            summary = "Create a new Ninja",
            description = "Creates a new Ninja with the provided details and returns a confirmation message.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Ninja successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            }
    )
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO newNinja ){ // @RequestBody
        NinjaDTO ninjaDTO =  ninjaService.createNinja(newNinja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Successfully created: "+ newNinja.getName()+" (ID): "+newNinja.getId());

    }


    //search ninja by id (Read)
    @GetMapping("search/{id}")
    @Operation(
            summary = "Search Ninja by ID",
            description = "Retrieves a Ninja’s details using their unique ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ninja found"),
                    @ApiResponse(responseCode = "404", description = "Ninja not found")
            }
    )
    public ResponseEntity<?> searchById(@PathVariable Long id){
        NinjaDTO ninjaDTO = ninjaService.searchById(id);

        if (ninjaDTO!=null){
            return ResponseEntity.ok(ninjaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja (ID): "+id+" Not found");
        }
    }


    //change ninja data (Update)
    @PutMapping("update/{id}")
    @Operation(
            summary = "Update an existing Ninja",
            description = "Updates the information of an existing Ninja using their ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ninja successfully updated"),
                    @ApiResponse(responseCode = "404", description = "Ninja not found"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            }
    )
    public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO updatedNinja){
        if(ninjaService.searchById(id)!=null){
           NinjaDTO ninjaDTO =  ninjaService.updateNinja(id, updatedNinja);
           return ResponseEntity.ok(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja (ID): "+updatedNinja.getId()+" Not Found");
    }
    //show all (Read)
    @GetMapping("showAll")
    @Operation(
            summary = "Retrieve all Ninjas",
            description = "Returns a list of all Ninjas currently stored.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of Ninjas retrieved successfully")
            }
    )
    public ResponseEntity<List<NinjaDTO>> showAll(){
        List<NinjaDTO> ninjaDTOList = ninjaService.showAllNinjas();
        return ResponseEntity.ok(ninjaDTOList);
    }

    //delete ninja (Deleted)
    @DeleteMapping("delete/{id}")
    @Operation(
            summary = "Delete a Ninja by ID",
            description = "Deletes the Ninja with the specified ID from the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ninja successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "Ninja not found")
            }
    )
    public ResponseEntity<String> deleteNinja(@PathVariable Long id){
        if (ninjaService.searchById(id)!=null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja Successfully deleted (ID): " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja (ID): "+id+" not found");

    }
}
