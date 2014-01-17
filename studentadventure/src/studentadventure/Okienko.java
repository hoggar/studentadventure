package studentadventure;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;

public class Okienko extends JFrame {

	private JPanel contentPane;
	private JTextField cmdField;
	private JTextArea log;
	private JScrollPane scrollPane;
	private MapaPanel mapa;

	/**
	 * Create the frame.
	 */
	public Okienko() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		mapa = new MapaPanel();
		mapa.setBounds(82, 12, 300, 300);
		contentPane.add(mapa);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(12, 327, 473, 290);
		contentPane.add(scrollPane);
		
		log = new JTextArea();
		scrollPane.setViewportView(log);
		log.setLineWrap(true);
		log.setEditable(false);
		
		cmdField = new JTextField();
		cmdField.setBounds(12, 629, 344, 19);
		contentPane.add(cmdField);
		cmdField.setColumns(10);
		
		JButton cmdBtn = new JButton("Wykonaj");
		cmdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Start.btnOnClick();
			}
		});
		cmdBtn.setBounds(368, 626, 117, 25);
		this.getRootPane().setDefaultButton(cmdBtn);
		contentPane.add(cmdBtn);
		Font logFont = new Font("Verdana", Font.PLAIN, 13);
		log.setFont(logFont);
		setTitle("Student Adventure");
	}
	
	public void pisz(String napis) {
		log.append(napis + "\n");
		cmdField.setText("");
		int dlugoscLoga = log.getText().length();
		log.setCaretPosition(dlugoscLoga);
		//Scrollowanie do dolu loga
		/*
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    }); */
	}
	
	public void czyscCmdField() {
		cmdField.setText("");
	}
	
	public String getCmdFieldText() {
		return cmdField.getText();
	}

}
