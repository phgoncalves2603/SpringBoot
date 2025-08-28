package com.pedro.CadastroDeNinja.Ninjas;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    //@Autowired same as initialize a constructor
    private NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }
    //show all ninjas
    public List<ninjaModel> showAllNinjas(){
       return ninjaRepository.findAll();
    }
    public ninjaModel searchById(Long id){
        Optional<ninjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }




}
