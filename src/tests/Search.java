package tests;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Employee;

public class Search {
    public static void main(String[] args) throws SQLException {
        // DAO<Employee> dao = new DAO<>(Employee.class);
        // dao.openTransaction().searchById(1);
        // dao.closeTransaction().close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("inheritanceWithJpa");
        
        EntityManager em = emf.createEntityManager();

        System.out.println(em.find(Employee.class, 1).getName());
    }
}
