package tests;

import infra.DAO;
import model.Employee;

public class Insert {
    public static void main(String[] args) {
        DAO<Employee> dao = new DAO<>(Employee.class);

        var e = new Employee("Ruan", 1500.0, null);

        dao.openTransaction().insert(e).closeTransaction().close();
    }
}
