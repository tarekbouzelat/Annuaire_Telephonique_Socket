package graphique;

import java.net.*;
import java.io.*;
import javax.swing.*;



	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.util.Objects;

	public class RechercheNom extends JFrame {
	    private JPanel panel = new JPanel();

	    //Labels
	    private JLabel nom = new JLabel("Entrer nom : ");
	    private JLabel numero = new JLabel("numero de cette personne : ");

	    //TextFields
	    private JTextField nomTextField = new JTextField(20);
	    private JTextField numeroTextField = new JTextField(20);
	   
	    private JPanel buttons = new JPanel();
	    private JButton Recherche = new JButton("Recherche");
	    private JButton close = new JButton("Close");
	    


	    public RechercheNom() {

	        //Frame
	        setSize(300, 500);
	        setResizable(false);
	        setLocationRelativeTo(null);
	        setTitle("Recherche Par Nom");

	        numeroTextField.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char cKey = e.getKeyChar();
	                if (((cKey < '0') || (cKey > '9')) && (cKey != KeyEvent.VK_BACK_SPACE)) {
	                    e.consume();
	                }
	            }
	        });


	        //Button
	        Recherche.addActionListener(new RechercheAction());
	        close.addActionListener(new CloseAction());

	        //Panel
	        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
	        panel.setLayout(new GridLayout(10, 1));

	        panel.add(nom);
	        panel.add(nomTextField);

	        panel.add(numero);
	        panel.add(numeroTextField);

	        numeroTextField.setEnabled(false);

	        buttons.setLayout(new GridLayout(2, 1));
	        buttons.setSize(new Dimension(500, 70));
	        buttons.add(Recherche);
	        buttons.add(close);

	        panel.add(buttons);

	        this.add(panel, BorderLayout.CENTER);
	        this.toFront();
	        this.requestFocus();
	        this.setVisible(true);

	    }

	    //Buttons OnClick
	    //RECHERCHE
	    private class RechercheAction extends AbstractAction {
	        public void actionPerformed(ActionEvent e) {
	        	try { 
	        		Socket s = new Socket("localhost",3330);
	        		BufferedReader in = new BufferedReader( new InputStreamReader(s.getInputStream()));
	        		PrintWriter out = new PrintWriter( s.getOutputStream(),true);
	        		
	        		out.println(nomTextField.getText()); 	        	
	        		numeroTextField.setText(in.readLine());
	        		
	        		s.close();
	        		} catch (Exception ex) {
	        			System.out.println(ex);
	        		}
	        	}
	        }
	    

	    private class CloseAction extends AbstractAction {
	        public void actionPerformed(ActionEvent e) {
	            setVisible(false);
	        }
	    }
	}


