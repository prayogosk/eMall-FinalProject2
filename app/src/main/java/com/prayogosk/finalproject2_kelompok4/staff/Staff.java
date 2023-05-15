package com.prayogosk.finalproject2_kelompok4.staff;

public class Staff {
    private int id;
    private String name;
    private String password;

    public Staff() {
        super();
    }

    public Staff(String name, String password) {
        this.name = name;
        this.password = password;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
