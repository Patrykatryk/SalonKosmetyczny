package Zabiegi;

import Klienci.Client;

public abstract class Zabieg {
    Client klient;
    String nazwa;
    int wykupionaIlosc;
    double cena;

    public void czyBolesny() {
        System.out.print("Delikatny dyskomfort");
    }

}
