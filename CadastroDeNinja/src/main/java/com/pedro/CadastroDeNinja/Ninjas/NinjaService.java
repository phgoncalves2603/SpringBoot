package com.pedro.CadastroDeNinja.Ninjas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> showAllNinjas(){
        List<ninjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }
    //show ninja by id
    public NinjaDTO searchById(Long id){
        Optional<ninjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO updateNinja(Long id, NinjaDTO updatedNinja){
       Optional<ninjaModel> ninja = ninjaRepository.findById(id);
       if (ninja.isPresent()){
           ninjaModel newNinja = ninjaMapper.map(updatedNinja);
           newNinja.setId(id);
           ninjaRepository.save(newNinja);
           return ninjaMapper.map(newNinja);
       }
       return null;
    }




}
