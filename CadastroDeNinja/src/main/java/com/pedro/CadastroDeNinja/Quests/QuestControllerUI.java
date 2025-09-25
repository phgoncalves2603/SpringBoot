package com.pedro.CadastroDeNinja.Quests;

import com.pedro.CadastroDeNinja.Ninjas.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/quests/ui/")
public class QuestControllerUI {
QuestService questService;
NinjaService ninjaService;
QuestControllerUI(QuestService questService, NinjaService ninjaService){
    this.questService = questService;
    this.ninjaService = ninjaService;
}


@GetMapping("showAll")
public String showAllQuests(Model model){
    List<QuestsDTO> questsDTO =questService.showAllQuests();
    model.addAttribute("quests",questsDTO);
    return "quests/showAllQuests";

}
@GetMapping("delete/{id}")
public String deleteById(@PathVariable Long id){
    questService.deleteById(id);
    return "redirect:/quests/ui/showAll";
}
@GetMapping("search/{id}")
public String searchQuestById(@PathVariable Long id, Model model){
    QuestsDTO questDTO = questService.searchQuestById(id);
    if (questDTO != null){
        model.addAttribute("quest",questDTO);
        return "quests/questDetails";
    }
    model.addAttribute("message","Quest not Found");
    return "redirect:/quests/ui/showAll";

}
@GetMapping("create")
public String addQuest( Model model){
    model.addAttribute("quest",new QuestsDTO());
    return "quests/addQuest";
}

@PostMapping("save")
public String save(@ModelAttribute QuestsDTO questDTO, RedirectAttributes redirectAttributes){
    questService.addQuest(questDTO);
    redirectAttributes.addFlashAttribute("message","ninja created");
    return "redirect:/quests/ui/showAll";
}
@GetMapping("updateQuest/{id}")
public String updateQuest(@PathVariable long id, Model model){
    QuestsDTO questDTO = questService.searchQuestById(id);
    if (questDTO==null){
        model.addAttribute("message","Quest with ID: "+id+" Not Found");
        return "redirect:/quests/ui/showAll";
    }

    model.addAttribute("quest",questDTO);
    return "quests/updateQuest";
}
@PostMapping("update/{id}")
public String update(@PathVariable long id, @ModelAttribute QuestsDTO questsDTO, RedirectAttributes redirectAttributes){
    questService.updateQuest(id, questsDTO);
    redirectAttributes.addFlashAttribute("message","Ninja Update");
    return "redirect:/quests/ui/showAll";
}






}
