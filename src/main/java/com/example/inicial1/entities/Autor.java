package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Autor extends Base {

    private String nombre;
    private String apellido;
    @Column(length = 1500)
    private String biografia;

}