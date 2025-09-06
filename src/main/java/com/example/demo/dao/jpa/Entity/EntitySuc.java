package com.example.demo.dao.jpa.Entity;

import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sucursal")
public class EntitySuc {

    @Id
    @UuidGenerator
    private String id;

    private String name;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Entityciudad ciudad; // <-- objeto completo
}
