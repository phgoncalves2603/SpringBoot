package com.pedro.CadastroDeNinja.Quests;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quests/")//localhost:8080/Quests/...
public class QuestController {
    QuestService questService;

    public QuestController( QuestService questService ){
        this.questService = questService;

    }
    //add quest
    @PostMapping("create")
    @Operation(
            summary = "Create a new Quest",
            description = "Creates a new quest with the provided details and returns a confirmation message.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Quest successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            }
    )
    public QuestsDTO addQuest(@RequestBody QuestsDTO quest){
        return questService.addQuest(quest);
    }

    //edit quest
    @PutMapping("update/{id}")
    @Operation(
            summary = "Update an existing Quest",
            description = "Updates the information of an existing quest using its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Quest successfully updated"),
                    @ApiResponse(responseCode = "404", description = "Quest not found"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            }
    )
    public QuestsDTO updateQuest(@PathVariable Long id, @RequestBody QuestsDTO updatedQuest){
        return questService.updateQuest(id, updatedQuest);
    }

    //search by id
    @GetMapping("search/{id}")
    @Operation(
            summary = "Search Quest by ID",
            description = "Retrieves a quest’s details using its unique ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Quest found"),
                    @ApiResponse(responseCode = "404", description = "Quest not found")
            }
    )
    public QuestsDTO searchQuestById(@PathVariable Long id){
        return questService.searchQuestById(id);
    }

    //show all quests
    @GetMapping("showAll")
    @Operation(
            summary = "Retrieve all Quests",
            description = "Returns a list of all quests currently stored.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of quests retrieved successfully")
            }
    )
    public List<QuestsDTO> showAllQuests(){
        return questService.showAllQuests();
    }

    //delete
    @DeleteMapping("delete/{id}")
    @Operation(
            summary = "Delete a Quest by ID",
            description = "Deletes the quest with the specified ID from the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Quest successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "Quest not found")
            }
    )
    public String deleteById(@PathVariable Long id){
        questService.deleteById(id);
        return "Quest deleted";
    }

}
