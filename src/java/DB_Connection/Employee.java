/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Muhammed
 */
public class Employee {

    private int age, ID;
    private String F_NAME, L_NAME;

    public Employee(int age, int ID, String F_NAME, String L_NAME) {
        this.age = age;
        this.ID = ID;
        this.F_NAME = F_NAME;
        this.L_NAME = L_NAME;
    }

    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }

    public String getF_NAME() {
        return F_NAME;
    }

    public String getL_NAME() {
        return L_NAME;
    }
}
