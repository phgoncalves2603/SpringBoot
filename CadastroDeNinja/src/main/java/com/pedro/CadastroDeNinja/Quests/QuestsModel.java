package com.pedro.CadastroDeNinja.Quests;

import com.pedro.CadastroDeNinja.Ninjas.ninjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="TB_Quests")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String rank;
    @OneToMany(mappedBy = "quests") //need to map with the same name of the column in other table
    //one quest to many ninjas
    private List<ninjaModel> ninjas;

}
