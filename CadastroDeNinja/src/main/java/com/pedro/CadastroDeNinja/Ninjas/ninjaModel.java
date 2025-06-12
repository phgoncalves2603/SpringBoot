package com.pedro.CadastroDeNinja.Ninjas;

import com.pedro.CadastroDeNinja.Quests.QuestsModel;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_Ninja_Registry")
public class ninjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private int age;

    @ManyToOne //many quests to 1 ninja
    @JoinColumn(name = "quests_id")// Foreign Key
    private QuestsModel quests;

    public ninjaModel() {
    }
    public ninjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
