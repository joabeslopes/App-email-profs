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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.Connection;
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

public class Main2 extends JFrame {

	private JPanel Principal;
	private JTextField textName;
	private JTable tabelaInfoProfs;
	private String email;
	private String selecaoEmail;
	private int selecaoLinha;
	private  Connection conectado = null;
	
	
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
		setBounds(500, 300, 400, 170);
		Principal = new JPanel();
		Principal.setBackground(new Color(26, 95, 180));
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Principal);
		
		
		JPanel painelEmail = new JPanel();
		painelEmail.setBackground(new Color(26, 95, 180));
		painelEmail.setVisible(false);
		
		
		JPanel outrasInfos = new JPanel();
		outrasInfos.setVisible(false);
		
		
		JPanel painelPesquisa = new JPanel();
		FlowLayout fl_painelPesquisa = (FlowLayout) painelPesquisa.getLayout();
		fl_painelPesquisa.setHgap(50);
		painelPesquisa.setBackground(new Color(26, 95, 180));
		
		
		JScrollPane infoProfs = new JScrollPane();
		infoProfs.setVisible(false);
		
		
		JPanel painelNome = new JPanel();
		painelNome.setBackground(new Color(26, 95, 180));
		
		
		GroupLayout gl_Principal = new GroupLayout(Principal);
		gl_Principal.setHorizontalGroup(
			gl_Principal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Principal.createSequentialGroup()
					.addGroup(gl_Principal.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(painelNome, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(infoProfs, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(outrasInfos, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(painelEmail, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
						.addGroup(gl_Principal.createSequentialGroup()
							.addContainerGap()
							.addComponent(painelPesquisa, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_Principal.setVerticalGroup(
			gl_Principal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Principal.createSequentialGroup()
					.addContainerGap()
					.addComponent(painelNome, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(painelPesquisa, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(painelEmail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(outrasInfos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(infoProfs, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
		);
		
		
		tabelaInfoProfs = new JTable();
		tabelaInfoProfs.setModel(new DefaultTableModel(
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
		tabelaInfoProfs.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaInfoProfs.getColumnModel().getColumn(0).setMinWidth(20);
		tabelaInfoProfs.getColumnModel().getColumn(1).setPreferredWidth(90);
		tabelaInfoProfs.getColumnModel().getColumn(1).setMinWidth(20);
		tabelaInfoProfs.getColumnModel().getColumn(2).setPreferredWidth(130);
		tabelaInfoProfs.getColumnModel().getColumn(2).setMinWidth(20);
		tabelaInfoProfs.getColumnModel().getColumn(3).setMinWidth(20);
		tabelaInfoProfs.getColumnModel().getColumn(4).setPreferredWidth(90);
		tabelaInfoProfs.getColumnModel().getColumn(4).setMinWidth(20);
		tabelaInfoProfs.getColumnModel().getColumn(5).setMinWidth(0);
		tabelaInfoProfs.getColumnModel().getColumn(5).setMaxWidth(0);
		infoProfs.setViewportView(tabelaInfoProfs);
		
		
		
		JLabel lblNewLabel = new JLabel("Digite o primeiro nome do professor: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		
		
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setColumns(10);
		
		
		
		GroupLayout gl_painelNome = new GroupLayout(painelNome);
		gl_painelNome.setHorizontalGroup(
			gl_painelNome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelNome.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(Alignment.TRAILING, gl_painelNome.createSequentialGroup()
					.addGap(86)
					.addComponent(textName, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addGap(87))
		);
		gl_painelNome.setVerticalGroup(
			gl_painelNome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelNome.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		painelNome.setLayout(gl_painelNome);
		
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
	
		
		JTextArea textEmail = new JTextArea();
		textEmail.setEditable(false);
		textEmail.setText(null);
		
		
		GroupLayout gl_painelEmail = new GroupLayout(painelEmail);
		gl_painelEmail.setHorizontalGroup(
			gl_painelEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelEmail.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
		);
		gl_painelEmail.setVerticalGroup(
			gl_painelEmail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelEmail.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelEmail.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		painelEmail.setLayout(gl_painelEmail);
		
		
		outrasInfos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel lblOutrasInformaes = new JLabel("Outras informações");
		lblOutrasInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutrasInformaes.setFont(new Font("Dialog", Font.BOLD, 11));
		outrasInfos.add(lblOutrasInformaes);
		Principal.setLayout(gl_Principal);
		
		
		
		JButton btnSearchName = new JButton("Pesquisar nome");
		painelPesquisa.add(btnSearchName);
		
		
		
		JButton btnEnviarEmail = new JButton("Enviar email");
		painelPesquisa.add(btnEnviarEmail);
		btnEnviarEmail.setVisible(false);
		

		
		
		
		// Ações do botão de pesquisa, que serão as mesmas se o usuário pressionar Enter
		
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Limpa a tela
				DefaultTableModel df = (DefaultTableModel) tabelaInfoProfs.getModel();
				df.setRowCount(0);
				textEmail.setText(null);
				
				//tenta se conectar, caso seja a primeira vez
				if (conectado == null) {
					conectado = sqlCon.criarConexao();
				} 
				
				// se já estiver conectado
				if(conectado != null) {
				
					
				// Pesquisa o email do prof	
				String name = textName.getText();
				email = sqlCon.pesquisaEmail(name);
				
				//se ele achar o email
				if (email != null) {
					
					
					//Altera a tela do usuário
					setBounds(500, 300, 500, 370);
					btnEnviarEmail.setVisible(true);
					painelEmail.setVisible(true);
					outrasInfos.setVisible(true);
					infoProfs.setVisible(true);
					
					
					//mostra o primeiro email encontrado
					textEmail.setText(email);
					
					
					// Preenche a tabela com outras informações coletadas
					Vector<Vector<String>> tabela = sqlCon.outrasInfos(name);
					int colunas = sqlCon.colunas;
					for (int i=0; i<colunas; i++) {
						df.addRow(tabela.elementAt(i));
					}
					
					
				}else {
					//Altera novamente a tela do usuário, caso ele ja tenha pesquisado outro nome
					btnEnviarEmail.setVisible(false);
					painelEmail.setVisible(false);
					outrasInfos.setVisible(false);
					infoProfs.setVisible(false);
					setBounds(500, 300, 400, 170);
					
					//Mensagem de erro
					JOptionPane.showMessageDialog(btnSearchName, "Nome não encontrado, tente novamente");
				}

			} else {
				JOptionPane.showMessageDialog(btnSearchName, "Conexão com servidor falhou, tente novamente");
			}
				
		}
			
	});
		
		
		//Açoes do botao de enviar email
		
		btnEnviarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				   
					try {
				    	
						// Copia o email selecionado da tabela para a área de transferência
				    	selecaoEmail = textEmail.getText();
				    	StringSelection selection = new StringSelection(selecaoEmail);
							
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(selection, selection);

							JOptionPane.showMessageDialog(btnSearchName, "Email copiado para a área de transferência !");
						
						//Desktop.getDesktop().browse(new URI("https://serverjoabe.xyz:8090/snappymail/"));
						Desktop.getDesktop().browse(new URI("https://outlook.office.com"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		
		
		
		// Reconhece a linha da tabela que o usuário clica, e coloca o email do professor selecionado na tela
		
		tabelaInfoProfs.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					selecaoLinha = tabelaInfoProfs.getSelectedRow();
					if (selecaoLinha !=-1) {
					textEmail.setText(tabelaInfoProfs.getValueAt(selecaoLinha, 5).toString());
					}
			}
		});

		
		
		
		// Ações ao pressionar Enter, que serão as mesmas do botão de pesquisa
		
		textName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					
					
					//Limpa a tela
					DefaultTableModel df = (DefaultTableModel) tabelaInfoProfs.getModel();
					df.setRowCount(0);
					textEmail.setText(null);
					
					//tenta se conectar, caso seja a primeira vez
					if (conectado == null) {
						conectado = sqlCon.criarConexao();
					} 
					
					// se já estiver conectado
					if(conectado != null) {
					
						
					// Pesquisa o email do prof	
					String name = textName.getText();
					email = sqlCon.pesquisaEmail(name);
					
					//se ele achar o email
					if (email != null) {
						
						
						//Altera a tela do usuário
						setBounds(500, 300, 500, 370);
						btnEnviarEmail.setVisible(true);
						painelEmail.setVisible(true);
						outrasInfos.setVisible(true);
						infoProfs.setVisible(true);
						
						
						//mostra o primeiro email encontrado
						textEmail.setText(email);
						
						
						// Preenche a tabela com outras informações coletadas
						Vector<Vector<String>> tabela = sqlCon.outrasInfos(name);
						int colunas = sqlCon.colunas;
						for (int i=0; i<colunas; i++) {
							df.addRow(tabela.elementAt(i));
						}
						
						
					}else {
						//Altera novamente a tela do usuário, caso ele ja tenha pesquisado outro nome
						btnEnviarEmail.setVisible(false);
						painelEmail.setVisible(false);
						outrasInfos.setVisible(false);
						infoProfs.setVisible(false);
						setBounds(500, 300, 400, 170);
						
						//Mensagem de erro
						JOptionPane.showMessageDialog(btnSearchName, "Nome não encontrado, tente novamente");
					}

				} else {
					JOptionPane.showMessageDialog(btnSearchName, "Conexão com servidor falhou, tente novamente");
				}
					
					
					
				}
				
			}
		});
		
		
	}
	

}
