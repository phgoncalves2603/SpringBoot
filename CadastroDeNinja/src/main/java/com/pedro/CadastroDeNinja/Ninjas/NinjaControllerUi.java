package com.pedro.CadastroDeNinja.Ninjas;

import com.pedro.CadastroDeNinja.Quests.QuestService;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui/")
public class NinjaControllerUi {

    private final NinjaService ninjaService;
    private final QuestService questService;

    public NinjaControllerUi(NinjaService ninjaService, QuestService questService){
        this.ninjaService = ninjaService;
        this.questService = questService;
    }
    @GetMapping("showAll")
    public String showAll(Model model){
        List<NinjaDTO> ninjas = ninjaService.showAllNinjas();
        model.addAttribute("ninjas",ninjas);
        return "showAllNinjas";
    }

    @GetMapping("delete/{id}")
    public String deleteNinja(@PathVariable Long id){
        ninjaService.deleteNinja(id);
        return "redirect:/ninjas/ui/showAll";

    }

    @GetMapping("search/{id}")
    public String searchById(@PathVariable Long id, Model model){
        NinjaDTO ninja= ninjaService.searchById(id);

        if (ninja!=null){
            model.addAttribute("ninja",ninja);
            return "ninjaDetails";
        }else{
            model.addAttribute("messagem","Ninja not found");
            return "showAllNinjas";
        }
    }
    @GetMapping("create")
    public String createNinja(Model model ){ // @RequestBody
        model.addAttribute("ninja", new NinjaDTO());
        model.addAttribute("quests",questService.showAllQuests());
        return "addNinja";
    }
    @PostMapping("save")
    public String saveNinja(@ModelAttribute NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes){
        ninjaService.createNinja(ninjaDTO);
        redirectAttributes.addFlashAttribute("message","Ninja Created");
        return "redirect:/ninjas/ui/showAll";
    }
    @GetMapping("updateNinja/{id}")
    public String updateNinja(@PathVariable long  id, Model model ){ // @RequestBody
        NinjaDTO ninjaDTO = ninjaService.searchById(id);
        if(ninjaDTO!=null) {
            model.addAttribute("ninja", ninjaDTO);
            model.addAttribute("quests",questService.showAllQuests());
            return "updateNinja";
        }
        model.addAttribute("message", "Ninja with ID " + id + " not found");
        return "showAllNinjas";
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable long id, @ModelAttribute NinjaDTO ninjaDTO, RedirectAttributes redirectAttributes){
        ninjaService.updateNinja(id, ninjaDTO);
        redirectAttributes.addFlashAttribute("message","Ninja Updated");
        return "redirect:/ninjas/ui/showAll";
    }




}
