package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "ID_FUNCIONARIO")
@Table(name = "GERENTES")
public class Manager extends Employee {
    
    @Id
    @Column(name = "ID")
    private int id;

    @OneToMany(mappedBy = "manager") // Indicando que ja esta mapeado na classe employee ( Manager manager )
    private List<Employee> employees;

    private Double bonus;

    public Manager() { }

    public Manager(List<Employee> employees, Double bonus) {
        this.employees = employees;
        this.bonus = bonus;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Double getBonus() {
        return this.bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        updateBonus();
    }

    public void removeEmployee(Employee e) {
        employees.remove(e);
        updateBonus();
    }

    public void updateBonus() {
        setBonus(bonus *= (employees.size() * 0.1));
    }

    @Override
    public Double getSalary() {
        return salary = salary + (salary * bonus);
    }
}
