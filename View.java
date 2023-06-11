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
    //Kommunikation mit Model
    private Spiel spiel;
    
    
    //Symbole für den Zustand einer Zelle
    String wasser = "-";
    String schiff = "s";
    String treffer = "X";
    String fehltreffer = "O";
    String gesunkenesSchiff = "#";

    //Objekte für das Eigen- und Gegnerfeld
    private JPanel jpanelLinks;
    private JPanel jpanelRechts;
    private JButton[] jButtonlinks = new JButton[100];
    private JButton[] jButtonrechts = new JButton[100];
    private JLabel[] jLabelobenEigenes = new JLabel[10];
    private JLabel[] jLabelobenGegner = new JLabel[10];
    private JLabel[] jLabelSeiteEigenes = new JLabel[10];
    private JLabel[] jLabelSeiteGegner  = new JLabel[10];
    

    //Objekte für die Subleiste
    private JPanel jpanelUnten;
    private JLabel zugLabel;
    private JLabel modusLabel;
    private JLabel uebrigeschiffeLabel;
    private JLabel naechstesSchiffLabel;
    private JButton wechselButton;

    
    //Objekte für den Schiff-Zeiger
    private JLabel zeigerLabel; //Label, der die Schiff-Icons in sich hält
    private ImageIcon schiff2Vertikal = new ImageIcon("Schiffe/Schiff2Vertikal.png");
    private ImageIcon schiff2Horizontal = new ImageIcon("Schiffe/Schiff2Horizontal.png");
    private ImageIcon schiff3Vertikal = new ImageIcon("Schiffe/Schiff3Vertikal.png");
    private ImageIcon schiff3Horizontal = new ImageIcon("Schiffe/Schiff3Horizontal.png");    //verschiedene Variationen vom Schiff-Icon, um Schiffe mit verschiedene Länge und Ausrichtung darzustellen                      
    private ImageIcon schiff4Vertikal = new ImageIcon("Schiffe/Schiff4Vertikal.png");            
    private ImageIcon schiff4Horizontal = new ImageIcon("Schiffe/Schiff4Horizontal.png");
    private ImageIcon schiff5Vertikal = new ImageIcon("Schiffe/Schiff5Vertikal.png");
    private ImageIcon schiff5Horizontal = new ImageIcon("Schiffe/Schiff5Horizontal.png"); 
    public View(Spiel spiel) {
        zeigerLabel = new JLabel();
        zeigerLabel.setIcon(schiff5Vertikal);
        Dimension size = zeigerLabel.getPreferredSize();

        this.spiel = spiel;
        setSize(new Dimension(1600, 1080));
        this.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);    

        add(zeigerLabel);

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
        jpanelUnten.setLayout(new GridLayout(1, 6));
        jpanelUnten.setLocation(0, 800);
        jpanelUnten.setSize(1600, 200);
        jpanelUnten.setVisible(true);

        jpanelLinks.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        jpanelRechts.setBorder(BorderFactory.createEmptyBorder(0, -7, 5, 15));

        //leere Ecke für rechts-oben
        jpanelLinks.add(new JLabel());
        jpanelRechts.add(new JLabel());
        
        //Beschriftung der horizontale Achse
        for (int i = 0; i < 10; i++){
            jLabelobenEigenes[i] = new JLabel(""+(i+1), SwingConstants.CENTER);
            jLabelobenGegner[i] = new JLabel(""+(i+1), SwingConstants.CENTER);
            
            jpanelLinks.add(jLabelobenEigenes[i]);
            jpanelRechts.add(jLabelobenGegner[i]);
        }

        for ( int i = 0; i<10; i++ ) {
            for (int j = 0; j < 11; j++){
                //Beschriftung der vertikale Achse 
                if (j == 0){
                    char zahl=(char)(65+i);
                    jpanelLinks.add (new JLabel(Character.toString(zahl),SwingConstants.CENTER));
                    jpanelRechts.add (new JLabel(Character.toString(zahl), SwingConstants.CENTER));
                
                } 
                // Erstellung der Buttons mit ActionLister
                else{ 

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

        for (int i = 0; i < 100; i++){
            felderAktualisieren(i);
        }

        //Elemente der Subleiste
        zugLabel = new JLabel("Zug: Spieler" + (spiel.getaktuellerSpieler() + 1), SwingConstants.CENTER);
        zugLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jpanelUnten.add(zugLabel);

        modusLabel = new JLabel("Modus: " + spiel.spielzustandGeben(), SwingConstants.CENTER);
        modusLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jpanelUnten.add(modusLabel);

        uebrigeschiffeLabel = new JLabel("Schiffe übrig: " + spiel.spielerGeben().anzahlaufzustellendeSchiffe, SwingConstants.CENTER);
        uebrigeschiffeLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jpanelUnten.add(uebrigeschiffeLabel);

        naechstesSchiffLabel = new JLabel("<html>nächstes Schiff:<br/>" + spiel.spielerGeben().naechstesSchiffGeben() + "<html>", SwingConstants.CENTER);
        naechstesSchiffLabel.setFont(new Font("Serif", Font.PLAIN, 36));
        jpanelUnten.add(naechstesSchiffLabel);

        wechselButton = new JButton("Sichtwechsel");
        wechselButton.setEnabled(false);
        jpanelUnten.add(wechselButton);
        
        // Zusammenfügung auf dem JFrame
        add(jpanelLinks);
        add(jpanelUnten);
        add(jpanelRechts);
    }

    //Wird bei Aktion aufgerufen
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 100; i++){
            // Wenn ein Button aus dem Eigenfeld geklickt wird
            if (e.getSource() == jButtonlinks[i]){
                //Ermittlung der x, y Koordinaten des Buttondrucks
                int x = i % 10;
                int y = i / 10;
                
                //
                spiel.click(x, y);
                uebrigeschiffeLabel.setText("Schiffe übrig: " + spiel.spielerGeben().anzahlaufzustellendeSchiffe);
                naechstesSchiffLabel.setText("<html>nächstes Schiff:<br/>" + spiel.spielerGeben().naechstesSchiffGeben() + "<html>");
            }
            // Wenn ein Button aus dem Gegnerfeld geklickt wird
            else {

            }
            felderAktualisieren(i); 
        }

        //Ermöglichung des Sichtwechsel nach Vollendung des Schiffebauprozesses
        if (spiel.spielerGeben().anzahlaufzustellendeSchiffe == -1){
            wechselButton.setEnabled(true);
        }

        if (e.getSource() == wechselButton){
            sichtWechseln();
        }

        
    }

    // aktualisiert das auf dem Zeiger fixierte Schiff-Icon (nach Richtungsänderung oder Platzierung)
    public void schiffAktualisieren(MouseEvent e){
        //Für den vertikalen Fall
        if (spiel.baurichtungGeben() == "vertikal"){
            switch(spiel.spielerGeben().anzahlaufzustellendeSchiffe){
                case 0: 
                    zeigerLabel.setIcon(schiff2Vertikal);
                    break;
                case 1: 
                    zeigerLabel.setIcon(schiff2Vertikal);
                    break;
                case 2: 
                    zeigerLabel.setIcon(schiff2Vertikal);
                    break;
                case 3: 
                    zeigerLabel.setIcon(schiff2Vertikal);
                    break;
                case 4:
                    zeigerLabel.setIcon(schiff3Vertikal);
                    break;
                case 5:
                    zeigerLabel.setIcon(schiff3Vertikal);
                    break;
                case 6:
                    zeigerLabel.setIcon(schiff3Vertikal);
                    break;
                case 7:
                    zeigerLabel.setIcon(schiff4Vertikal);
                    break;
                case 8:
                    zeigerLabel.setIcon(schiff4Vertikal);
                    break;
                case 9:
                    zeigerLabel.setIcon(schiff5Vertikal);
                    break;
                default:
                    zeigerLabel.setIcon(null);
            }
        }
        //Für den horizontalen Fall
        else {
            switch(spiel.spielerGeben().anzahlaufzustellendeSchiffe){
                case 0: 
                    zeigerLabel.setIcon(schiff2Horizontal);
                    break;
                case 1: 
                    zeigerLabel.setIcon(schiff2Horizontal);
                    break;
                case 2: 
                    zeigerLabel.setIcon(schiff2Horizontal);
                    break;
                case 3: 
                    zeigerLabel.setIcon(schiff2Horizontal);
                    break;
                case 4:
                    zeigerLabel.setIcon(schiff3Horizontal);
                    break;
                case 5:
                    zeigerLabel.setIcon(schiff3Horizontal);
                    break;
                case 6:
                    zeigerLabel.setIcon(schiff3Horizontal);
                    break;
                case 7:
                    zeigerLabel.setIcon(schiff4Horizontal);
                    break;
                case 8:
                    zeigerLabel.setIcon(schiff4Horizontal);
                    break;
                case 9:
                    zeigerLabel.setIcon(schiff5Horizontal);  
                    break;
                default:
                    zeigerLabel.setIcon(null);

            }
        }
        mouseMoved(e); // um unmittelbar nach der Aktualisierung die Position des Schiff-Icons auf den Zeiger zu fixieren
    }

    //aktualsiert die Symbole für den Zustand der Zelle von beiden Feldern
    public void felderAktualisieren(int i){
        int x = i % 10;
        int y = i / 10;

        //aktualisiert das Eigenfeld
        switch (spiel.spielerGeben().gibFeld().gibFeldPosition(x, y)){
            case 0:
                jButtonlinks[i].setText(wasser);
                break;
            case 1:
                jButtonlinks[i].setText(fehltreffer);
                break;
            case 2:
                jButtonlinks[i].setText(schiff);
                break;
            case 3:
                jButtonlinks[i].setText(gesunkenesSchiff);
                break;

        }

        //aktualisiert das GegnerFeld
        switch (spiel.spielerGeben().gibFeld().gibGegnerFeldPosition(x, y)){
            case 0:
                jButtonrechts[i].setText(wasser);
                break;
            case 1:
                jButtonrechts[i].setText(fehltreffer);
                break;
            case 2:
                jButtonrechts[i].setText(treffer);
                break;
            case 3:
                jButtonrechts[i].setText(gesunkenesSchiff);
                break;

        }

    }

    // Die Sicht zwischen Spieler1 und Spieler2 wechseln
    public void sichtWechseln(){
        //Noch zu machen
    }
    
    public void mouseClicked(MouseEvent e) {
        //Beim Rechtsclicken
        if (SwingUtilities.isRightMouseButton(e) || e.isControlDown()){
            spiel.baurichtungAendern();
            schiffAktualisieren(e);
        }
        //Beim Linksclicken
        else if(SwingUtilities.isLeftMouseButton(e) || e.isControlDown()){
            schiffAktualisieren(e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        // Setzt die Position von SchiffIcon auf Mauszeiger
        for (int i = 0; i < 100; i++){
            if (spiel.baurichtungGeben() == "vertikal"){
                if (e.getSource() == jButtonlinks[i] && spiel.spielerGeben().anzahlaufzustellendeSchiffe < 4){
                    Dimension size = zeigerLabel.getPreferredSize();
                    zeigerLabel.setBounds((e.getX() + jButtonlinks[i].getBounds().x - 60), (e.getY() + jButtonlinks[i].getBounds().y - 120), size.width, size.height);
                }
                else if (e.getSource() == jButtonlinks[i] && spiel.spielerGeben().anzahlaufzustellendeSchiffe < 7){
                    Dimension size = zeigerLabel.getPreferredSize();
                    zeigerLabel.setBounds((e.getX() + jButtonlinks[i].getBounds().x - 60), (e.getY() + jButtonlinks[i].getBounds().y - 190), size.width, size.height);
                }
                else if (e.getSource() == jButtonlinks[i] && spiel.spielerGeben().anzahlaufzustellendeSchiffe < 9){
                    Dimension size = zeigerLabel.getPreferredSize();
                    zeigerLabel.setBounds((e.getX() + jButtonlinks[i].getBounds().x - 60), (e.getY() + jButtonlinks[i].getBounds().y - 255), size.width, size.height);
                }
                else if (e.getSource() == jButtonlinks[i] && spiel.spielerGeben().anzahlaufzustellendeSchiffe == 9){
                    Dimension size = zeigerLabel.getPreferredSize();
                    zeigerLabel.setBounds((e.getX() + jButtonlinks[i].getBounds().x - 60), (e.getY() + jButtonlinks[i].getBounds().y - 325), size.width, size.height);
                }
            }
            else if (spiel.baurichtungGeben() == "horizontal"){
                if (e.getSource() == jButtonlinks[i]){
                Dimension size = zeigerLabel.getPreferredSize();
                zeigerLabel.setBounds((e.getX() + jButtonlinks[i].getBounds().x - 40), (e.getY() + jButtonlinks[i].getBounds().y - 60), size.width, size.height);
            }
            }
        }
    }
    
    //unbenötigte Methoden von MouseListener, die überschrieben werden müssen
    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
    
    public void mouseDragged(MouseEvent e) {

    }

}

