import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

public class View extends JFrame{
    private JPanel jPaneloben;
    private JPanel jPanelunten;
    private JPanel jPanelrechts;
    private JButton[] jButtonoben = new JButton[100];
    private JButton[] jButtonunten = new JButton[100];
    private JLabel[] jLabelobenEigenes = new JLabel[10];
    private JLabel[] jLabelobenGegner = new JLabel[10];
    private JLabel[] jLabelunten = new JLabel[10];
    private JLabel[] jLabelrechts = new JLabel[10];
    private JLabel[] jLabellinks = new JLabel[10];
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
        jPaneloben.setLayout(new GridLayout(12, 12));
        jPaneloben.setSize(1600, 540);
        jPaneloben.setVisible(true);
        
        jPanelunten.setBackground(Color.red);
        jPanelunten.setLayout(new GridLayout(12, 12));
        jPanelunten.setLocation(0, 540);
        jPanelunten.setSize(1600, 540);
        jPanelunten.setVisible(true);
        
        jPanelrechts.setBackground(Color.yellow);
        jPanelrechts.setLayout(new GridLayout(0, 3));
        jPanelrechts.setLocation(1600, 0);
        jPanelrechts.setSize(320, 1080);
        jPanelrechts.setVisible(true);
        
        for ( int i = 0; i < 10; i++){
            jLabelobenEigenes[i] = new JLabel(""+(i+1));
            jLabelobenEigenes[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelobenGegner[i] = new JLabel(""+(i+1));
            jLabelobenGegner[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelunten[i] = new JLabel("                "+(i+1));
            jLabellinks[i] = new JLabel();
            jLabelrechts[i] = new JLabel();
        }
        
        for ( int i = 0; i<100; i++ ) {
            if (i == 0){
                for (int j = 0; j < 10; j++){
                    jPaneloben.add(jLabelobenEigenes[j]);
                }
            }
            jButtonoben[i] = new JButton ();
            jPaneloben.add ( jButtonoben[i] );
        }        
        
         for ( int i = 0; i<100; i++ ) {
             if (i == 0){
                for (int j = 0; j < 10; j++){
                    jPanelunten.add(jLabelobenGegner[j]);
                }
            }
            jButtonunten[i] = new JButton ();
            jPanelunten.add ( jButtonunten[i] );
        }
 
        add(jPaneloben);
        add(jPanelunten);
        add(jPanelrechts);
    }
 
    
}

    
}
