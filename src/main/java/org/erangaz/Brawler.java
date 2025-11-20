package org.erangaz;

public class Brawler extends Character implements Ability, Equipment{
    private double damage;
    private double attackMultiplier;

    Brawler(String name, double health){
        super(name, health);
        damage = 15;
        attackMultiplier = 1.3;
    }
    @Override
    public void attack(){
        System.out.printf("%s нанёс урон: %f\n", getName(), (int)(damage * attackMultiplier * 100) / 100.0);
    }
    @Override
    public void showInfo(){
        System.out.printf("Персонаж:\nИмя - %s\nУровень - %d\nЗдоровье - %f\nУрон - %f\nМножитель урона - %f\n",
                getName(), getLevel(), getHealth(), (int)(damage * 100) / 100.0, (int)(attackMultiplier * 100) / 100.0);
    }
    @Override
    public void useAbility(String abilityName){
        System.out.printf("%s применяет способность: %s\n", getName(), abilityName);
    }
    @Override
    public void equipItem(String itemName){
        System.out.printf("%s экипировал предмет: %s\n", getName(), itemName);
    }
    @Override
    public void removeItem(String itemName){
        System.out.printf("%s снял предмет: %s\n", getName(), itemName);
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
