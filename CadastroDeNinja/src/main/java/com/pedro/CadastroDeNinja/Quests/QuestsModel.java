package com.pedro.CadastroDeNinja.Quests;

import com.pedro.CadastroDeNinja.Ninjas.ninjaModel;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="TB_Quests")
public class QuestsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String rank;
    @OneToMany(mappedBy = "quests") //need to map with the same name of the column in other table
    //one quest to many ninjas
    private List<ninjaModel> ninjas;

    public QuestsModel() {
    }

    public QuestsModel(String description, String rank) {
        this.description = description;
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


}
