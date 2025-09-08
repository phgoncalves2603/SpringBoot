package com.pedro.CadastroDeNinja.Quests;

import org.springframework.stereotype.Component;

@Component
public class QuestsMapper {
    public  QuestsDTO map(QuestsModel questsModel){
        QuestsDTO questsDTO = new QuestsDTO();
        questsDTO.setId(questsModel.getId());
        questsDTO.setDescription(questsModel.getDescription());
        questsDTO.setRank(questsModel.getRank());
        questsDTO.setNinjas(questsModel.getNinjas());
        return questsDTO;
    }

    public  QuestsModel map(QuestsDTO questsDTO){
        QuestsModel questsModel = new QuestsModel();
        questsModel.setId(questsDTO.getId());
        questsModel.setDescription(questsDTO.getDescription());
        questsModel.setRank(questsDTO.getRank());
        questsModel.setNinjas(questsDTO.getNinjas());
        return questsModel;
    }

}
