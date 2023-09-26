package graphique;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ConnBDD.ModeleAnnuaire;



public class FrameTelephone extends JFrame {
public static ModeleAnnuaire modele = new ModeleAnnuaire();
private JTable tableau;






public FrameTelephone() {
super();
setTitle("Personne");

tableau = new JTable(modele);
tableau.setAutoCreateRowSorter(true);
getContentPane().add(new JScrollPane(tableau), BorderLayout.NORTH);
JPanel boutons = new JPanel();
boutons.add(new JButton(new AddAction()));
boutons.add(new JButton(new RemoveAction()));
getContentPane().add(boutons, BorderLayout.SOUTH);


//JPanel p = new JPanel();
//getContentPane().add(text, new GridLayout(5,2));

//p.add(text);
//getContentPane().add(text, BorderLayout.CENTER);


this.setVisible(true);

pack();
}
//public static void main(String[] args) {
//new FrameTelephone().setVisible(true);
//}

private class AddAction extends AbstractAction {
    private AddAction() {
        super("Ajouter"); 
    }
    
    public void actionPerformed(ActionEvent e) {
       new AddNumTel(modele);
}
}
private class RemoveAction extends AbstractAction {
    private RemoveAction() {
        super("Supprimmer");
    }
    public void actionPerformed(ActionEvent e) {
        int[] selection = tableau.getSelectedRows();
        for(int i = selection.length-1; i>=0;i--)
            try { 
                 modele.removePersonne(selection[i]+1);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);          
                }  
}

}
}