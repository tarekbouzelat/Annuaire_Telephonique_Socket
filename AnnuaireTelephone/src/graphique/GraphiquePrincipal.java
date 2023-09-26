package graphique;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import ConnBDD.ModeleAnnuaire;




public class GraphiquePrincipal extends JFrame {
		public static ModeleAnnuaire modele = new ModeleAnnuaire();
	    
		private JPanel panel = new JPanel();
		private JButton  AnnuaireComplet = new JButton();
	    private JButton RechercheparNom = new JButton();

	    JPanel boutons = new JPanel();

		public GraphiquePrincipal() {
		super();
		setSize(400, 500);
	    setResizable(true);
	    setLocationRelativeTo(null); 
	    setTitle("Menu");
        //Panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panel.setLayout(new GridLayout(4, 1));
      //Button
        boutons.add(new JButton(new AddAction1()));
		boutons.add(new JButton(new AddAction2()));
        boutons.setLayout(new GridLayout(2, 1));
        boutons.setSize(new Dimension(400, 70));
        panel.add(boutons);
        this.add(panel, BorderLayout.CENTER);
        this.toFront();
        this.requestFocus();
        this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		}
		public static void main(String[] args) {
		new GraphiquePrincipal().setVisible(true);
		}

		private class AddAction1 extends AbstractAction {
		    private AddAction1() {
		        super("Annuaire Complet"); 
		    }
		    
		    public void actionPerformed(ActionEvent e) {
		       new FrameTelephone();
		       
		}
		}
		private class AddAction2 extends AbstractAction {
		    private AddAction2() {
		        super("Recherche par Nom"); 
		    }
		    
		    public void actionPerformed(ActionEvent e) {
		       new RechercheNom();
		}
		}
}


