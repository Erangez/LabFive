package org.erangaz;

public abstract class Character {
    private String name;
    private int level;
    private double health;

    public abstract void attack() throws ActionFailedException;

    Character(String name, double health){
        this.name = name;
        this.health = health;
        this.level = 1;
    }
    public void takeDamage(double damage){
        this.health = health - damage;
    }
    public void showInfo(){
        System.out.printf("Персонаж:\nИмя - %s\nУровень - %d\nЗдоровье - %f\n",
                name, level, health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getHealth() {
        return (int)(health * 100) / 100.0;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
