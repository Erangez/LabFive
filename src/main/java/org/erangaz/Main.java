package org.erangaz;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        // Наполняем данными
        Brawler brawler = new Brawler("Артус", 123);
        Animal animal = new Animal("Медведь", 50, 1);

        characters.add(brawler);
        characters.add(animal);
        int turn = 1;
        do {
            System.out.println("\nХод: " + turn);
            try {
                brawler.showInfo();
                brawler.equipItem("Перчатки");
                brawler.attack();
                System.out.println( );
                animal.takeDamage(brawler.getFullDamage());
                animal.showInfo();
                animal.attack();
            }
            catch (ActionFailedException actionFailedException){
                System.err.println("Бой закончен");
                System.err.println("Причина: " + actionFailedException.getCause().getMessage());
            }
            catch (Exception e){
                System.err.println("Неизвестная ошикба: " + e.getMessage());
            }
            finally {
                System.out.println("Конец хода");
                turn++;
            }
        } while (animal.getHealth() > 0);
//      Frame frame = new Frame();
//      frame.setVisible(true);
    }
}