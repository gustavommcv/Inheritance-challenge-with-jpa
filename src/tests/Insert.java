package tests;

import infra.DAO;
import model.Developer;
import model.Employee;
import model.enums.Level;

public class Insert {
    public static void main(String[] args) {
        DAO<Employee> dao = new DAO<>(Employee.class);

        var e = new Developer("Monnerat", 15400.0, Level.SENIOR);

        dao.openTransaction().insert(e).closeTransaction().close();
    }
}
