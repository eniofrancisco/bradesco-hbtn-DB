package entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private Integer idade;
    private String cpf;
    private LocalDate dataNascimento;

    // Getters e setters
}
