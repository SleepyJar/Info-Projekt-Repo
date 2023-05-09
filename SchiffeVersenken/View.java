import javax.swing.*;
import java.awt.Dimension;

public class View extends JFrame{
    private JPanel jPaneloben = new JPanel();
    private JPanel jPanelunten = new JPanel();
    private JPanel jPanelrechts = new JPanel();
 
    
    private JButton[] jButtonoben = new JButton[100];
    private JButton[] jButtonunten = new JButton[100];
    private JLabel[] jLabeloben = new JLabel[10]; 
    private JLabel[] jLabelunten = new JLabel[10];
    private JLabel[] jLabelrechts = new JLabel[10];
    private JLabel[] jLabelinks = new JLabel[10];
    private JLabel jLabel;
    
    public View() {
        setPreferredSize(new Dimension(1920, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        jPaneloben.setLayout( new java.awt.GridLayout( 10, 10 ) );
        jPaneloben.setLocation(0,0);
        jPanelunten.setLayout( new java.awt.GridLayout( 10, 10 ) );
        jPaneloben.setLocation(0,500);
        ButtonListener bl = new ButtonListener();
        jLabel = new JLabel("test");
        jLabel.setBounds(50, 50, 50, 50);
        add(jLabel);
        
        for ( int i = 0; i<100; i++ ) {
            jButtonoben[i] = new JButton ();
            jButtonoben[i].addActionListener ( bl );
            jPaneloben.add ( jButtonoben[i] );
        }
        
        for ( int i = 0; i<100; i++ ) {
            jButtonunten[i] = new JButton ();
            jButtonunten[i].addActionListener ( bl );
            jPanelunten.add ( jButtonunten[i] );
        }
        
        for(int i = 0; i > 10; i++){
            jLabeloben[i] = new JLabel(""+(i + 1));
            jLabeloben[i].setBounds(30* (i + 1), 30, 30, 30);
            jLabeloben[i].setVisible(true);
            add(jLabeloben[i]);
        }
        
        this.getContentPane().add ( jPaneloben ) ;
 
        // Alle Elemente auf kleinstmögliche Größe bringen
        pack();
 
        
    }
 
    
    class ButtonListener implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {
 

            for (int i=0; i<169; i++) {
                if( e.getSource() == jButtonoben[i] ){
                    System.out.println("JButton" + (i+1) + " wurde geklickt.");
                }
            }
        }
    }
 
    
}
