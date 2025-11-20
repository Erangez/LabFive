package org.erangaz;

public class Animal extends Character{
    private int frightLevel;
    Animal(String name, int health, int frightLevel){
        super(name, health);
        this.frightLevel = frightLevel;
    }
    @Override
    public void showInfo(){
        System.out.printf("Животное:\nИмя - %s\nУровень - %d\nЗдоровье - %f\nУровень испуга - %d\n",
                getName(), getLevel(), getHealth(), frightLevel);
    }
    @Override
    public void attack() throws ActionFailedException{
        try{
            if ((double)(getHealth() / frightLevel ) < getHealth() * 0.4){
                throw new FrightException("Животное испугалось и не может атаковать!");
            }
            System.out.println("Животное готово нападать!");
        }catch (FrightException e){
            throw new ActionFailedException("Дейсвтие не удалость по причине:", e);
        }
    }
}
