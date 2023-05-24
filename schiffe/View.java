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
    private JLabel[] jLabelSeiteEigenes = new JLabel[10];
    private JLabel[] jLabelSeiteGegner  = new JLabel[10];

    private JLabel jLabel;
    private Feld feld;

    public View() {
        setSize(new Dimension(1600, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        feld = new Feld();

        jPaneloben = new JPanel();
        jPanelunten = new JPanel();
        jPanelrechts = new JPanel();

        jPaneloben.setBackground(Color.green);
        jPaneloben.setLayout(new GridLayout(11, 11));
        jPaneloben.setSize(1200, 515 );
        jPaneloben.setVisible(true);

        //noch zu tun!!
        // jPaneloben.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,200));
        // jPanelunten.setBorder(BorderFactory.createEmptyBorder(0,0,0,200));

        jPanelunten.setBackground(Color.red);
        jPanelunten.setLayout(new GridLayout(11, 11));
        jPanelunten.setLocation(0, 540);
        jPanelunten.setSize(1200, 515);
        jPanelunten.setVisible(true);

        jPanelrechts.setBackground(Color.yellow);
        jPanelrechts.setLayout(new GridLayout(0, 3));
        jPanelrechts.setLocation(1200, 0);
        jPanelrechts.setSize(400, 1080);
        jPanelrechts.setVisible(true);

        for ( int i = 0; i < 10; i++){
            jLabelobenEigenes[i] = new JLabel(""+(i+1));
            jLabelobenEigenes[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelobenGegner[i] = new JLabel(""+(i+1));
            jLabelobenGegner[i].setHorizontalAlignment(SwingConstants.CENTER);

        }

        jPaneloben.add(new JLabel());
        jPanelunten.add(new JLabel());
        for (int j = 0; j < 10; j++){
            jPaneloben.add(jLabelobenEigenes[j]);
            jPanelunten.add(jLabelobenGegner[j]);

        }

        for ( int i = 0; i<10; i++ ) {

            for (int j = 0; j < 11; j++){
                if (j == 0){
                    char zahl=(char)(65+i);
                    jPaneloben.add (new JLabel(Character.toString(zahl),SwingConstants.CENTER));
                    jPanelunten.add (new JLabel(Character.toString(zahl), SwingConstants.CENTER));
                } else{ 

                    jButtonoben[10*i+j-1] = new JButton ();
                    jPaneloben.add ( jButtonoben[10*i+j-1] );
                    jButtonoben[10*i+j-1].addActionListener(this);
                    

                    jButtonunten[10*i+j-1] = new JButton();
                    jPanelunten.add (jButtonunten[10*i+j-1]);
                    jButtonunten[10*i+j-1].addActionListener(this);
                }
            }        

            

            add(jPaneloben);
            add(jPanelunten);
            add(jPanelrechts);
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        for (int i= 0; i< 100; i++)
        {
            if ( e.getSource() == jButtonoben[i]){
                int x = i % 10;
                int y = i /10;
                System.out.println(x + "," +y);
                // if(feld.trefferEigenesFeld(x, y) == 3) {
                    // jButtonoben[i].setText("X");
                // }

                // else if (feld.trefferEigenesFeld(x,y) == 1){
                    // jButtonoben[i].setText("0");
                // }
                // else {
                    // jButtonoben[i].setText("-");
                // }
            }
            
            if ( e.getSource() == jButtonunten[i]){
                int x = i % 10;
                int y = i /10;
                System.out.println(x + "," +y);
            }
        }

    }
}

