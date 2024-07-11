import java.awt.EventQueue;

import javax.swing.JFrame;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	conexion db=new conexion();
	Connection cin = (Connection) db.getConnection();
	String administrador,contraseña;
	PreparedStatement ps;
	
	private JTextField textField;
	private JTextField textField_1;
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 723, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 707, 583);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(283, 31, 137, 60);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("administrador");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(112, 170, 105, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(112, 245, 137, 30);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(260, 167, 204, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 245, 204, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				administrador=textField.getText();
				contraseña=textField_1.getText();
				
				String buscar="select * from base_proyecto.usuario where administrador=? and contraseña=?";
				
				try {
					ps=(PreparedStatement) cin.prepareCall(buscar);
						System.out.println("buscando");
						ps.setString(1, administrador);
						ps.setString(2, contraseña);
						
					ResultSet registro=ps.executeQuery();
					
				if(registro.next()) {

					
					JOptionPane.showMessageDialog(null, "Usuario y Contraseña correctos", "bien", JOptionPane.QUESTION_MESSAGE, null);
					App frame1 = new App();
					frame1.setVisible(true);
					
					frame.setVisible(false);
				}else {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "error", JOptionPane.ERROR_MESSAGE);
				}
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(169, 169, 169));
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 25));
		btnNewButton.setBounds(294, 398, 156, 39);
		panel.add(btnNewButton);
	}

}
