package com.pedro.CadastroDeNinja.Quests;

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
    public QuestsDTO addQuest(@RequestBody QuestsDTO quest){
        return questService.addQuest(quest);
    }

    //edit quest
    @PutMapping("update/{id}")
    public QuestsDTO updateQuest(@PathVariable Long id, @RequestBody QuestsDTO updatedQuest){
        return questService.updateQuest(id, updatedQuest);
    }

    //search by id
    @GetMapping("search/{id}")
    public QuestsDTO searchQuestById(@PathVariable Long id){
        return questService.searchQuestById(id);
    }

    //show all quests
    @GetMapping("showAll")
    public List<QuestsDTO> showAllQuests(){
        return questService.showAllQuests();
    }

    //delete
    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable Long id){
        questService.deleteById(id);
        return "Quest deleted";
    }

}
