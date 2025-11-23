package org.erangaz;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Frame extends JFrame implements ActionListener {
    // Константы
    final int FRAME_WIDTH = 1280, FRAME_HEIGHT = 720;
    final Color BACKGROUND_COLOR = new Color(25, 26, 28);
    final Color PANEL_COLOR = new Color(37, 39, 42);
    final Color PANEL_COLOR_BLUE = Color.decode("#3daee9");
    final Border BORDER_TRANSPARENT = BorderFactory.createLineBorder(new Color(0,0,0,0), 2);
    final Border BORDER_BLUE = BorderFactory.createLineBorder(PANEL_COLOR_BLUE, 2);
    final Font FONT_14pt = new Font("fonts/airborne.ttf", Font.PLAIN, 14);
    final Font FONT_16pt = new Font("fonts/airborne.ttf", Font.PLAIN, 16);

    final String[] RANDOM_ANIMAL_NAMES = {"Кабан", "Кролик", "Крокодил", "Медведь", "Волк"};
    final String[] RANDOM_HUMAN_NAMES = {"Матильда", "Сесилия ", "Гильда", "Уинифред",
            "Осберт", "Иоханн", "Генрих", "Ральф"};
    final String[] RANDOM_ITEMS = new String[]{
            "Меч Доблести",
            "Стальной Нагрудник",
            "Зелье Здоровья",
            "Кольцо Ловкости",
            "Свиток Огненного Шара"
    };
    // Поля
    JTextArea infoTextArea;
    JButton addButton, infoButton, attackButton;
    JComboBox groupList;
    JScrollPane scrollPane;
    String[] classes = new String[]{"Боец", "Животное"};
    Brawler brawler;
    Animal animal;
    int turn = 1;
    String logText = "";
    Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(750, 400));
        setResizable(true);

        // Элементы интерфейса
        JPanel mainPanel = new JPanel();
        JLabel groupLabel = new JLabel("Выбранный персонаж");
        groupList = new JComboBox(classes);
        JLabel logLabel = new JLabel("Игровой лог");
        infoTextArea = new JTextArea();
        scrollPane = new JScrollPane(infoTextArea);
        addButton = new JButton("<html>Добавить / <br>Пересоздать</html>");
        addButton.addActionListener(this);
        infoButton = new JButton("Инфо");
        infoButton.addActionListener(this);
        attackButton = new JButton("Атаковать");
        attackButton.addActionListener(this);

        // Визуал элементов интерфейса
        mainPanel.setBackground(BACKGROUND_COLOR);
        groupLabel.setForeground(Color.WHITE);
        groupLabel.setFont(FONT_16pt);
        groupLabel.setBackground(PANEL_COLOR);
        groupLabel.setBorder(BORDER_TRANSPARENT);
        groupLabel.setForeground(Color.WHITE);
        groupLabel.setMinimumSize(new Dimension(groupLabel.getWidth(), 40));
        logLabel.setForeground(Color.WHITE);
        logLabel.setFont(FONT_16pt);
        logLabel.setBackground(PANEL_COLOR);
        logLabel.setBorder(BORDER_TRANSPARENT);
        logLabel.setForeground(Color.WHITE);
        logLabel.setMinimumSize(new Dimension(groupLabel.getWidth(), 40));
        infoTextArea.setFont(FONT_14pt);
        infoTextArea.setBorder(BORDER_TRANSPARENT);
        infoTextArea.setBackground(PANEL_COLOR);
        infoTextArea.setForeground(Color.WHITE);
        infoTextArea.setEditable(false);
        scrollPane.setBorder(BorderFactory.createLineBorder(PANEL_COLOR, 2));
        scrollPane.getViewport().setBackground(PANEL_COLOR);
        addButton.setFont(FONT_14pt);
        addButton.setBackground(PANEL_COLOR);
        addButton.setBorder(BORDER_TRANSPARENT);
        addButton.setForeground(Color.WHITE);
        addButton.setMinimumSize(new Dimension(200, 30));
        addButton.setMaximumSize(new Dimension(750, 520));
        infoButton.setFont(FONT_14pt);
        infoButton.setBackground(PANEL_COLOR);
        infoButton.setBorder(BORDER_TRANSPARENT);
        infoButton.setForeground(Color.WHITE);
        infoButton.setMinimumSize(new Dimension(200, 30));
        infoButton.setMaximumSize(new Dimension(750, 520));
        attackButton.setFont(FONT_14pt);
        attackButton.setBackground(PANEL_COLOR);
        attackButton.setBorder(BORDER_TRANSPARENT);
        attackButton.setForeground(Color.WHITE);
        attackButton.setMinimumSize(new Dimension(200, 30));
        attackButton.setMaximumSize(new Dimension(750, 520));
        groupList.setBackground(PANEL_COLOR);
        groupList.setForeground(Color.WHITE);
        groupList.setFont(FONT_14pt);
        groupList.setBorder(BORDER_TRANSPARENT);
        groupList.setMinimumSize(new Dimension(groupList.getWidth(), 30));
        groupList.setUI(new BasicComboBoxUI(){
            @Override
            protected ComboPopup createPopup(){
                return new BasicComboPopup(groupList){
                    {
                        this.setBorder(BorderFactory.createLineBorder(BACKGROUND_COLOR, 2));
                    }
                };
            }
            @Override
            protected JButton createArrowButton(){
                JButton button = new JButton();
                button.setBackground(PANEL_COLOR_BLUE);
                button.setBorder(BORDER_TRANSPARENT);
                return button;
            }
        });
        groupList.setRenderer(new ListCellRenderer<String>(){
            @Override
            public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel(value);
                label.setOpaque(true);
                label.setBackground(isSelected ? PANEL_COLOR_BLUE : PANEL_COLOR);
                label.setFont(FONT_14pt);
                label.setForeground(Color.WHITE);
                return label;
            }
        });
        // Планировщик
        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(groupLabel)
                .addComponent(addButton));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(groupList)
                .addComponent(attackButton)
                .addComponent(infoButton));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(logLabel)
                .addComponent(scrollPane));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(groupLabel)
                .addComponent(groupList)
                .addComponent(logLabel));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(addButton)
                                .addComponent(attackButton))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(infoButton))
                )
                .addComponent(scrollPane)
        );
        layout.setVerticalGroup(vGroup);

        // Добавление
        add(mainPanel);

    }

    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == addButton ) {
            switch (groupList.getSelectedIndex()) {
                case 0:
                    brawler = (Brawler)createCharacter(0);
                    break;
                case 1:
                    animal = (Animal)createCharacter(1);
                    break;
            }
        }
        if (event.getSource() == infoButton){
            switch (groupList.getSelectedIndex()) {
                case 0:
                    if (brawler != null)
                        infoTextArea.setText(brawler.getInfo());
                    else
                        infoTextArea.setText("Объект Brawler не создан!");
                    break;
                case 1:
                    if (animal != null)
                        infoTextArea.setText(animal.getInfo());
                    else
                        infoTextArea.setText("Объект Animal не создан!");
                    break;
            }
        }
        if (event.getSource() == attackButton) {
            logText += "--- Начало боя ---\n";
            if (brawler != null && animal != null) {
                while (true) {
                    try {
                        logText += "Ход " + turn + "\n";
                        logText += "\n" + brawler.getInfo();
                        logText += brawler.equipItem(RANDOM_ITEMS[new Random().nextInt(RANDOM_ITEMS.length)], false);
                        logText += brawler.attack(false);

                        logText += "\n";
                        animal.takeDamage((int) brawler.getFullDamage());
                        logText += animal.getName() + " получило урон: " + brawler.getFullDamage() + "\n";
                        logText += animal.getInfo();
                        logText += animal.attack(false);

                    } catch (ActionFailedException e) {
                        logText += "\nОШИБКА БОЯ: " + e.getMessage();
                        logText += "\nПричина: " + e.getCause().getMessage();
                        System.err.println("\nОШИБКА БОЯ: " + e.getMessage());
                        System.err.println("\nПричина: " + e.getCause().getMessage());
                        logText += "\n\n--- Конец боя ---";
                        infoTextArea.setText(logText);
                        logText = "";
                        break;

                    } catch (Exception e) {
                        logText += "\nНеизвестная ошибка: " + e.getMessage();
                        System.err.println("\nНеизвестная ошибка: " + e.getMessage());
                        logText += "\n\n--- Конец боя ---";
                        infoTextArea.setText(logText);
                        logText = "";
                        break;

                    } finally {
                        logText += "\n--- Конец хода ---\n";
                        turn++;
                    }
                }
            }
            else{
                infoTextArea.setText("Один из объектов не создан!");
            }
        }
    }
    public Character createCharacter(int selectedIndex){
        Character returnCharacter;
        switch (groupList.getSelectedIndex()) {
            case 0:
                returnCharacter = new Brawler(
                        RANDOM_HUMAN_NAMES[new Random().nextInt(RANDOM_ANIMAL_NAMES.length)],
                        new Random().nextInt(300 - 100 + 1) + 100,
                        (double) (new Random().nextInt(30 - 10 + 1) + 10)
                );
                System.out.println("Объект " + returnCharacter + " создан!");
                break;
            case 1:
                returnCharacter = new Animal(
                        RANDOM_ANIMAL_NAMES[new Random().nextInt(RANDOM_ANIMAL_NAMES.length)],
                        new Random().nextInt(300 - 100 + 1) + 100,
                        (new Random().nextInt(5) + 1));
                System.out.println("Объект " + returnCharacter + " создан!");
                break;
            default:
                return null;
        }
        return returnCharacter;
    }
}
