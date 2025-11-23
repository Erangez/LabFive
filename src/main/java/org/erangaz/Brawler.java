package org.erangaz;

public class Brawler extends Character implements Ability, Equipment{
    private double damage;
    private double attackMultiplier;

    Brawler(String name, int health, double damage){
        super(name, health);
        this.damage = damage;
        attackMultiplier = 1.3;
    }
    @Override
    public String attack(boolean consoleOutput){
        if (consoleOutput){
            System.out.printf("%s нанёс урон: %f\n", getName(), (int)(damage * attackMultiplier * 100) / 100.0);
            return null;
        }
        else
            return String.format("%s нанёс урон: %f\n", getName(), (int)(damage * attackMultiplier * 100) / 100.0);
    }
    @Override
    public void showInfo(){
        System.out.printf("Персонаж:\nИмя - %s\nУровень - %d\nЗдоровье - %d\nУрон - %.2f\nМножитель урона - %.2f\n",
                getName(), getLevel(), getHealth(), damage, attackMultiplier);
    }
    @Override
    public String getInfo(){
        return String.format("Персонаж:\nИмя - %s\nУровень - %d\nЗдоровье - %d\nУрон - %.2f\nМножитель урона - %.2f\n",
                getName(), getLevel(), getHealth(), damage, attackMultiplier);
    }
    @Override
    public String useAbility(String abilityName, boolean consoleOutput){
        if (consoleOutput){
            System.out.printf("%s применяет способность: %s\n", getName(), abilityName);
            return null;
        }
        else
            return String.format("%s применяет способность: %s\n", getName(), abilityName);
    }
    @Override
    public String equipItem(String itemName, boolean consoleOutput){
        if(consoleOutput){
            System.out.printf("%s экипировал предмет: %s\n", getName(), itemName);
            return null;
        }
        else
            return String.format("%s экипировал предмет: %s\n", getName(), itemName);
    }
    @Override
    public String removeItem(String itemName, boolean consoleOutput){
        if (consoleOutput) {
            System.out.printf("%s снял предмет: %s\n", getName(), itemName);
            return null;
        }
        else
            return String.format("%s снял предмет: %s\n", getName(), itemName);
    }

    public double getDamage() {
        return damage;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
    public double getAttackMultiplier() {
        return attackMultiplier;
    }
    public void setAttackMultiplier(double attackMultiplier) {
        this.attackMultiplier = attackMultiplier;
    }
    public double getFullDamage(){
        return (int)(damage * attackMultiplier * 100) / 100.0;
    }
}
