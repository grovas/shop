package com.sda.shop;
import java.io.Serializable;

public class Position implements Serializable {
    public String positName; // nazwa towaru
    public int positHowManyItemsInPosition; // ile sztuk w danej pozycji
    public double positItemPrice; // cena jednostkowa
    public double positValueWithDisc; // wartosc pozycji z naliczonym rabatem

    public Position() {}

    public Position(String positName,
                    int positHowManyItemsInPosition,
                    double positItemPrice){
        this.positName = positName;
        this.positHowManyItemsInPosition = positHowManyItemsInPosition;
        this.positItemPrice = positItemPrice;
        //   this.positionValueWithDisc = positionValueWithDisc;
    }

    public Position(String positName,
                    int positHowManyItemsInPosition,
                    double positItemPrice,
                    double positValueWithDisc){
        this.positName = positName;
        this.positHowManyItemsInPosition = positHowManyItemsInPosition;
        this.positItemPrice = positItemPrice;
        this.positValueWithDisc = positValueWithDisc;
    }

    // zwraca wartosc pozycji
    public double positValue() {
        return this.positHowManyItemsInPosition * this.positItemPrice;
    }

    // obliczanie wartosci pozycji zaleznie od rabatu udzielonego
    public double positCalulatedWithDiscount (int positHowManyItemsInPosition) {
        if (this.positHowManyItemsInPosition >=5 &&
                this.positHowManyItemsInPosition <=10)
            // discount - 5;
            return this.positValueWithDisc = positValue() * 0.95;
        else if (this.positHowManyItemsInPosition > 20)
            // discount = 10;
            return this.positValueWithDisc = positValue() * 0.9;
        else if (this.positHowManyItemsInPosition > 10 &&
                this.positHowManyItemsInPosition <=20 )
            // discount = 15;
            return this.positValueWithDisc = positValue() * 0.85;
        else return this.positValueWithDisc = positValue();
    }

    @Override
    public String toString() {
        return String.format("%-20s" +
                        "%10.2f zł" +
                        "%4s szt." +
                        "%10.2f zł " +
                        "po rabacie %10.2f zł",
                //positionNumber,
                positName,
                positItemPrice,
                positHowManyItemsInPosition,
                positValue(),
                positCalulatedWithDiscount
                        (positHowManyItemsInPosition)
        );
    }
}
