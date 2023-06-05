import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

public class View extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    private Spiel spiel;

    //alles auf den Feldern
    private JPanel jpanelLinks;
    private JPanel jpanelRechts;
    private JButton[] jButtonlinks = new JButton[100];
    private JButton[] jButtonrechts = new JButton[100];
    private JLabel[] jLabelobenEigenes = new JLabel[10];
    private JLabel[] jLabelobenGegner = new JLabel[10];
    private JLabel[] jLabelSeiteEigenes = new JLabel[10];
    private JLabel[] jLabelSeiteGegner  = new JLabel[10];

    //alles auf der Subleiste
    private JPanel jpanelUnten;
    private JLabel zugLabel;
    private JLabel modusLabel;
    private JLabel richtungLabel;
    private JButton wechselButton;
    
    private JLabel fehlerLabel;

    //Schiffe
    private JLabel label;
    private ImageIcon schiff2Vertikal;
    private ImageIcon schiff2Horizontal;
    
    //Feldzustaende
    private String schiff = "O";

    public View(Spiel spiel) {
        schiff2Horizontal = new ImageIcon("Schiff2Horizontal.png");
        schiff2Vertikal = new ImageIcon("Schiff2Vertikal.png");
        label = new JLabel();
        label.setIcon(schiff2Vertikal);
        Dimension size = label.getPreferredSize();
        
        this.spiel = spiel;
        setSize(new Dimension(1600, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        fehlerLabel = new JLabel("fehler");
        fehlerLabel.setForeground(Color.RED);
        fehlerLabel.setFont(new Font("Serif", Font.PLAIN, 49));
        fehlerLabel.setBounds(700, 400, 200, 50);        

        add(label);

        jpanelLinks = new JPanel();
        jpanelUnten = new JPanel();
        jpanelRechts = new JPanel();
        
        jpanelLinks.setLayout(new GridLayout(11, 11));
        jpanelLinks.setSize(800, 800);
        jpanelLinks.setVisible(true);

        jpanelRechts.setLayout(new GridLayout(11, 11));
        jpanelRechts.setLocation(800, 0);
        jpanelRechts.setSize(800, 800);
        jpanelRechts.setVisible(true);

        jpanelUnten.setBorder(BorderFactory.createLoweredBevelBorder());
        jpanelUnten.setLayout(new GridLayout(1, 5));
        jpanelUnten.setLocation(0, 800);
        jpanelUnten.setSize(1600, 200);
        jpanelUnten.setVisible(true);

        jpanelLinks.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        jpanelRechts.setBorder(BorderFactory.createEmptyBorder(0, -7, 5, 15));

        for ( int i = 0; i < 10; i++){
            jLabelobenEigenes[i] = new JLabel(""+(i+1));
            jLabelobenEigenes[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelobenGegner[i] = new JLabel(""+(i+1));
            jLabelobenGegner[i].setHorizontalAlignment(SwingConstants.CENTER);

        }

        jpanelLinks.add(new JLabel());
        jpanelRechts.add(new JLabel());
        for (int j = 0; j < 10; j++){
            jpanelLinks.add(jLabelobenEigenes[j]);
            jpanelRechts.add(jLabelobenGegner[j]);

        }

        for ( int i = 0; i<10; i++ ) {

            for (int j = 0; j < 11; j++){
                if (j == 0){
                    char zahl=(char)(65+i);
                    jpanelLinks.add (new JLabel(Character.toString(zahl),SwingConstants.CENTER));
                    jpanelRechts.add (new JLabel(Character.toString(zahl), SwingConstants.CENTER));
                } else{ 

                    jButtonlinks[10*i+j-1] = new JButton ();
                    jButtonlinks[10*i+j-1].setVisible(true);
                    jpanelLinks.add ( jButtonlinks[10*i+j-1] );
                    jButtonlinks[10*i+j-1].addActionListener(this);
                    jButtonlinks[10*i+j-1].addMouseListener(this);
                    jButtonlinks[10*i+j-1].addMouseMotionListener(this);
                    

                    jButtonrechts[10*i+j-1] = new JButton();
                    jpanelRechts.add (jButtonrechts[10*i+j-1]);
                    jButtonrechts[10*i+j-1].setVisible(true);
                    jButtonrechts[10*i+j-1].addActionListener(this);
                    jButtonrechts[10*i+j-1].addMouseListener(this);
                    jButtonrechts[10*i+j-1].addMouseMotionListener(this);
                }
            }        
        }

        
        //Seitleiste
        zugLabel = new JLabel("Zug: Spieler" + (spiel.getaktuellerSpieler() + 1), SwingConstants.CENTER);
        zugLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jpanelUnten.add(zugLabel);

        modusLabel = new JLabel("Modus: " + spiel.spielzustandGeben(), SwingConstants.CENTER);
        modusLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jpanelUnten.add(modusLabel);

        richtungLabel = new JLabel("Richtung: " + spiel.baurichtungGeben(), SwingConstants.CENTER);
        richtungLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jpanelUnten.add(richtungLabel);

        wechselButton = new JButton("Sichtwechsel");
        wechselButton.setEnabled(false);
        jpanelUnten.add(wechselButton);
        
        add(jpanelLinks);
        add(jpanelUnten);
        add(jpanelRechts);
    }

    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 100; i++){
            if (e.getSource() == jButtonlinks[i]){
                int x = i % 10;
                int y = i / 10;
                System.out.println("Feld links: " + x + "," + y);
                jButtonlinks[i].setText(schiff);
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

    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e) || e.isControlDown()){
            spiel.baurichtungAendern();
            ausrichtungAktualisieren(2, e);
            richtungLabel.setText("Richtung: " + spiel.baurichtungGeben());
        }
    }

    public void mouseMoved(MouseEvent e) {
        for (int i = 0; i < 100; i++){
            if (spiel.baurichtungGeben() == "vertikal"){
                if (e.getSource() == jButtonlinks[i]){
                    Dimension size = label.getPreferredSize();
                    label.setBounds((e.getX() + jButtonlinks[i].getBounds().x - 60), (e.getY() + jButtonlinks[i].getBounds().y - 120), size.width, size.height);
                }
                else if (e.getSource() == jButtonrechts[i]){
                    Dimension size = label.getPreferredSize();
                    label.setBounds((e.getX() + jButtonrechts[i].getBounds().x + 800 - 60), (e.getY() + jButtonrechts[i].getBounds().y - 120), size.width, size.height);  
                }
            }
            else if (spiel.baurichtungGeben() == "horizontal"){
                if (e.getSource() == jButtonlinks[i]){
                    Dimension size = label.getPreferredSize();
                    label.setBounds((e.getX() + jButtonlinks[i].getBounds().x - 40), (e.getY() + jButtonlinks[i].getBounds().y - 60), size.width, size.height);
                }
                else if (e.getSource() == jButtonrechts[i]){
                    Dimension size = label.getPreferredSize();
                    label.setBounds((e.getX() + jButtonrechts[i].getBounds().x + 800 - 40), (e.getY() + jButtonrechts[i].getBounds().y - 60), size.width, size.height);  
                }
            }
        }
    }

    public void mouseDragged(MouseEvent e) {

    }
    
    public void ausrichtungAktualisieren(int laenge, MouseEvent e){
        if (spiel.baurichtungGeben() == "vertikal"){
            label.setIcon(schiff2Vertikal);
        }
        else if (spiel.baurichtungGeben() == "horizontal"){
            label.setIcon(schiff2Horizontal);
        }
        mouseMoved(e);
    }
    
    public void fehlerAnzeigen(String text){
        fehlerLabel.setText(text);
        add(fehlerLabel);
    }
    
}

