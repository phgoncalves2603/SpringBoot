package com.pedro.CadastroDeNinja.Quests;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Quests/")//localhost:8080/Quests/...
public class QuestController {
    //add quest
    @PutMapping("Create")
    public String addQuest(){
        return "Quest Added";
    }

    //edit quest
    @PutMapping("UpdateID")
    public String updateQuest(){
        return "Quest updated";
    }

    //search by id
    @GetMapping("SearchID")
    public String searchQuestById(){
        return "Quest found";
    }

    //show all quests
    @GetMapping("showAll")
    public String showAllQuests(){
        return "all Quests";
    }

    //delete
    @DeleteMapping("deleteID")
    public String deleteById(){
        return "Quest deleted";
    }

}
