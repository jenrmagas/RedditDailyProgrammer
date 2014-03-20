package net.ewenicorn.reddit.dailyprogrammer.easy;

public class Problem008NinetyNineBottles {

    public static void main(final String[] args) {
        for (int i = 99; i > 0; i--) {
            System.out.println(singVerse(i));
        }
    }

    private static String singVerse(final int numberOfBottles) {
        String bottlesBefore = singBottlesOfBeer(numberOfBottles);
        String bottlesAfter = singBottlesOfBeer(numberOfBottles - 1);

        StringBuilder verse = new StringBuilder();
        verse.append(bottlesBefore + " on the wall\n");
        verse.append(bottlesBefore + "\n");
        verse.append("Take one down\n");
        verse.append("Pass it around\n");
        verse.append(bottlesAfter + " on the wall\n");

        return verse.toString();
    }

    private static String singBottlesOfBeer(final int numberOfBottles) {
        String bottlesBefore = numberOfBottles + " bottle";

        if (numberOfBottles != 1) {
            bottlesBefore += "s";
        }
        bottlesBefore += " of beer";

        return bottlesBefore;
    }

}
