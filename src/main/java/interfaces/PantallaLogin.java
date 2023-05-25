package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import clases.Cliente;
import excepciones.ClienteNoExisteException;
import excepciones.ContraseñaInvalidaExcepcion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaLogin extends PanelFondo{
	private JTextField campoUsuario;
	private JPasswordField passwordField;
	private Ventana ventana;
	private JTextField campoEmail;
	private JPasswordField campoContrasena;
	
	public PantallaLogin(Ventana v) {
		this.ventana = v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelEmail = new JLabel("Email");
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.EAST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 1;
		gbc_labelEmail.gridy = 1;
		add(labelEmail, gbc_labelEmail);
		
		campoEmail = new JTextField();
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 1;
		add(campoEmail, gbc_campoEmail);
		campoEmail.setColumns(10);
		
		JLabel labelContrasena = new JLabel("Contraseña");
		GridBagConstraints gbc_labelContrasena = new GridBagConstraints();
		gbc_labelContrasena.anchor = GridBagConstraints.EAST;
		gbc_labelContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_labelContrasena.gridx = 1;
		gbc_labelContrasena.gridy = 2;
		add(labelContrasena, gbc_labelContrasena);
		
		campoContrasena = new JPasswordField();
		GridBagConstraints gbc_campoContrasena = new GridBagConstraints();
		gbc_campoContrasena.gridwidth = 2;
		gbc_campoContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_campoContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContrasena.gridx = 2;
		gbc_campoContrasena.gridy = 2;
		add(campoContrasena, gbc_campoContrasena);
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
		gbc_botonRegistrarse.anchor = GridBagConstraints.SOUTH;
		gbc_botonRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistrarse.gridx = 2;
		gbc_botonRegistrarse.gridy = 3;
		add(botonRegistrarse, gbc_botonRegistrarse);
		
		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = campoEmail.getText();
				String contrasena = new String(campoContrasena.getPassword());
				System.out.println(email);
				System.out.println(contrasena);
				
				try {
					ventana.clienteLogado = new Cliente(email, contrasena);
					JOptionPane.showMessageDialog(ventana, "Bienvenido " +  ventana.clienteLogado.getNombre() + "!", "Incio con exito", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaAreaPersonal.class);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login Fallido", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ClienteNoExisteException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login Fallido", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContraseñaInvalidaExcepcion e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login Fallido", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.insets = new Insets(0, 0, 5, 5);
		gbc_botonLogin.gridx = 3;
		gbc_botonLogin.gridy = 3;
		add(botonLogin, gbc_botonLogin);
	}
}
