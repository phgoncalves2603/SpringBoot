package com.pedro.CadastroDeNinja.Ninjas;

import com.pedro.CadastroDeNinja.Quests.QuestsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private long id;
    private String name;
    private String email;
    private int age;
    private String rank;
    private QuestsModel quests;
}
