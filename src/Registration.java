import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Registration {
    Animal[] list;
    private final String DELIMITER = ";";

    public List<String> readFileFromTxt() {
        String regFile = "D:\\project\\java\\gyakorlo_feladatok\\gyakorlo_feladat_3\\reg.txt";

        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(regFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e);
        }
        list=new Animal[lines.size()];
        return lines;
    }

    public void createAnimals() {
        List<String> lines = readFileFromTxt();
        for (int i = 0; i < lines.size(); i++) {
            String all = lines.get(i);
            String[] animalData = all.split(DELIMITER);
            if (animalData.length > 2) {
                calculateAge(animalData[0], animalData[1], 1,i);
            } else {
                calculateAge(animalData[0], animalData[1], 2,i);

            }
        }
    }

    private boolean checkCharacter(char c) {
        return Character.isDigit(c);
    }

    private String replaceNonDigitCharacter(String ad) {
        StringBuilder sb = new StringBuilder(ad);

        for (int j = 0; j < sb.length(); j++) {

            if (!checkCharacter(sb.charAt(j))) {
                sb.replace(j, j + 1, "");
            }
        }
        return sb.toString();

    }

    private void calculateAge(String name, String ad, int type,int arrayIndex) {
        int birth;
        try {
            birth = Integer.parseInt(ad);
        } catch (NumberFormatException e) {
            birth = Integer.parseInt(replaceNonDigitCharacter(ad));
        }
        if (type == 1) {
            createInstance(name, birth, "cat",arrayIndex);
        } else if (type == 2) {
            createInstance(name, birth, "dog",arrayIndex);
        }
    }

    private void createInstance(String name, int by,String animal,int arrayIndex) {
        Animal animal1 = null;
        switch (animal) {
            case "cat" -> {
                animal1 = new Cat(name, by);
                animal1.setStartNum(arrayIndex + 1);
            }
            case "dog" -> {
                animal1 = new Dog(name, by);
                animal1.setStartNum(arrayIndex + 1);
            }
        }

        list[arrayIndex]=animal1;

    }
    public void writeAnimalsFromList(){
            System.out.println("név | év");
        for(Animal animal:list){
            boolean bool= animal instanceof Cat;
            System.out.print(animal.getName()+" | "+animal.getAge()+" | "+((bool)?"macska | ":"kutya"+ " | "));
            System.out.print(animal.getBeautyPoint()+" | "+animal.getBahaviourPoint());
            System.out.print(" | "+animal.getStartNum());
            System.out.println();

        }
    }
}

