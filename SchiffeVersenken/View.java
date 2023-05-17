import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener{
    private JPanel jPaneloben;
    private JPanel jPanelunten;
    private JPanel jPanelrechts;
    private JButton[] jButtonoben = new JButton[100];
    private JButton[] jButtonunten = new JButton[100];
    private JLabel[] jLabelobenEigenes = new JLabel[10];
    private JLabel[] jLabelobenGegner = new JLabel[10];
    private JLabel[] jLabelseiteEigenes = new JLabel[10];
    private JLabel[] jLabelseiteGegner = new JLabel[10];
    private Feld feld;

 
    public View() {
        setSize(new Dimension(1920, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        feld = new Feld();
        
        jPaneloben = new JPanel();
        jPanelunten = new JPanel();
        jPanelrechts = new JPanel();
        
        jPaneloben.setBackground(Color.green);
        jPaneloben.setLayout(new GridLayout(12, 12));
        jPaneloben.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 130));
        jPaneloben.setSize(1600, 540);
        jPaneloben.setVisible(true);
        
        jPanelunten.setBackground(Color.red);
        jPanelunten.setLayout(new GridLayout(12, 12));
        jPanelunten.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 130));
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
        }
        
        jPaneloben.add(new JLabel());
        for (int j = 0; j < 10; j++){
            jPaneloben.add(jLabelobenEigenes[j]);
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 11; j++){
                if (j == 0){
                    jPaneloben.add(new JLabel("A", SwingConstants.CENTER));
                }
                else{
                    jButtonoben[10*i+j-1] = new JButton();
                    jButtonoben[10*i+j-1].addActionListener(this);
                    jPaneloben.add(jButtonoben[10*i+j-1]);
                    
                }
            }
        }
        
        jPanelunten.add(new JLabel());
        for (int j = 0; j < 10; j++){
            jPanelunten.add(jLabelobenGegner[j]);
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 11; j++){
                if (j == 0){
                    jPanelunten.add(new JLabel("A", SwingConstants.CENTER));
                }
                else{
                    jButtonunten[10*i+j-1] = new JButton();
                    jButtonunten[10*i+j-1].addActionListener(this);
                    jPanelunten.add(jButtonunten[10*i+j-1]);
                    
                }
            }
        }
 
        add(jPaneloben);
        add(jPanelunten);
        add(jPanelrechts);
    }
 
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 100; i++){
            if (e.getSource() == jButtonoben[i]){
                int x = i % 10;
                int y = i / 10;
                System.out.println(x + "," + y);
                if(feld.trefferEigenesFeld(x, y) == 3){
                    jButtonoben[i].setText("X");
                }
                else if(feld.trefferEigenesFeld(x, y) == 1){
                    jButtonoben[i].setText("O");
                }
                else {
                    jButtonoben[i].setText("-");
                }
            }
        }
    }
}

    

