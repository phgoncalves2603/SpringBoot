package com.pedro.CadastroDeNinja.Ninjas;

import org.springframework.stereotype.Component;

//This class will map the the ninjaModel entity with the DTO
@Component
public class NinjaMapper {
    public ninjaModel map(NinjaDTO ninjaDTO){ //dto to entity
        ninjaModel ninjaModel = new ninjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setRank((ninjaDTO.getRank()));
        ninjaModel.setQuests(ninjaDTO.getQuests());


        return ninjaModel;

    }
    public NinjaDTO map (ninjaModel ninjaModel){//entity to dto
        NinjaDTO ninjaDTO = new NinjaDTO();


        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setQuests(ninjaModel.getQuests());

        return ninjaDTO;

    }
}
