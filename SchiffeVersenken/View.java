import javax.swing.*;
import java.awt.Dimension;

public class View extends JFrame{
     private javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
 
    
    private javax.swing.JButton[] jButton = new javax.swing.JButton[169];
 
    
    public View() {
        setPreferredSize(new Dimension(1920, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout( new java.awt.GridLayout( 13, 13 ) );
        ButtonListener bl = new ButtonListener();
        
        for ( int i = 0; i<169; i++ ) {
            jButton[i] = new javax.swing.JButton ( "JButton" + (i+1) );
            jButton[i].addActionListener ( bl );
            jPanel1.add ( jButton[i] );
        }
 
        
        this.getContentPane().add ( jPanel1 ) ;
 
        // Alle Elemente auf kleinstmögliche Größe bringen
        pack();
 
        
    }
 
    
    class ButtonListener implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {
 

            for (int i=0; i<169; i++) {
                if( e.getSource() == jButton[i] ){
                    System.out.println("JButton" + (i+1) + " wurde geklickt.");
                }
            }
        }
    }
 
    
}
