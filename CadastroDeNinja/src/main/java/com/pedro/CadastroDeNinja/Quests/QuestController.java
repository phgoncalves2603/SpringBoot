package com.pedro.CadastroDeNinja.Quests;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quests/")//localhost:8080/Quests/...
public class QuestController {
    QuestService questService;
    public QuestController( QuestService questService){
        this.questService = questService;
    }
    //add quest
    @PostMapping("create")
    public QuestsModel addQuest(@RequestBody QuestsModel quest){
        return questService.addQuest(quest);
    }

    //edit quest
    @PutMapping("update/{id}")
    public QuestsModel updateQuest(@PathVariable Long id, @RequestBody QuestsModel updatedQuest){
        return questService.updateQuest(id, updatedQuest);
    }

    //search by id
    @GetMapping("search/{id}")
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
