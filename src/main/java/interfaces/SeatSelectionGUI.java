package interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import clases.Billete;
import clases.Vuelo;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeatSelectionGUI extends JFrame {

	private JButton[][] seats;
	private int numSelected = 0;
	ArrayList<JButton> selectedSeats = new ArrayList<JButton>();

	public SeatSelectionGUI(Vuelo vuelo) {
		// Создаем окно
		setTitle("Puedes elejir hasta 4 asientos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		HashMap<String, Billete> billetes = vuelo.getBilletes();

		// Создаем панель для схемы самолета
		JPanel planePanel = new JPanel(new GridBagLayout());

		// Создаем описание рядов
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;

		// Добавляем места
		String[] letters = { "A", "B", "C", "D", "E", "F" };
		int numRows = 26;
		seats = new JButton[numRows][letters.length]; // Инициализация массива seats

		for (int i = 1; i <= numRows; i++) {
			// Добавляем описание ряда
			gbc.gridy++;

			// Добавляем места
			gbc.gridx = 1;
			for (int y = 0; y < letters.length; y++) {
				String precio = "1";
				String numero = "2";
        		Iterator itm = billetes.entrySet().iterator();
        		while (itm.hasNext()) {
        			Entry actual = (Entry) itm.next();
        			Billete billete = (Billete) actual.getValue();
        			if(billete.getAsiento().getCodigo().equals(i+letters[y])) {
        				numero = i+letters[y];
        				precio = "" + billete.getPrice();
        			}
 
        			
        		}
        		
				gbc.gridx++;
				JButton button = new JButton(numero+"\n");
				button.setPreferredSize(new Dimension(20, 100));
				planePanel.add(button, gbc);
				seats[i - 1][y] = button; // Добавляем кнопку в массив seats

				if (y == 2) {
					gbc.gridx++;
					gbc.weightx = 1.0;
					planePanel.add(Box.createVerticalGlue(), gbc);
					gbc.weightx = 0.0;
				}
				
				// action Listener que no permite elejir mas que 4 asientos
				button.addActionListener(e -> {
					if (numSelected < 4) {
						button.setSelected(!button.isSelected());
						if (button.isSelected()) {
							numSelected++;
						} else {
							numSelected--;
						}
					} else if (button.isSelected()) {
						button.setSelected(false);
						numSelected--;
					}
				});
			}
		}

		// Создаем панель для кнопки
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton selectButton = new JButton("Сomprar");
		selectButton.addActionListener(e -> {
			selectedSeats.clear(); // Очищаем список выбранных мест перед заполнением
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					JButton button = seats[i][j];
					if (button.isSelected()) {
						selectedSeats.add(button);
					}
				}
			}
			// Вывод выбранных мест (пример)
			for (JButton seat : selectedSeats) {
				System.out.println(seat.getText());
			}
			System.out.println(numSelected);
		});
		buttonPanel.add(selectButton);

		// Добавляем панель для кнопки внизу
		gbc.gridx = 0;
		gbc.gridy = numRows + 1;
		gbc.gridwidth = 8;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		planePanel.add(buttonPanel, gbc);

		// Добавляем панель на окно
		getContentPane().add(planePanel);

		// Отображаем окно

		setMinimumSize(new Dimension(500, getHeight()));

		// Отображаем окно
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
