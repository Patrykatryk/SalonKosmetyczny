import Klienci.Client;

import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        boolean program=true;
        while(program) {
            System.out.println("Menu:");
            System.out.println("1. Dodowanie klienta");
            System.out.println("2. Wyświetl listę wszystkich klientów");
            System.out.println("99. Zamknij program");
            Scanner choice_input = new Scanner(System.in);
            System.out.println("Wybierz numer zadania: ");
            int choice=choice_input.nextInt();


            switch (choice) {
                case 1:
                    Scanner age = new Scanner(System.in);
                    int age_input = age.nextInt();

                    Scanner name = new Scanner(System.in);
                    String name_input = name.nextLine();

                    Scanner lastname = new Scanner(System.in);
                    String lastname_input = lastname.nextLine();

                    Scanner przeciwwskazania = new Scanner(System.in);
                    String przeciwwskazania_input = przeciwwskazania.nextLine();

                    Client klient1 = new Client(age_input, name_input, lastname_input, przeciwwskazania_input );
                    System.out.println("Wiek:" + klient1.getAge() + " Imie:" + klient1.getName() + " Nazwisko:" + klient1.getLastname());
                    try {
                        BufferedWriter zapis = new BufferedWriter(new FileWriter("Clients.txt", true)); //pozwala na dopisywanie koljenych klientów do Clients.txt
                        zapis.newLine();
                        //PrintWriter zapis = new PrintWriter("Clients.txt");
                        zapis.write("Wiek:" + klient1.getAge() + "   Imie:" + klient1.getName() + "   Nazwisko:" + klient1.getLastname() +"   Przeciwwskazania:"+klient1.getPrzeciwwskazania());
                        zapis.close();
                    }
                    catch (FileNotFoundException nofile) {
                        System.out.println("Problem z zapisem danych do pliku Clients.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case 2:
                    try {
                        File file = new File("D:\\Programowanie\\Java\\Salon_kosmetyczny\\Clients.txt");
                        Scanner sc = new Scanner(file);
                        while (sc.hasNextLine())
                            System.out.println(sc.nextLine());
                        sc.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 99:
                    program=false;
                    break;
            }

        }
    }
}