package br.com.api.todo.list.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "list")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "O campo 'Matéria' deve estar preenchido")
    @Size(min = 2, max = 50, message = "O campo 'matéria' deve ter entre 2 e 50 caracteres")
    @Column(name = "materia", length = 50, nullable = false)
    private String materia;

    @NotBlank(message = "O campo 'Tarefa' deve estar preenchido")
    @Size(min = 2, max = 50, message = "O campo 'Tarefa' deve ter entre 2 e 50 caractéres")
    @Column(name = "tarefa", length = 50, nullable = false)
    private String tarefa;

    @NotNull(message = "O campo 'Data de Entrega' deve estar preenchido")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "GMT")
    @Column(name = "dtEntrega", nullable = false)
    private Date dtEntrega;

    @Column(name = "status")
    private boolean status;
}
