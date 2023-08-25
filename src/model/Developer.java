package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import model.enums.Level;

@Entity
@PrimaryKeyJoinColumn(name = "ID_FUNCIONARIO")
@Table(name = "DESENVOLVEDORES", schema = "desafio-jpa")
public class Developer extends Employee {
    
    @Id
    private int id;

    @Column(name = "NIVEL")
    @Enumerated(EnumType.STRING)
    private Level level;
}