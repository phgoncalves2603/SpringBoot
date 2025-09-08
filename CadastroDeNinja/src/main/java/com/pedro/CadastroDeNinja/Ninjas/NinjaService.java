package com.pedro.CadastroDeNinja.Ninjas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    //@Autowired same as initialize a constructor
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    //show all ninjas
    public List<ninjaModel> showAllNinjas(){
       return ninjaRepository.findAll();
    }
    //show ninja by id
    public ninjaModel searchById(Long id){
        Optional<ninjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }
    //create a new ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO ){
        ninjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }
    //delete a ninja -> need to be void, deleteById dont return anything
    public void deleteNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    //update ninja
    public ninjaModel updateNinja(Long id, ninjaModel updatedNinja){
        if (ninjaRepository.existsById(id)){
            updatedNinja.setId(id);
            return ninjaRepository.save(updatedNinja);
        }
        return null;
    }




}
