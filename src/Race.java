import java.util.InputMismatchException;
import java.util.Scanner;

public class Race {
    Registration registration = new Registration();

    public void start() {
        registrationAndList();
    }

    private void registrationAndList() {
        registration.createAnimals();
        registration.writeAnimalsFromList();
        setPoints();

        searcWinner();

    }

    private void setPoints() {
        try (Scanner scanner = new Scanner(System.in)) {


            for (int i = 0; i < registration.list.length; i++) {
                while (getPointsFromUser(scanner,  registration.list, i, "beauty")) {
                }
                while (getPointsFromUser(scanner,  registration.list, i, "behavior")) {
                }

                if (registration.list[i] instanceof Dog) {
                    while (getPointsFromUser(scanner,  registration.list, i, "lojality")) {
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("nem talált objektum");
        }

    }

    private boolean getPointsFromUser(Scanner scanner,  Animal[] animals, int i, String type) {
        boolean truePoint = true;
        try {

            if ((type.equals("beauty") && animals[i] instanceof Cat) || (type.equals("behavior") && animals[i] instanceof Cat)) {
                Cat animal = (Cat) animals[i];
                System.out.print(makeMessage(type) + animal.getName() + " állathoz: ");
                switch (type) {
                    case "beauty" -> animal.setBeautyPoint(scanner.nextInt());
                    case "behavior" -> animal.setBahaviourPoint(scanner.nextInt());
                }


            } else {
                Dog animal = (Dog) animals[i];
                System.out.print(makeMessage(type) + animal.getName() + " állathoz: ");
                switch (type) {
                    case "beauty" -> animal.setBeautyPoint(scanner.nextInt());
                    case "behavior" -> animal.setBahaviourPoint(scanner.nextInt());
                    case "lojality" -> animal.setLojality(scanner.nextInt());
                }
            }

            truePoint = false;
        } catch (InputMismatchException e) {
            System.out.println("Hibás pont");
            truePoint = true;
            scanner.next();
        }
        return truePoint;

    }

    public void searcWinner() {
        int max = 0;
        Animal winner = null;
        for (Animal animal : registration.list) {
            if (animal.getAllPoint() > max) {
                max = animal.getAllPoint();
                winner = animal;
            }
        }
        System.out.println("a gyöztes: " + winner.getName() + "(" + winner.getAllPoint() + ")");
    }

    public String makeMessage(String type){
        StringBuilder stringBuilder = new StringBuilder("");
        switch (type) {
            case "beauty" -> stringBuilder.append("Kérem adja meg a szépség pontszámot ");
            case "behavior" -> stringBuilder.append("Kérem adja meg a viselkedés pontszámot ");
            case "lojality" -> stringBuilder.append("Kérem adja meg a lojalitás pontszámot ");
        }
        return stringBuilder.toString();
    }
}
