package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import clases.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PantallaRegistro extends PanelFondo{
	private Ventana ventana;
	private JTextField emailFiled;
	private JTextField nombreField;
	private JTextField telefonoField;
	private JPasswordField contasenaField;
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoEmail;
	private JPasswordField campoContrasena;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public PantallaRegistro(Ventana v) {	
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelNombre = new JLabel("Nombre");
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.EAST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 1;
		add(labelNombre, gbc_labelNombre);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.gridwidth = 2;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 1;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido");
		GridBagConstraints gbc_labelApellido = new GridBagConstraints();
		gbc_labelApellido.anchor = GridBagConstraints.EAST;
		gbc_labelApellido.insets = new Insets(0, 0, 5, 5);
		gbc_labelApellido.gridx = 1;
		gbc_labelApellido.gridy = 2;
		add(labelApellido, gbc_labelApellido);
		
		campoApellido = new JTextField();
		GridBagConstraints gbc_campoApellido = new GridBagConstraints();
		gbc_campoApellido.gridwidth = 2;
		gbc_campoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_campoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoApellido.gridx = 2;
		gbc_campoApellido.gridy = 2;
		add(campoApellido, gbc_campoApellido);
		campoApellido.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.EAST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 3;
		add(labelEmail, gbc_labelEmail);
		
		campoEmail = new JTextField();
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 3;
		add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);
		
		JLabel labelContrasena = new JLabel("Contraseña");
		GridBagConstraints gbc_labelContrasena = new GridBagConstraints();
		gbc_labelContrasena.anchor = GridBagConstraints.EAST;
		gbc_labelContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_labelContrasena.gridx = 1;
		gbc_labelContrasena.gridy = 4;
		add(labelContrasena, gbc_labelContrasena);
		
		campoContrasena = new JPasswordField();
		GridBagConstraints gbc_campoContrasena = new GridBagConstraints();
		gbc_campoContrasena.gridwidth = 2;
		gbc_campoContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_campoContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContrasena.gridx = 2;
		gbc_campoContrasena.gridy = 4;
		add(campoContrasena, gbc_campoContrasena);
		
		JLabel labelGenero = new JLabel("Genero");
		GridBagConstraints gbc_labelGenero = new GridBagConstraints();
		gbc_labelGenero.anchor = GridBagConstraints.EAST;
		gbc_labelGenero.insets = new Insets(0, 0, 5, 5);
		gbc_labelGenero.gridx = 1;
		gbc_labelGenero.gridy = 5;
		add(labelGenero, gbc_labelGenero);
		
		JRadioButton radioHombre = new JRadioButton("Hombre");
		radioHombre.setSelected(true);
		buttonGroup.add(radioHombre);
		GridBagConstraints gbc_radioHombre = new GridBagConstraints();
		gbc_radioHombre.insets = new Insets(0, 0, 5, 5);
		gbc_radioHombre.gridx = 2;
		gbc_radioHombre.gridy = 5;
		add(radioHombre, gbc_radioHombre);
		
		JRadioButton radioMujer = new JRadioButton("Mujer");
		buttonGroup.add(radioMujer);
		GridBagConstraints gbc_radioMujer = new GridBagConstraints();
		gbc_radioMujer.insets = new Insets(0, 0, 5, 5);
		gbc_radioMujer.gridx = 3;
		gbc_radioMujer.gridy = 5;
		add(radioMujer, gbc_radioMujer);
		
		JButton botonRegistro = new JButton("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = campoNombre.getText();
					String apellido = campoApellido.getText();
					char genero;
					if(radioHombre.isSelected()) {
						genero = 'h';
					} else {
						genero = 'm';
					}
					String email = campoEmail.getText();
					String contrasena = new String(campoContrasena.getPassword());
					if(email.isEmpty() || contrasena.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
						JOptionPane.showMessageDialog(ventana, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					} else {	
						new Cliente(nombre, apellido, genero, email, contrasena);
						JOptionPane.showMessageDialog(ventana, "Registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
						ventana.cambiarAPantalla(PantallaLogin.class);
					}
				} catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana, "No se puede registrar", "Error", JOptionPane.ERROR_MESSAGE);
				}	catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "No se puede connectar", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.gridwidth = 2;
		gbc_botonRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistro.gridx = 2;
		gbc_botonRegistro.gridy = 6;
		add(botonRegistro, gbc_botonRegistro);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.gridwidth = 2;
		gbc_botonCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_botonCancelar.gridx = 2;
		gbc_botonCancelar.gridy = 7;
		add(botonCancelar, gbc_botonCancelar);		
	}
}
