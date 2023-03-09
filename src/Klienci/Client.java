package Klienci;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    private int age;
    private String name,lastname;

    private String przeciwwskazania;

    public Client(int ag, String nam, String lastnam, String przeciwwskazan) {
        this.age = ag;
        this.name = nam;
        this.lastname = lastnam;
        this.przeciwwskazania= przeciwwskazan;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {

        return lastname;
    }

    public String getPrzeciwwskazania() {
        return przeciwwskazania;
    }


}
