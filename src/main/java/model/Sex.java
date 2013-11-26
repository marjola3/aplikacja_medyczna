package model;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public enum Sex {
    kobieta('K'),
    mezczyzna('M');

    private char litera;

    Sex(char litera) {
        this.litera = litera;
    }

    public char getLitera(){
        return litera;
    }
}
