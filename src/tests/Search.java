package tests;

import java.sql.SQLException;

import infra.DAO;
import model.Employee;

public class Search {
    public static void main(String[] args) throws SQLException {
        DAO<Employee> dao = new DAO<Employee>(Employee.class);
        
        System.out.println(dao.openTransaction().searchById(4).getSalary());
        
        dao.closeTransaction().close();
    }
}
