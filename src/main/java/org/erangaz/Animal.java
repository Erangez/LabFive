package org.erangaz;

public class Animal extends Character{
    private final int frightLevel;
    Animal(String name, int health, int frightLevel){
        super(name, health);
        this.frightLevel = frightLevel;
    }
    @Override
    public void showInfo(){
        System.out.printf("Животное:\nИмя - %s\nУровень - %d\nЗдоровье - %d\nУровень испуга - %d\n",
                getName(), getLevel(), getHealth(), frightLevel);
    }
    @Override
    public String getInfo(){
        return String.format("Животное:\nИмя - %s\nУровень - %d\nЗдоровье - %d\nУровень испуга - %d\n",
                getName(), getLevel(), getHealth(), frightLevel);
    }
    @Override
    public String attack(boolean consoleOutput) throws ActionFailedException{
        String logOutput = "";
        if (consoleOutput) {
            try {
                if ((double) (getHealth() / frightLevel) < getHealth() * 0.4) {
                    throw new FrightException("Животное испугалось и не может атаковать!");
                }
                System.out.println("Животное готово нападать!");
            } catch (FrightException e) {
                throw new ActionFailedException("Действие не удалось по причине:", e);
            }
        }
        else{
            try {
                if ((double) (getHealth() / frightLevel) < getHealth() * 0.4) {
                    logOutput += "Животное испугалось и не может атаковать!\n";
                    throw new FrightException("Животное испугалось и не может атаковать!");
                }
                logOutput += "Животное готово нападать!\n";
                System.out.println("Животное готово нападать!");
            } catch (FrightException e) {
                logOutput += "Действие не удалось по причине: " + e.getMessage();
                throw new ActionFailedException("Действие не удалось по причине:", e);
            }
        }
        return logOutput;
    }
}
