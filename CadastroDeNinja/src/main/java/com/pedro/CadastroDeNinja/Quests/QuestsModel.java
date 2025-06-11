package com.pedro.CadastroDeNinja.Quests;

import jakarta.persistence.*;

@Entity
@Table(name="TB_Quests")
public class QuestsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String rank;

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
