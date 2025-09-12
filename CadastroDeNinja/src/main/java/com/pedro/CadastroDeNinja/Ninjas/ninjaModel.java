package com.pedro.CadastroDeNinja.Ninjas;

import com.pedro.CadastroDeNinja.Quests.QuestsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TB_Ninja_Registry")
// Use lombok to reduce writing constructor and getters and setters
@NoArgsConstructor // Create a default constructor
@AllArgsConstructor // Create an overload constructor
@Data // Create all getters and setters
@ToString(exclude = "quests")
public class ninjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name ="Ninja_Name")
    private String name;
    @Column(unique = true, name = "Email") // Make column value unique
    private String email;
    @Column(name = "Age")
    private int age;
    @Column(name = "Rank")
    private String rank;
    @ManyToOne //many quests to 1 ninja
    @JoinColumn(name = "quests_id")// Foreign Key
    private QuestsModel quests;


}
