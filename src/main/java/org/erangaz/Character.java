package org.erangaz;

public abstract class Character {
    private String name;
    private int level;
    private int health;

    public abstract String attack(boolean consoleOutput) throws ActionFailedException;
    public abstract void showInfo();
    public abstract String getInfo();

    Character(String name, int health){
        this.name = name;
        this.health = health;
        this.level = 1;
    }

    public void takeDamage(int damage){
        this.health = health - damage;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
