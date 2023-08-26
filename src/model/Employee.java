package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CARGO", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Funcionario")
@Table(name = "FUNCIONARIOS", schema = "desafio-jpa")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected int id;

    @Column(name = "NOME", nullable = false)
    protected String name;

    @Column(name = "SALARIO")
    protected Double salary;

    @ManyToOne
    @JoinColumn(name = "ID_GERENTE") // Column name in the FUNCIONARIOS table 
    protected Manager manager; // Name of the attribute in your class

    public Employee() { }

    public Employee(String name, Double salary, Manager manager) {
        this.name = name;
        this.salary = salary;
        this.manager = manager;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
