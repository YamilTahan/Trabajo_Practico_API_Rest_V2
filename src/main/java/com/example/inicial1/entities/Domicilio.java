package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="domicilio")
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Domicilio extends Base {

    private String calle;
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
    private  Localidad localidad;
}