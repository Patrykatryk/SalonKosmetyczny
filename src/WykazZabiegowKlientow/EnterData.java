package WykazZabiegowKlientow;

import Klienci.Client;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EnterData {
    public EnterData() {
    }

    public void daneKlienta() {
        System.out.print("Podaj wiek: ");

        int age_input=0;
        while(age_input==0) {
            try {
                Scanner age = new Scanner(System.in);
                age_input = age.nextInt();
            } catch (NoSuchElementException InputMismatchException) {
                System.out.print("Wiek musi być liczbą całkowitą :)\nPodaj wiek:");
            }
        }
        System.out.print("Podaj imię: ");
        Scanner name = new Scanner(System.in);
        String name_input = name.nextLine();

        System.out.print("Podaj nazwisko: ");
        Scanner lastname = new Scanner(System.in);
        String lastname_input = lastname.nextLine();

        System.out.print("Przeciwwskaznia?: ");
        Scanner przeciwwskazania = new Scanner(System.in);
        String przeciwwskazania_input = przeciwwskazania.nextLine();

        Client klient1 = new Client(age_input, name_input, lastname_input, przeciwwskazania_input);
        System.out.println("Wiek: " + klient1.getAge() + "  Imie: " + klient1.getName() + "  Nazwisko: " + klient1.getLastname() + "  Przeciwswskazania: " + klient1.getPrzeciwwskazania());
        try {
            BufferedWriter zapis = new BufferedWriter(new FileWriter("Clients.txt", true)); //pozwala na dopisywanie koljenych klientów do Clients.txt
            zapis.newLine();
            //PrintWriter zapis = new PrintWriter("Clients.txt");
            zapis.write("Wiek:" + klient1.getAge() + "   Imie:" + klient1.getName() + "   Nazwisko:" + klient1.getLastname() + "   Przeciwwskazania:" + klient1.getPrzeciwwskazania());
            zapis.close();
        } catch (FileNotFoundException nofile) {
            System.out.println("Problem z zapisem danych do pliku Clients.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void szukajKlineta(File file) {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }


    public void usuwanie(File file) {

        try {
            Scanner sc = new Scanner(file);
            if (sc.hasNext())
                try {
                    PrintWriter zapis = new PrintWriter("Clients.txt");
                    zapis.write("");
                    zapis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return;

    }
}
