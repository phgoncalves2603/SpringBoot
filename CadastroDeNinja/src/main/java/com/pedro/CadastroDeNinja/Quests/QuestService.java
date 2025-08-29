package com.pedro.CadastroDeNinja.Quests;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestService {
    private QuestsRepository questsRepository;

    public QuestService(QuestsRepository questsRepository){
        this.questsRepository = questsRepository;
    }
    //Create
    public QuestsModel addQuest(QuestsModel questsModel){
        return questsRepository.save(questsModel);
    }

    //search by id
    public QuestsModel searchQuestById(Long id){
        Optional<QuestsModel> quest = questsRepository.findById(id);
        return quest.orElse(null);
    }

    //show all quests
    public List<QuestsModel> showAllQuests(){
        return questsRepository.findAll();
    }

    //delete
    public void deleteById(Long id){
        questsRepository.deleteById(id);
    }
    //update quest
    public QuestsModel updateQuest(Long id, QuestsModel updatedQuest){
        if (questsRepository.existsById(id)){
            updatedQuest.setId(id);
            return questsRepository.save(updatedQuest);
        }
        return null;
    }



}
