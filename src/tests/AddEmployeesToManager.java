package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import infra.DAO;
import model.Employee;
import model.Manager;

public class AddEmployeesToManager {
    public static void main(String[] args) {
        DAO<Employee> daoEmployee = new DAO<>(Employee.class);
        Scanner scan = new Scanner(System.in);

        // Adding employees to a list that will be attached to a manager
        daoEmployee.openTransaction();

        List<Employee> employees = new ArrayList<>();

        var exit = false;

        while(!exit) {
            System.out.print("Type the employee id: ");
            var id = scan.nextInt();

            employees.add(daoEmployee.searchById(id));

            System.out.print("Do you want to add more? ");
            var op = scan.next();
            System.out.println(op);

            if (!(op.equals("y"))) exit = true;
        }

        employees.forEach(x -> System.out.println(x.getName()));

        daoEmployee.close();

        DAO<Manager> daoManager = new DAO<>(Manager.class);

        System.out.println("Type the manager id: ");
        var id = scan.nextInt();
        var manager = daoManager.searchById(id);

        if (manager instanceof Manager) {
            ((Manager) manager).addEmployees(employees);
        } else {
            System.out.println("Not a manager");
        }

        scan.close();
        daoEmployee.closeTransaction().close();
    }
}
