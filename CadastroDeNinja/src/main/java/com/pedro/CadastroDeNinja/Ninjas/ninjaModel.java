package com.pedro.CadastroDeNinja.Ninjas;

import com.pedro.CadastroDeNinja.Quests.QuestsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_Ninja_Registry")
// Use lombok to reduce writing constructor and getters and setters
@NoArgsConstructor // Create a default constructor
@AllArgsConstructor // Create an overload constructor
@Data // Create all getters and setters
public class ninjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(unique = true) // Make column value unique
    private String email;
    private int age;

    @ManyToOne //many quests to 1 ninja
    @JoinColumn(name = "quests_id")// Foreign Key
    private QuestsModel quests;


}
