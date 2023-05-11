package appEmailV2;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main2 extends JFrame {

	private JPanel Principal;
	private JTextField textName;
	private JTable infoProf;
	private String email;
	private String selecaoEmail;
	private int selecaoLinha;
	
	
	SqlConnect sqlCon = new SqlConnect();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 frame = new Main2();
					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public Main2() {
		
		setTitle("Pesquisa de email");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 400, 170);
		Principal = new JPanel();
		Principal.setBackground(new Color(26, 95, 180));
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Principal);
		
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(26, 95, 180));
		panel3.setVisible(false);
		
		
		JPanel panel4 = new JPanel();
		panel4.setVisible(false);
		
		
		JPanel panel2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel2.getLayout();
		flowLayout.setHgap(50);
		panel2.setBackground(new Color(26, 95, 180));
		
		
		JScrollPane scrollPane5 = new JScrollPane();
		scrollPane5.setVisible(false);
		
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(26, 95, 180));
		
		
		GroupLayout gl_Principal = new GroupLayout(Principal);
		gl_Principal.setHorizontalGroup(
			gl_Principal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Principal.createSequentialGroup()
					.addGroup(gl_Principal.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel4, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Principal.setVerticalGroup(
			gl_Principal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Principal.createSequentialGroup()
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
				"ID", "Nome", "Sobrenomes", "Turma", "Periodo", "Email"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		infoProf.getColumnModel().getColumn(0).setPreferredWidth(20);
		infoProf.getColumnModel().getColumn(0).setMinWidth(20);
		infoProf.getColumnModel().getColumn(1).setPreferredWidth(90);
		infoProf.getColumnModel().getColumn(1).setMinWidth(20);
		infoProf.getColumnModel().getColumn(2).setPreferredWidth(200);
		infoProf.getColumnModel().getColumn(2).setMinWidth(20);
		infoProf.getColumnModel().getColumn(3).setPreferredWidth(60);
		infoProf.getColumnModel().getColumn(3).setMinWidth(20);
		infoProf.getColumnModel().getColumn(4).setPreferredWidth(90);
		infoProf.getColumnModel().getColumn(4).setMinWidth(20);
		infoProf.getColumnModel().getColumn(5).setPreferredWidth(0);
		infoProf.getColumnModel().getColumn(5).setMinWidth(0);
		infoProf.getColumnModel().getColumn(5).setMaxWidth(0);
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
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(Alignment.TRAILING, gl_panel1.createSequentialGroup()
					.addGap(86)
					.addComponent(textName, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addGap(87))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		panel1.setLayout(gl_panel1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
	
		
		JTextArea textEmail = new JTextArea();
		textEmail.setEditable(false);
		textEmail.setText(null);
		
		
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
		Principal.setLayout(gl_Principal);
		
		
		
		JButton btnSearchName = new JButton("Pesquisar nome");
		panel2.add(btnSearchName);
		
		
		
		JButton btnEnviarEmail = new JButton("Enviar email");
		panel2.add(btnEnviarEmail);
		btnEnviarEmail.setVisible(false);
		

		
		
		
		// Ações do botão de pesquisa, que serão as mesmas se o usuário pressionar Enter
		
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//Limpa a tela
				DefaultTableModel df = (DefaultTableModel) infoProf.getModel();
				df.setRowCount(0);
				textEmail.setText(null);
				
			// Pesquisa o email do prof	
				String name = textName.getText();
				sqlCon.criarConexao();
				email = sqlCon.pesquisaEmail(name);
				
				//se ele achar o email
				if (email != null) {
					
					
					//Altera a tela do usuário
					btnEnviarEmail.setVisible(true);
					panel3.setVisible(true);
					panel4.setVisible(true);
					scrollPane5.setVisible(true);
					setBounds(400, 300, 500, 370);
					
					//mostra o primeiro email encontrado
					textEmail.setText(email);
					
					
					// Preenche a tabela com outras informações coletadas
					Vector<Vector<String>> tabela = sqlCon.outrasInfos(name);
					int colunas = sqlCon.colunas;
					for (int i=0; i<colunas; i++) {
						df.addRow(tabela.elementAt(i));
					}
					
					
				}else {
					//Altera a tela do usuário
					btnEnviarEmail.setVisible(false);
					panel3.setVisible(false);
					panel4.setVisible(false);
					scrollPane5.setVisible(false);
					setBounds(400, 300, 400, 170);
					
					//Mensagem de erro
					JOptionPane.showMessageDialog(btnSearchName, "Nome não encontrado, tente novamente");
				}
				
				sqlCon.encerrarConexao();
				
			}
			
		});
		
		
		//Açoes do botao de enviar email
		btnEnviarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				    try {
				    	
				    	
						// Copia o email selecionado da tabela para a área de transferência

				    	StringSelection selection = new StringSelection(selecaoEmail);
				    	
						if (!selection.equals(null)) {
							
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(selection, selection);

							JOptionPane.showMessageDialog(btnSearchName, "Email copiado para a área de transferência !");
						}
						
					//Desktop.getDesktop().browse(new URI("https://serverjoabe.xyz:8090/snappymail/"));
				    	Desktop.getDesktop().browse(new URI("https://outlook.live.com/owa/?nlp=1"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		
		
		
		// Reconhece a linha da tabela que o usuário clica, e coloca o email do professor selecionado na tela
		infoProf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(!textEmail.getText().equals(null)) {
					selecaoLinha = infoProf.getSelectedRow();
					if (selecaoLinha !=-1) {
					selecaoEmail = infoProf.getValueAt(selecaoLinha, 5).toString();
					textEmail.setText(selecaoEmail);
					}
				}
			}
		});

		
		
		
		// Ações ao pressionar Enter, que serão as mesmas do botão de pesquisa
		textName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					
					
					//Limpa a tela
						DefaultTableModel df = (DefaultTableModel) infoProf.getModel();
						df.setRowCount(0);
						textEmail.setText(null);
						
					// Pesquisa o email do prof	
						String name = textName.getText();
						sqlCon.criarConexao();
						email = sqlCon.pesquisaEmail(name);
						
						//se ele achar o email
						if (email != null) {
							
							
							//Altera a tela do usuário
							btnEnviarEmail.setVisible(true);
							panel3.setVisible(true);
							panel4.setVisible(true);
							scrollPane5.setVisible(true);
							setBounds(400, 300, 500, 370);
							
							//mostra o primeiro email encontrado
							textEmail.setText(email);
							
							
							// Preenche a tabela com outras informações coletadas
							Vector<Vector<String>> tabela = sqlCon.outrasInfos(name);
							int colunas = sqlCon.colunas;
							for (int i=0; i<colunas; i++) {
								df.addRow(tabela.elementAt(i));
							}
							
							
						}else {
							//Altera a tela do usuário
							btnEnviarEmail.setVisible(false);
							panel3.setVisible(false);
							panel4.setVisible(false);
							scrollPane5.setVisible(false);
							setBounds(400, 300, 400, 170);
							
							//Mensagem de erro
							JOptionPane.showMessageDialog(btnSearchName, "Nome não encontrado, tente novamente");
						}
						
						sqlCon.encerrarConexao();	
					
					
					
				}
				
			}
		});
		
		
	}
	

}
