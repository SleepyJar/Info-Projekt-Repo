import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

public class View extends JFrame implements ActionListener, MouseListener{
    private Spiel spiel;

    //alles auf den Feldern
    private JPanel jPanellinks;
    private JPanel jPanelrechts;
    private JButton[] jButtonlinks = new JButton[100];
    private JButton[] jButtonrechts = new JButton[100];
    private JLabel[] jLabelobenEigenes = new JLabel[10];
    private JLabel[] jLabelobenGegner = new JLabel[10];
    private JLabel[] jLabelSeiteEigenes = new JLabel[10];
    private JLabel[] jLabelSeiteGegner  = new JLabel[10];

    //alles auf der Subleiste
    private JPanel jPanelunten;
    private JLabel zugLabel;
    private JLabel modusLabel;
    private JLabel richtungLabel;
    private JButton wechselButton;

    public View(Spiel spiel) {
        this.spiel = spiel;
        setSize(new Dimension(1600, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        this.addMouseListener(this);

        jPanellinks = new JPanel();
        jPanelunten = new JPanel();
        jPanelrechts = new JPanel();

        jPanellinks.setBackground(Color.green);
        jPanellinks.setLayout(new GridLayout(11, 11));
        jPanellinks.setSize(800, 800);
        jPanellinks.setVisible(true);

        jPanelrechts.setBackground(Color.red);
        jPanelrechts.setLayout(new GridLayout(11, 11));
        jPanelrechts.setLocation(800, 0);
        jPanelrechts.setSize(800, 800);
        jPanelrechts.setVisible(true);

        jPanelunten.setBackground(Color.yellow);
        jPanelunten.setLayout(new GridLayout(1, 4));
        jPanelunten.setLocation(0, 800);
        jPanelunten.setSize(1600, 200);
        jPanelunten.setVisible(true);

        jPanellinks.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,0));
        jPanelrechts.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        for ( int i = 0; i < 10; i++){
            jLabelobenEigenes[i] = new JLabel(""+(i+1));
            jLabelobenEigenes[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelobenGegner[i] = new JLabel(""+(i+1));
            jLabelobenGegner[i].setHorizontalAlignment(SwingConstants.CENTER);

        }

        jPanellinks.add(new JLabel());
        jPanelrechts.add(new JLabel());
        for (int j = 0; j < 10; j++){
            jPanellinks.add(jLabelobenEigenes[j]);
            jPanelrechts.add(jLabelobenGegner[j]);

        }

        for ( int i = 0; i<10; i++ ) {

            for (int j = 0; j < 11; j++){
                if (j == 0){
                    char zahl=(char)(65+i);
                    jPanellinks.add (new JLabel(Character.toString(zahl),SwingConstants.CENTER));
                    jPanelrechts.add (new JLabel(Character.toString(zahl), SwingConstants.CENTER));
                } else{ 

                    jButtonlinks[10*i+j-1] = new JButton ();
                    jPanellinks.add ( jButtonlinks[10*i+j-1] );
                    jButtonlinks[10*i+j-1].addActionListener(this);
                    jButtonlinks[10*i+j-1].addMouseListener(this);

                    jButtonrechts[10*i+j-1] = new JButton();
                    jPanelrechts.add (jButtonrechts[10*i+j-1]);
                    jButtonrechts[10*i+j-1].addActionListener(this);
                    jButtonrechts[10*i+j-1].addMouseListener(this);
                }
            }        
        }
        //Seitleiste
        zugLabel = new JLabel("Zug: Spieler" + (spiel.getaktuellerSpieler() + 1), SwingConstants.CENTER);
        zugLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jPanelunten.add(zugLabel);

        modusLabel = new JLabel("Modus: " + spiel.spielzustandGeben(), SwingConstants.CENTER);
        modusLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jPanelunten.add(modusLabel);

        richtungLabel = new JLabel("Richtung: " + spiel.baurichtungGeben(), SwingConstants.CENTER);
        richtungLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jPanelunten.add(richtungLabel);

        wechselButton = new JButton("Sichtwechsel");
        wechselButton.setEnabled(false);
        jPanelunten.add(wechselButton);

        add(jPanellinks);
        add(jPanelunten);
        add(jPanelrechts);
        
        
    }

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 100; i++){
            if (e.getSource() == jButtonlinks[i]){
                int x = i % 10;
                int y = i / 10;
                System.out.println("Feld links: " + x + "," + y);
                spiel.click(x, y);

            }
            else if(e.getSource() == jButtonrechts[i]){
                int x = i % 10;
                int y = i /10;
                System.out.println("Feld rechts: " + x + "," +y);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseClicked(MouseEvent me) {
        if (SwingUtilities.isRightMouseButton(me) || me.isControlDown()){
            spiel.baurichtungAendern();
            richtungLabel.setText("Richtung: " + spiel.baurichtungGeben());
        }
    }
}


