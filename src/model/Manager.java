package model;

import java.util.ArrayList;
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

    public Manager() {

    }
    
    public Manager(String name, Double salary, ArrayList arr) { 
        super(name, salary, null);
        this.employees = arr == null ? new ArrayList<>() : arr;
        updateBonus();
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
        this.employees.forEach(e -> e.setManager(this));
        updateBonus();
    }

    public Double getBonus() {
        return this.bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        e.setManager(this);
        updateBonus();
    }

    public void addEmployees(List<Employee> arr) {
        employees.addAll(arr);
        arr.forEach(e ->  e.setManager(this));
        updateBonus();
    }

    public void removeEmployee(Employee e) {
        employees.remove(e);
        updateBonus();
    }

    public void updateBonus() {
        if (employees == null) {
            System.out.println("000000Updating bonus for manager: " + this.name);
            setBonus(0.0);
        } else {
            System.out.println("111111Updating bonus for manager: " + this.name);
            setBonus(employees.size() * 0.1);
        }
    }

    @Override
    public Double getSalary() {
        return salary + (salary * bonus);
    }
}
