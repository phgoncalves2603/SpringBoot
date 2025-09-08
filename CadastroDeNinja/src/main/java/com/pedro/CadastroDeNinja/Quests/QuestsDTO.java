package com.pedro.CadastroDeNinja.Quests;
import com.pedro.CadastroDeNinja.Ninjas.ninjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestsDTO {
    private Long id;
    private String description;
    private String rank;
    private List<ninjaModel> ninjas;
}
