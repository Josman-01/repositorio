import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	conexion db=new conexion();
	Connection cin = (Connection) db.getConnection();
	String usuario,correo_electronico,contraseña;
	PreparedStatement ps;
	
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 484, 477);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(170, 23, 115, 37);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(131, 110, 233, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 294, 233, 37);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(131, 88, 85, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(130, 262, 115, 32);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 199, 233, 41);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Correo Electronico");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(131, 174, 172, 27);
		panel.add(lblNewLabel_3);
		//Boton Insertar
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario,correo_electronico,contraseña;
				usuario=textField.getText();
				correo_electronico=textField_2.getText();
				contraseña=textField_1.getText();
				
				PreparedStatement ps;
				
				 String insertar="INSERT INTO `base_proyecto`.`registro` (`usuario`, `correo_electronico`, `contraseña`) VALUES (?,?,?)";
				 
				 try {
					 
					 ps=(PreparedStatement) cin.prepareCall(insertar);
					 	System.out.println("insertando");
					 	ps.setString(1, usuario);
					 	ps.setString(2, correo_electronico);
					 	ps.setString(3, contraseña);
					 	
					 int registro1=ps.executeUpdate();
				if(registro1>0) {
					JOptionPane.showMessageDialog(null, "Regristro guardado", "bien", JOptionPane.QUESTION_MESSAGE, null);
					textField.setText("");
					textField_2.setText("");
					textField_1.setText("");
				}
				else {
						JOptionPane.showMessageDialog(null, "error al guardar registro", "error", JOptionPane.ERROR_MESSAGE);
				}
				} catch (SQLException el) {
					el.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 371, 89, 23);
		panel.add(btnNewButton);
		//Boton buscar
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario=textField.getText();
				
				String buscar="select * from base_proyecto.registro where usuario=?";
				
				try {
					ps=(PreparedStatement) cin.prepareCall(buscar);
						System.out.println("buscando");
						ps.setString(1, usuario);
						
					ResultSet registro=ps.executeQuery();
					
				if(registro.next()) {
					textField.setText(registro.getString("usuario"));
					textField_2.setText(registro.getString("correo_electronico"));
					textField_1.setText(registro.getString("contraseña"));
					
					JOptionPane.showMessageDialog(null, "Registro encontrado", "bien", JOptionPane.QUESTION_MESSAGE, null);
				}else {
						JOptionPane.showMessageDialog(null, "Error al buscar registro", "error", JOptionPane.ERROR_MESSAGE);
				}
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(127, 371, 89, 23);
		panel.add(btnNewButton_1);
		//Boton eliminar
		JButton btnNewButton_4 = new JButton("Eliminar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eliminar= "DELETE FROM `base_proyecto`.`registro` WHERE (`usuario` =?)";
				
				try {
						ps=(PreparedStatement) cin.prepareCall(eliminar);
						System.out.println("eliminando");
						ps.setString(1, usuario);
					int registro=ps.executeUpdate();
					
				if(registro>0) {
					JOptionPane.showMessageDialog(null, "Registro eliminado", "bien", JOptionPane.QUESTION_MESSAGE, null);
					textField.setText("");
					textField_2.setText("");
					textField_1.setText("");
					
					
				}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar registro", "error", JOptionPane.ERROR_MESSAGE);
				}
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(241, 371, 89, 23);
		panel.add(btnNewButton_4);
		//boton actualizar
		JButton btnNewButton_2 = new JButton("Actualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				usuario=textField.getText();
				correo_electronico=textField_2.getText();
				contraseña=textField_1.getText();
				
				String actualizar ="UPDATE `base_proyecto`.`registro` SET `usuario` = ?, `correo_electronico` = ?, `contraseña` = ? WHERE (`usuario` = ?)";
				
				try {
					ps=(PreparedStatement) cin.prepareCall(actualizar);
					System.out.println("actualzando");
					ps.setString(1, usuario);
					ps.setString(2, correo_electronico);
					ps.setString(3, contraseña);
					ps.setString(4, usuario);
				int registro=ps.executeUpdate();
				
			if(registro>0) {
				JOptionPane.showMessageDialog(null, "Registro modificado", "bien", JOptionPane.QUESTION_MESSAGE, null);
				textField.setText("");
				textField_2.setText("");
				textField_1.setText("");
				
				
			}else {
					JOptionPane.showMessageDialog(null, "Error al modificar registro", "error", JOptionPane.ERROR_MESSAGE);
			}
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			}
		});
		btnNewButton_2.setBounds(355, 371, 89, 23);
		panel.add(btnNewButton_2);

	}
}
