import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

public class View extends JFrame{
    private JPanel jPaneloben;
    private JPanel jPanelunten;
    private JPanel jPanelrechts;
    private JButton[] jButtonoben = new JButton[100];
    private JButton[] jButtonunten = new JButton[100];
    private JLabel[] jLabeloben = new JLabel[10]; 
    private JLabel[] jLabelunten = new JLabel[10];
    private JLabel[] jLabelrechts = new JLabel[10];
    private JLabel[] jLabelinks = new JLabel[10];
    private JLabel jLabel;
 
    public View() {
        setSize(new Dimension(1920, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        jPaneloben = new JPanel();
        jPanelunten = new JPanel();
        jPanelrechts = new JPanel();
        
        jPaneloben.setBackground(Color.green);
        jPaneloben.setLayout(new GridLayout(10, 10));
        jPaneloben.setSize(1600, 540);
        jPaneloben.setVisible(true);
        
        jPanelunten.setBackground(Color.red);
        jPanelunten.setLayout(new GridLayout(10, 10));
        jPanelunten.setLocation(0, 540);
        jPanelunten.setSize(1600, 540);
        jPanelunten.setVisible(true);
        
        jPanelrechts.setBackground(Color.yellow);
        jPanelrechts.setLayout(new GridLayout(0, 3));
        jPanelrechts.setLocation(1600, 0);
        jPanelrechts.setSize(320, 1080);
        jPanelrechts.setVisible(true);
        
        
        
        for ( int i = 0; i<100; i++ ) {
            jButtonoben[i] = new JButton ();
            jPaneloben.add ( jButtonoben[i] );
        }        
        
         for ( int i = 0; i<100; i++ ) {
            jButtonunten[i] = new JButton ();
            jPanelunten.add ( jButtonunten[i] );
        }
 
        add(jPaneloben);
        add(jPanelunten);
        add(jPanelrechts);
    }
 
    
}
