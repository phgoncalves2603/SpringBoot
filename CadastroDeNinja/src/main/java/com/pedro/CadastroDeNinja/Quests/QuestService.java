package com.pedro.CadastroDeNinja.Quests;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestService {
    private QuestsRepository questsRepository;
    private QuestsMapper questsMapper;
    public QuestService(QuestsRepository questsRepository, QuestsMapper questsMapper){
        this.questsRepository = questsRepository;
        this.questsMapper = questsMapper;
    }
    //Create
    public QuestsDTO addQuest(QuestsDTO questsDTO){
        QuestsModel questsModel = questsMapper.map(questsDTO);
        questsModel = questsRepository.save(questsModel);
        return questsMapper.map(questsModel);
    }

    //search by id
    public QuestsDTO searchQuestById(Long id){
        Optional<QuestsModel> quest = questsRepository.findById(id);

        return quest.map(questsMapper::map).orElse(null);
    }

    //show all quests
    public List<QuestsDTO> showAllQuests(){
        List<QuestsModel> questsModel = questsRepository.findAll();
        return questsModel.stream()
                .map(questsMapper::map) // same as (q -> questMaper.map(q))
                .collect(Collectors.toList());

    }

    //delete
    public void deleteById(Long id){
        questsRepository.deleteById(id);
    }
    //update quest
    public QuestsDTO updateQuest(Long id, QuestsDTO updatedQuest){
        Optional<QuestsModel> quest = questsRepository.findById(id);
        if (quest.isPresent()){
            QuestsModel newQuest = questsMapper.map(updatedQuest);
            newQuest.setId(id);
            questsRepository.save(newQuest);
            return questsMapper.map(newQuest);
        }
        return null;
    }



}
