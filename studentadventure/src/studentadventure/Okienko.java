package studentadventure;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Okienko extends JFrame {

	private JPanel contentPane;
	private JTextField cmdField;
	private JTextPane log;
	private JScrollPane scrollPane;
	public JPanel mapa;

	private Font mainFont, dialogFont, descFont;
	private StyledDocument doc;
	private Style style;
	private static final int MAP_SIZE = 10;
	private static final int TILE_SIZE = 30;

	/**
	 * Create the frame.
	 */
	public Okienko() {
		mainFont = new Font("Verdana", Font.PLAIN, 13);
		dialogFont = new Font("Verdana", Font.ITALIC, 13);

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
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(12, 327, 473, 290);
		contentPane.add(scrollPane);

		log = new JTextPane();
		doc = log.getStyledDocument();
		style = log.addStyle("Styl gry", null);
		scrollPane.setViewportView(log);

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

		log.setFont(mainFont);
		setTitle("Student Adventure");
	}
	
	public void setFightPanel() {
		mapa = new walkaPanel();
	}
	
	public void setMapaPanel() {
		mapa = new MapaPanel();
	}

	public void pisz(String napis) {
		StyleConstants.setForeground(style, Color.BLACK);
		try {
			doc.insertString(doc.getLength(), napis + "\n", style);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
		}
		czyscCmdField();
		przesunLog();
	}

	public void piszDialogi(String napis) {
		StyleConstants.setForeground(style, Color.BLUE);
		try {
			doc.insertString(doc.getLength(), napis + "\n", style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		czyscCmdField();
		przesunLog();
	}

	public void piszReszta(String napis) {
		StyleConstants.setForeground(style, Color.GRAY);
		try {
			// doc.insertString(doc.getLength(), "\n", style);
			doc.insertString(doc.getLength(), napis + "\n", style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		czyscCmdField();
		przesunLog();
	}

	public void piszBlad(String napis) {
		StyleConstants.setForeground(style, Color.RED);
		try {
			doc.insertString(doc.getLength(), napis + "\n", style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		czyscCmdField();
		przesunLog();
	}

	private void przesunLog() {
		int dlugoscPola = log.getDocument().getLength();
		log.setCaretPosition(dlugoscPola);
	}
	
	public void czyscLog() {
		log.setText("");
	}

	public void czyscCmdField() {
		cmdField.setText("");
	}

	public String getCmdFieldText() {
		return cmdField.getText();
	}
	
}
