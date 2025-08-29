package com.pedro.CadastroDeNinja.Quests;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quests/")//localhost:8080/Quests/...
public class QuestController {
    QuestService questService;
    public QuestController( QuestService questService){
        this.questService = questService;
    }
    //add quest
    @PostMapping("Create")
    public QuestsModel addQuest(@RequestBody QuestsModel quest){
        return questService.addQuest(quest);
    }

    //edit quest
    @PutMapping("UpdateID")
    public String updateQuest(){
        return "Quest updated";
    }

    //search by id
    @GetMapping("Search/{id}")
    public QuestsModel searchQuestById(@PathVariable Long id){
        return questService.searchQuestById(id);
    }

    //show all quests
    @GetMapping("showAll")
    public List<QuestsModel> showAllQuests(){
        return questService.showAllQuests();
    }

    //delete
    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable Long id){
        questService.deleteById(id);
        return "Quest deleted";
    }

}
