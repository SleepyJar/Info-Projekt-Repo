import javax.swing.*;
import java.awt.Dimension;

public class View extends JFrame{
     private JPanel jPanel1 = new JPanel();
 
    
    private JButton[] jButton = new JButton[100];
    private JLabel[] jLabeloben = new JLabel[10]; 
    private JLabel[] jLabelunten = new JLabel[10];
    private JLabel[] jLabelrechts = new JLabel[10];
    private JLabel[] jLabelinks = new JLabel[10];
    
    public View() {
        setPreferredSize(new Dimension(1920, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout( new java.awt.GridLayout( 10, 10 ) );
        jPanel1.setBorder(BorderFactory.createEmptyBorder(70, 70, 70, 70));
        ButtonListener bl = new ButtonListener();
        
        for ( int i = 0; i<100; i++ ) {
            jButton[i] = new JButton ();
            jButton[i].addActionListener ( bl );
            jPanel1.add ( jButton[i] );
        }
        
        for(int i = 0; i > 10; i++){
            
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
