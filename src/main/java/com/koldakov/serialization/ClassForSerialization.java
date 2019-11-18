package com.koldakov.serialization;

import java.io.Serializable;

public class ClassForSerialization implements Serializable {
//    private static final long serialVersionUID = -8352140901348230760L;

    private String name;
    private String password;
    private String address;

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

    public String getAddress() {
        return address;
    }
}
