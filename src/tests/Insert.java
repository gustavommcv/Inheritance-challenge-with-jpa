package tests;

import infra.DAO;
import model.Employee;
import model.Manager;

public class Insert {
    public static void main(String[] args) {
        DAO<Employee> dao = new DAO<>(Employee.class);

        var e = new Manager("AAA", 15400.0, null);

        dao.openTransaction().insert(e).closeTransaction().close();
    }
}
