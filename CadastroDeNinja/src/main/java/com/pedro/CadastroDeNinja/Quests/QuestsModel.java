package com.pedro.CadastroDeNinja.Quests;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private Long id;
    @Column(name = "Quest_Description")
    private String description;
    @Column(name = "Quest_Rank")
    private String rank;
    @OneToMany(mappedBy = "quests") //need to map with the same name of the column in other table
    //one quest to many ninjas
    @JsonIgnore//serialization loop
    private List<ninjaModel> ninjas;

}
