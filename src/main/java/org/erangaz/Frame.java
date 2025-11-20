package org.erangaz;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Frame extends JFrame {
    // Константы
    final int FRAME_WIDTH = 1280, FRAME_HEIGHT = 720;
    final Color BACKGROUND_COLOR = new Color(25,26, 28);
    final Color PANEL_COLOR = new Color(37, 39, 42);
    final Color PANEL_COLOR_BLUE = Color.decode("#3daee9");
    final Border BORDER_BLUE = BorderFactory.createLineBorder(PANEL_COLOR_BLUE, 2);
    final Font FONT_14pt = new Font("fonts/airborne.ttf", Font.PLAIN, 14);
    final Font FONT_16pt = new Font("fonts/airborne.ttf", Font.PLAIN, 16);

    final String[] RANDOM_CREATURE_NAMES = {"Существо", "Сущность", "Нечто", "Null", "Оно"};
    final String[] RANDOM_GUARDIAN_NAMES = {"Матильда", "Сесилия ", "Гильда", "Уинифред",
            "Осберт", "Иоханн", "Генрих", "Ральф"};
    final String[] RANDOM_GUARDIAN_SUBNAMES = {"де Рос", "де Монтермар", "де Ольстер", "Болдуин",
            "Чилхем", "Вигмор", "де Монфор", "Типтофт"};
    final String[] RANDOM_ENEMY_NAMES = {"Драмор","Брактул","Боргмайр","Дратар",
            "Гритбит","Вексрокс","Уксбор","Цунхан"};
    // Поля
    JScrollPane scrollPane;
    JTable table;
    DefaultTableModel tableModel;
    String[] names = {
            "ID",
            "Имя",
            "Уровень",
            "Группа",
    };
    int id;
    JTextField levelTextField;
    JTextArea infoTextArea;
    JButton addButton, deleteButton, infoButton;
    JComboBox groupList;
    String[][] data = new String[0][0];
    Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setMinimumSize(new Dimension(750, 400));
        setResizable(true);

        // Элементы интерфейса

    }
}
