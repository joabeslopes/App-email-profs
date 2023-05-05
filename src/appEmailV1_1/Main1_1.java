package appEmailV1_1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Main1_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTable infoProf;
	
	SqlConnect sqlCon = new SqlConnect();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1_1 frame = new Main1_1();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public Main1_1() {
		
		setTitle("Pesquisa de email");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 95, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(26, 95, 180));
		
		JPanel panel4 = new JPanel();
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(26, 95, 180));
		
		JScrollPane scrollPane5 = new JScrollPane();
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(26, 95, 180));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel4, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
		);
		
		infoProf = new JTable();
		infoProf.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Sobrenomes", "Email", "Turma", "Periodo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		infoProf.getColumnModel().getColumn(0).setPreferredWidth(20);
		infoProf.getColumnModel().getColumn(0).setMinWidth(20);
		infoProf.getColumnModel().getColumn(1).setPreferredWidth(90);
		infoProf.getColumnModel().getColumn(1).setMinWidth(20);
		infoProf.getColumnModel().getColumn(2).setPreferredWidth(130);
		infoProf.getColumnModel().getColumn(2).setMinWidth(20);
		infoProf.getColumnModel().getColumn(3).setPreferredWidth(200);
		infoProf.getColumnModel().getColumn(3).setMinWidth(20);
		infoProf.getColumnModel().getColumn(4).setMinWidth(20);
		infoProf.getColumnModel().getColumn(5).setPreferredWidth(90);
		infoProf.getColumnModel().getColumn(5).setMinWidth(20);
		scrollPane5.setViewportView(infoProf);
		
		JLabel lblNewLabel = new JLabel("Digite o primeiro nome do professor: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setColumns(10);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(140)
					.addComponent(textName)
					.addGap(147))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel1.setLayout(gl_panel1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JTextArea textEmail = new JTextArea();
		textEmail.setEditable(false);
		
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel3.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel3.setLayout(gl_panel3);
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblOutrasInformaes = new JLabel("Outras informações");
		lblOutrasInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutrasInformaes.setFont(new Font("Dialog", Font.BOLD, 11));
		panel4.add(lblOutrasInformaes);
		contentPane.setLayout(gl_contentPane);
		
		JButton btnSearchName = new JButton("Pesquisar nome");
		panel2.add(btnSearchName);
		
		btnSearchName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			//Limpa a tela
				DefaultTableModel df = (DefaultTableModel) infoProf.getModel();
				df.setRowCount(0);
				textEmail.setText(null);
			// Pesquisa o email do prof	
				String name = textName.getText();
				sqlCon.criarConexao();
				String email = sqlCon.pesquisaEmail(name);
				
				//se ele achar o email
				if (!email.equals("0")) {
					
					//mostra o email
					textEmail.setText(email);
					
					// Preenche a tabela com outras informações
					Vector<Vector<String>> tabela = sqlCon.outrasInfos(name);
					int colunas = sqlCon.colunas;
					for (int i=0; i<colunas; i++) {
						df.addRow(tabela.elementAt(i));
					}
				}else {
					JOptionPane.showMessageDialog(btnSearchName, "Nome não encontrado, tente novamente");
				}
				
				sqlCon.encerrarConexao();
				
			}
		});

	}
}