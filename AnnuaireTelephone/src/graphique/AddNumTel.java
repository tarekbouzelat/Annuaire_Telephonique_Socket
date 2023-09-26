package graphique;

import javax.swing.*;
import ConnBDD.AnnuairePersonne;
import ConnBDD.ModeleAnnuaire;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class AddNumTel extends JFrame {
    private JPanel panel = new JPanel();
    ModeleAnnuaire table;
    //Labels
    private JLabel nom = new JLabel("Enter nom ");
    private JLabel numero = new JLabel("Enter numero ");

    //TextFields
    private JTextField nomTextField = new JTextField(20);
    private JTextField numeroTextField = new JTextField(20);
   
    private JPanel buttons = new JPanel();
    private JButton Ajouter = new JButton("Ajouter");
    private JButton Fermer = new JButton("Fermer");
    private ModeleAnnuaire AnnuaireTable = new ModeleAnnuaire();

    public AddNumTel(ModeleAnnuaire table) {
    	this.table=table;
        //Frame
        setSize(300, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Add NumeroTel Form");

        numeroTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char cKey = e.getKeyChar();
                if (((cKey < '0') || (cKey > '9')) && (cKey != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });


        //Button
        Ajouter.addActionListener(new AjouterAction());
        Fermer.addActionListener(new FermerAction());

        //Panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panel.setLayout(new GridLayout(11, 1));

        panel.add(nom);
        panel.add(nomTextField);

        panel.add(numero);
        panel.add(numeroTextField);

     

        buttons.setLayout(new GridLayout(1, 2, 10, 20));
        buttons.setSize(new Dimension(400, 80));
        buttons.add(Ajouter);
        buttons.add(Fermer);

        panel.add(buttons);

        this.add(panel, BorderLayout.CENTER);
        this.toFront();
        this.requestFocus();
        this.setVisible(true);

    }

    //Buttons OnClick
    private class AjouterAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
        	if(e.getSource()== Ajouter) {
        		
        	String nom1 = nomTextField.getText().toString();
            String numero1 = numeroTextField.getText().toString();
          
            
if (!Objects.equals(nomTextField.getText(), "") && !Objects.equals(numeroTextField.getText(), "")) {
                
            	AnnuairePersonne pers = new AnnuairePersonne(nom1,numero1);
                table.addPersonne(pers);
                nomTextField.setText("");
                numeroTextField.setText("");
                
            	
            	
            } else {
                JOptionPane.showMessageDialog(null, "SVP remplissez tout les champs", "Information: " + "Erreur", JOptionPane.INFORMATION_MESSAGE);
            }
            
        	}
        	
            
        }
    }

    private class FermerAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}
