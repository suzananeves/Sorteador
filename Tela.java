package sorteia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela {

	private JFrame frame;
	private JTextField string_campo;
	private JTextField min_campo;
	private JTextField max_campo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
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
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<String> sort=new ArrayList<>();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setBackground(new Color(205, 213, 220));
		frame.setResizable(false);
		frame.getContentPane().setLayout(springLayout);
		
		
		Border borda1 = BorderFactory.createLineBorder(Color.gray);
		


		
		JLabel painel = new JLabel(" ");
		painel.setForeground(new Color(0, 0, 0));
		springLayout.putConstraint(SpringLayout.NORTH, painel, 17, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, painel, 70, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, painel, 61, SpringLayout.NORTH, frame.getContentPane());
		painel.setOpaque(true);
		painel.setBorder(borda1);
		//fundo
		painel.setBackground(Color.white);
		//letra
		painel.setForeground(Color.black);
		
		
		frame.getContentPane().add(painel);
		
		JButton sorteia = new JButton("Sortear");

		
		JRadioButton num_seletor = new JRadioButton("Números");
		num_seletor.setBackground(new Color(205, 213, 220));

		
		JRadioButton string_seletor = new JRadioButton("Caracteres");
		string_seletor.setBackground(new Color(205, 213, 220));

		
		string_campo = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, string_campo, 0, SpringLayout.WEST, painel);
		springLayout.putConstraint(SpringLayout.SOUTH, string_campo, -132, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, string_campo, -72, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(string_campo);
		string_campo.setVisible(false);
		string_campo.setColumns(10);
		string_campo.setBorder(borda1);
		
		JButton adicionar = new JButton("Adicionar");

		
		min_campo = new JTextField();
		min_campo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				min_campo.setText(null);
				min_campo.setForeground(Color.black);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, min_campo, 0, SpringLayout.WEST, painel);
		springLayout.putConstraint(SpringLayout.SOUTH, min_campo, -54, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, min_campo, -267, SpringLayout.EAST, frame.getContentPane());
		min_campo.setVisible(false);
		min_campo.setBorder(borda1);
		frame.getContentPane().add(min_campo);
		min_campo.setColumns(10);
		
		max_campo = new JTextField();
		max_campo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				max_campo.setText(null);
				max_campo.setForeground(Color.BLACK);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, max_campo, 96, SpringLayout.EAST, min_campo);
		springLayout.putConstraint(SpringLayout.EAST, max_campo, -72, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, adicionar, -18, SpringLayout.NORTH, max_campo);
		springLayout.putConstraint(SpringLayout.NORTH, max_campo, 0, SpringLayout.NORTH, min_campo);
		frame.getContentPane().add(max_campo);
		max_campo.setVisible(false);
		max_campo.setBorder(borda1);
		max_campo.setColumns(10);
		
		num_seletor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num_seletor.isSelected()) {
					string_campo.setVisible(false);
					adicionar.setVisible(false);
					string_seletor.setSelected(false);
					min_campo.setVisible(true);
					min_campo.setText("Número Mínimo");
					min_campo.setForeground(Color.gray);
					max_campo.setText("Número Máximo");
					max_campo.setForeground(Color.gray);
					max_campo.setVisible(true);
					sorteia.setVisible(true);
					
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, num_seletor, 19, SpringLayout.SOUTH, painel);
		springLayout.putConstraint(SpringLayout.WEST, num_seletor, 70, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(num_seletor);
		
		string_seletor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(string_seletor.isSelected()) {
					string_campo.setVisible(true);
					adicionar.setVisible(true);
					num_seletor.setSelected(false);
					min_campo.setVisible(false);
					max_campo.setVisible(false);
					sorteia.setVisible(true);
					
				}
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, string_seletor, -72, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, painel, 0, SpringLayout.EAST, string_seletor);
		springLayout.putConstraint(SpringLayout.NORTH, string_seletor, 0, SpringLayout.NORTH, num_seletor);
		frame.getContentPane().add(string_seletor);
		
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(string_campo.getText().isBlank()){
					painel.setText("Campo vazio");
					
				}else {
					sort.add(string_campo.getText());
					string_campo.setText(null);
					painel.setText(null);
					
				}
				
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, sorteia, 0, SpringLayout.EAST, adicionar);
		springLayout.putConstraint(SpringLayout.WEST, adicionar, 170, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, adicionar, -167, SpringLayout.EAST, frame.getContentPane());
		adicionar.setVisible(false);
		frame.getContentPane().add(adicionar);
		
		springLayout.putConstraint(SpringLayout.WEST, sorteia, 170, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, sorteia, -10, SpringLayout.SOUTH, frame.getContentPane());
		sorteia.setVisible(false);
		sorteia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(num_seletor.isSelected()) {
					try {
						String v_minimo_s = min_campo.getText();
							int v_minimo = Integer.parseInt(v_minimo_s);
							
							String v_maximo_s = max_campo.getText();
							int v_maximo = Integer.parseInt(v_maximo_s);
							
							Random sorteia = new Random();
							int num_fim=sorteia.nextInt(v_minimo,v_maximo+1);
							
							String string_fim=num_fim+" ";
							
							painel.setText(string_fim);
							
						
						
					}catch(Exception NumberFormatException) {
						painel.setText("É preciso preencher valores de Mínimo e Máximo.");
					}
					
				}else {
					try {
						Collections.shuffle(sort);
						painel.setText(sort.get(0));
					}catch (Exception IndexOutOfBoundsException) {
						painel.setText("Não existe valores para sortear");
					}
					
				}
				
				
				
			}
		});
		frame.getContentPane().add(sorteia);
	}
}
