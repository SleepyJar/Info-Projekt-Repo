import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

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
    private Spiel spiel;

    public View(Spiel spiel) {
        this.spiel = spiel;
        setSize(new Dimension(1600, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        jPaneloben = new JPanel();
        jPanelunten = new JPanel();
        jPanelrechts = new JPanel();
        
        addMouseListener(new MouseAdapter() {
     @Override
     public void mouseClicked(MouseEvent me) {
         if (SwingUtilities.isRightMouseButton(me) || me.isControlDown()){
        spiel.baurichtungAendern();
        System.out.println("rightclicked");
    }
     }
  });

        jPaneloben.setBackground(Color.green);
        jPaneloben.setLayout(new GridLayout(11, 11));
        jPaneloben.setSize(1200, 515);
        jPaneloben.setVisible(true);

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

        jPaneloben.setBorder(BorderFactory.createEmptyBorder(0, 50, 0,100));
        jPanelunten.setBorder(BorderFactory.createEmptyBorder(0, 50, 0,100));

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

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 100; i++){
            if (e.getSource() == jButtonoben[i]){
                int x = i % 10;
                int y = i / 10;
                System.out.println("Feld oben: " + x + "," + y);
                spiel.click(x, y);
            }
            else if(e.getSource() == jButtonunten[i]){
                int x = i % 10;
                int y = i /10;
                System.out.println("Feld unten: " + x + "," +y);
            }
        }
    }
}

