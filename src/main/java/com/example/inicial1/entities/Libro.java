package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libro")
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Libro extends Base {

    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores = new ArrayList<>();

}