/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author juan
 */
public abstract class User {
    private int id;
    private String user;
    private String name;
    private String password;
    private int age;
    private String email;
    private boolean active;
    private UserType roll;

    public User(){

    }
    
    public User(int id, String user, String name, String password, int age, String email, boolean active, UserType roll ) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.password = password;
        this.age = age;
        this.email = email;
        this.roll = roll;
        this.active = active;
    }
    
    public User( String user, String name, String password, int age, String email, boolean active, UserType roll ) {
        this.user = user;
        this.name = name;
        this.password = password;
        this.age = age;
        this.email = email;
        this.roll = roll;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserType getRoll() {
        return roll;
    }

    public void setRoll(UserType roll) {
        this.roll = roll;
    }
    
}
