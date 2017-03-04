package com.sda.shop;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    public int orderMaxSize; // maksymalna liczba pozycji w zamowieniu
    public int orderHowManyItems; // liczba pozycji w zamowieniu
    public double orderTotal; // wartosc calego zamowienie
    public double orderTotalWithDisc; // wartosc calego zamowienia z rabatem

    List<Position> positionList = new ArrayList<>();

    public Order() { orderMaxSize = 10; }

    public Order(int orderMaxSize) { this.orderMaxSize = orderMaxSize; }

    public Order(int orderMaxSize, int orderHowManyItems,
                 double orderTotal, double orderTotalWithDisc) {
        this.orderMaxSize = orderMaxSize;
        this.orderHowManyItems = orderHowManyItems;
        this.orderTotal = orderTotal;
        this.orderTotalWithDisc = orderTotalWithDisc;
    }

    // dodaje pozycje do zamowienia
    public void addPositionToOrder (Position position) {
        positionList.add(position);
    }

    public static double operate(double a, double b, InterfaceAdd interfaceAdd) {
        return interfaceAdd.operation(a,b);
    }



    // obliczenie wartosc zamowienia przez sumowanie poszczegolnych pozycji
    public double orderValue (List<Position> position) {

        double pos;
        pos = position.stream()
                .mapToDouble(Position::positValue)
                .sum();

        /*
        for (Position p: positionList) {
            orderSummary = orderSummary + p.positValue();
        }*/

        return pos;
    }

    @Override
    public String toString() {
        this.orderTotalWithDisc = 0;
        StringBuilder sb = new StringBuilder("\nZamówienie:\n");
        for (Position z: positionList) {
            sb.append(String.format("%-20s", z.positName));
            sb.append(String.format("%10.2f zł", z.positItemPrice));
            sb.append(String.format("%4s szt.", z.positHowManyItemsInPosition));
            sb.append(String.format("%10.2f zł", z.positValue()));
            sb.append(String.format(" po rabacie %10.2f zł\n", z.positValueWithDisc));

            this.orderTotalWithDisc = this.orderTotalWithDisc + z.positValueWithDisc;
        }
        sb.append(String.format("\nRazem %71.2f zł\n", this.orderValue(positionList)));
        sb.append(String.format("Po rabacie %66.2f zł", this.orderTotalWithDisc));

        return sb.toString();
    }

    // metoda usuwa pozycje z zamowienia
    public void orderPositionRemove(int index){
        positionList.remove(index);
    }
    // edytowanie pozycji zamowienia
    public void orderPositionEdit(int index) {

    }

    public void orderSave (Order order, String file) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(file));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(order);
        o.close();
        f.close();
    }

    public void orderRead (String file) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File(file));
        ObjectInputStream oi = new ObjectInputStream(fi);
        // Read objects
        Order o1 = (Order) oi.readObject();

        System.out.println("Po wczytaniu z pliku:");
        System.out.println(o1);

        oi.close();
        fi.close();
    }
}
