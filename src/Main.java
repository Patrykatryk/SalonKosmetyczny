import Zabiegi.Karboksyterapia;
import Zabiegi.MezoterapiaMikroigłowa;
import WykazZabiegowKlientow.EnterData;

import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        boolean program=true;
        while(program) {
            System.out.println("\nMenu:");
            System.out.println("1.  Dodowanie klienta");
            System.out.println("2.  Wyświetl listę wszystkich klientów");
            System.out.println("3.  Wykup zabieg");
            System.out.println("97. Usuwanie wszystkich klientów");
            System.out.println("99. Zamknij program");
            Scanner choice_input = new Scanner(System.in);
            System.out.println("Wybierz numer zadania: ");
            int choice=choice_input.nextInt();
            File file = new File("D:\\Programowanie\\Java\\Salon_kosmetyczny\\Clients.txt");


            switch (choice) {
                case 1:
                    EnterData daneKlienta= new EnterData();
                    daneKlienta.daneKlienta();
                    break;

                case 2:
                    EnterData szukajKlienta= new EnterData();
                    szukajKlienta.szukajKlineta(file);
                    break;


                case 3:
                    System.out.println("Wybierz zabieg:");
                    System.out.println("1. Mezoterapia Mikoigłowa \n2. Karboksyterapia");
                    Scanner choice_input2 = new Scanner(System.in);
                    int choice2=choice_input2.nextInt();
                    switch(choice2) {
                        case 1:
                            MezoterapiaMikroigłowa igłowa = new MezoterapiaMikroigłowa();
                            igłowa.czyBolesny();
                            break;
                        case 2:
                            Karboksyterapia karbo = new Karboksyterapia();
                            karbo.czyBolesny();
                    }
                    break;


                case 97:
                    System.out.println("Czy na pewno chcesz usunąć całą bazę klientów?  y/n");
                    Scanner usun = new Scanner(System.in);
                    String usun_input = usun.nextLine();
                    if (usun_input.equals("y")) {
                        EnterData usuwanie= new EnterData();
                        usuwanie.usuwanie(file);
                    }
                    break;



                case 99:
                    System.out.println("-Wyłączanie programu-");
                    program=false;
                    break;
            }

        }
    }




}