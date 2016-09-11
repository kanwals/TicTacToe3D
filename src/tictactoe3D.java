
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class tictactoe3D extends JFrame implements ActionListener, MouseMotionListener {

    JButton b[] = new JButton[30];
    Button bt0, bt1, bt2;
    char m[][][] = new char[3][3][3];
    TextField t1, t2;
    Label l1, l2, l3, l4, lb0, lb1, lb2, lb3, lb4, p1, p2;
    int l = 0;
    int x2[] = {159, 246, 331, 413, 453, 495, 535, 451, 369, 287, 245, 203, 159};
    int y2[] = {204, 186, 168, 150, 183, 221, 256, 276, 294, 312, 276, 240, 204};
    int x1[] = new int[13];
    int y1[] = new int[13];
    int x0[] = new int[13];
    int y0[] = new int[13];
    Font f1 = new Font(Font.MONOSPACED, Font.BOLD, 27);
    Font f2 = new Font(Font.MONOSPACED, Font.BOLD, 12);
    Color c1 = new Color(100, 0, 0);
    Color c2 = new Color(0, 100, 0);

    public tictactoe3D() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    m[i][j][k] = '.';
                }
            }
        }

        setSize(700, 700);
        setLayout(null);
        setTitle("TIC TAC TOE 3D - Gurkanwal Singh");
        bt0 = new Button("Click to play");
        for (int i = 1; i < b.length; i++) {
            b[i] = new JButton();
        }

        bt1 = new Button("ABORT");
        bt1.setBounds(400, 600, 100, 30);
        bt2 = new Button("EXIT");
        bt2.setBounds(550, 600, 100, 30);

        bt1.setVisible(true);
        bt2.setVisible(true);

        t1 = new TextField();
        t2 = new TextField();
        l1 = new Label();
        l2 = new Label();
        l3 = new Label("It's A TIE.");
        l4 = new Label("MATCH ABORTED.");
        lb0 = new Label("-----> PLANE 0");
        lb1 = new Label("-----> PLANE 1");
        lb2 = new Label("-----> PLANE 2");
        lb3 = new Label("PLAYER 1: ");
        lb4 = new Label("PLAYER 2: ");
        p1 = new Label("PLAYER 1's turn ");
        p2 = new Label("PLAYER 2's turn ");
        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        p1.setFont(f2);
        p2.setFont(f2);
        lb0.setFont(f2);
        lb1.setFont(f2);
        lb2.setFont(f2);
        lb3.setFont(f2);
        lb4.setFont(f2);
        l1.setBounds(50, 600, 300, 40);
        l2.setBounds(50, 600, 300, 40);
        l3.setBounds(50, 600, 300, 40);
        l4.setBounds(50, 600, 300, 40);
        p1.setBounds(10, 300, 120, 40);
        p2.setBounds(10, 300, 120, 40);
        lb3.setBounds(50, 50, 80, 20);
        lb4.setBounds(50, 80, 80, 20);
        lb0.setBounds(550, 190, 120, 20);
        lb1.setBounds(550, 330, 120, 20);
        lb2.setBounds(550, 460, 120, 20);
        t1.setBounds(140, 50, 150, 20);
        t2.setBounds(140, 80, 150, 20);
        bt0.setBounds(320, 50, 150, 40);
        b[1].setBounds(180, 170, 77, 20);
        b[1].setOpaque(false);
        b[2].setBounds(260, 152, 77, 20);
        b[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
        b[3].setBounds(340, 134, 77, 20);
        b[3].setOpaque(false);
        for (int i = 4; i < 10; i++) {
            b[i].setBounds((b[i - 3].getX() + 43), b[i - 3].getY() + 37, 77, 20);
            b[i].setOpaque(false);

        }
        for (int i = 11; i < 20; i++) {
            b[i].setBounds(b[i - 10].getX(), b[i - 10].getY() + 137, 77, 20);
        }
        for (int i = 21; i < 30; i++) {
            b[i].setBounds(b[i - 10].getX(), b[i - 10].getY() + 131, 77, 20);
        }
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(p1);
        add(p2);
        add(lb3);
        add(lb4);
        add(lb0);
        add(lb1);
        add(lb2);
        add(t1);
        add(t2);
        for (int i = 1; i < b.length; i++) {
            add(b[i]);
            b[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            b[i].addActionListener(this);
            b[i].setEnabled(false);
            b[i].setOpaque(false);
            b[i].setContentAreaFilled(false);
            b[i].setBorderPainted(false);
        }

        add(bt0);
        add(bt1);
        add(bt2);
        bt0.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        this.addMouseMotionListener(this);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        p1.setVisible(false);
        p2.setVisible(false);
        for (int i = 0; i < 13; i++) {
            y1[i] = y2[i] + 137;
            x1[i] = x2[i];
            x0[i] = x2[i];
            y0[i] = y2[i] + 131 + 137;
        }
        setSize(700, 700);
        setLocation(300, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        repaint();
    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
        g2.drawPolyline(x2, y2, x2.length);
        g2.drawPolyline(x1, y1, x1.length);
        g2.drawPolyline(x0, y0, x0.length);

        g2.drawLine(x2[1], y2[1], x2[8], y2[8]);
        g2.drawLine(x2[2], y2[2], x2[7], y2[7]);
        g2.drawLine(x2[4], y2[4], x2[11], y2[11]);
        g2.drawLine(x2[5], y2[5], x2[10], y2[10]);
        g2.drawLine(x1[1], y1[1], x1[8], y1[8]);
        g2.drawLine(x1[2], y1[2], x1[7], y1[7]);
        g2.drawLine(x1[4], y1[4], x1[11], y1[11]);
        g2.drawLine(x1[5], y1[5], x1[10], y1[10]);
        g2.drawLine(x0[1], y0[1], x0[8], y0[8]);
        g2.drawLine(x0[2], y0[2], x0[7], y0[7]);
        g2.drawLine(x0[4], y0[4], x0[11], y0[11]);
        g2.drawLine(x0[5], y0[5], x0[10], y0[10]);
        g2.drawLine(x2[0], y2[0], x1[0], y1[0]);
        g2.drawLine(x1[0], y1[0], x0[0], y0[0]);
        g2.drawLine(x2[6], y2[6], x1[6], y1[6]);
        g2.drawLine(x1[6], y1[6], x0[6], y0[6]);
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.CAP_ROUND));
        for (int i = 6; i < 12; i++) {
            g2.drawLine(x2[i], y2[i], x2[i + 1], y2[i + 1]);
            g2.drawLine(x1[i], y1[i], x1[i + 1], y1[i + 1]);
            g2.drawLine(x0[i], y0[i], x0[i + 1], y0[i + 1]);
        }
        g2.drawLine(x2[9], y2[9], x1[9], y1[9]);
        g2.drawLine(x1[9], y1[9], x0[9], y0[9]);

    }

    void abort() {
        for (int i = 1; i < 30; i++) {
            b[i].setEnabled(false);
        }
        bt0.setEnabled(false);
        bt1.setEnabled(false);
        bt2.setEnabled(true);
        p1.setVisible(false);
        p2.setVisible(false);
    }

    int result() {
        for (int i = 0; i < 3; i++) {               //i-->horizontal plane
            for (int j = 0; j < 3; j++) {           //k-->slicing acrozz z-axis
                for (int k = 0; k < 3; k++) {
                    if (j == 0 && k == 0) {
                        //diagonal(on the same plane) in various planes
                        if (m[i][0][0] == m[i][1][1] && m[i][0][0] == m[i][2][2]) {
                            if (m[i][0][0] == 'O') {
                                return 1;
                            } else if (m[i][0][0] == 'X') {
                                return 2;
                            }
                        }
                    }
                    if (j == 0 || j == 1 || j == 2) {
                        if (m[0][j][k] == m[1][j][k] && m[0][j][k] == m[2][j][k]) {//vertically straight rows
                            if (m[0][j][k] == 'O') {
                                return 1;
                            } else if (m[0][j][k] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][j][k] == m[1][1][k] && m[0][j][k] == m[2][2][k]) {//body diagonal
                            if (m[0][j][k] == 'O') {
                                return 1;
                            } else if (m[0][j][k] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][j][0] == m[1][j][1] && m[0][j][0] == m[2][j][2]) {//vertical face diagonals
                            if (m[0][j][0] == 'O') {
                                return 1;
                            } else if (m[0][j][0] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][j][2] == m[1][j][1] && m[0][j][2] == m[2][j][0]) {//vertical face diagonaLS
                            if (m[0][j][2] == 'O') {
                                return 1;
                            } else if (m[0][j][2] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][j][k] == m[1][1][k] && m[0][j][k] == m[2][0][k]) {//vertical face diagonal(into the face
                            if (m[0][j][k] == 'O') {
                                return 1;
                            } else if (m[0][j][k] == 'X') {
                                return 2;
                            }
                        }
                        if (m[i][0][k] == m[i][1][k] && m[i][0][k] == m[i][2][k]) {
                            if (m[i][0][k] == 'O') {
                                return 1;
                            } else if (m[i][0][k] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][0][0] == m[1][1][1] && m[0][0][0] == m[2][2][2]) {
                            if (m[0][0][0] == 'O') {
                                return 1;
                            } else if (m[0][0][0] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][0][2] == m[1][1][1] && m[0][0][2] == m[2][2][0]) {
                            if (m[0][0][2] == 'O') {
                                return 1;
                            } else if (m[0][0][2] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][2][0] == m[1][1][1] && m[0][2][0] == m[2][0][2]) {
                            if (m[0][2][0] == 'O') {
                                return 1;
                            } else if (m[0][2][0] == 'X') {
                                return 2;
                            }
                        }
                        if (m[0][2][2] == m[1][1][1] && m[0][2][2] == m[2][0][0]) {
                            if (m[0][2][2] == 'O') {
                                return 1;
                            } else if (m[0][2][2] == 'X') {
                                return 2;
                            }
                        }
                    }
                    if (k == 0) {       //straight horizontal lines in various planes
                        if (m[i][j][0] == m[i][j][1] && m[i][j][0] == m[i][j][2]) {
                            if (m[i][j][0] == 'O') {
                                return 1;
                            } else if (m[i][j][0] == 'X') {
                                return 2;
                            }
                        }
                    }
                    if (j == 0 && k == 2) {         //same plane diagonal testing
                        if (m[i][0][2] == m[i][1][1] && m[i][0][2] == m[i][2][0]) {
                            if (m[i][0][2] == 'O') {
                                return 1;
                            } else if (m[i][0][2] == 'X') {
                                return 2;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        if (e.getSource() == bt0) {
            l1.setText("Player 1 i.e. " + t1.getText() + " WINS!");
            l2.setText("Player 2 i.e. " + t2.getText() + " WINS!");
            for (int i = 1; i < 30; i++) {
                b[i].setEnabled(true);
                b[i].setOpaque(true);
                b[i].setBorderPainted(false);
            }
            bt0.setEnabled(false);
            p1.setVisible(true);
        }
        if (e.getSource() == bt1) {
            l4.setVisible(true);
            abort();
            bt0.setEnabled(false);

        }
        for (int i = 1; i < 30; i++) {
            if (e.getSource() == b[i]) {

                if (p1.isVisible()) {
                    p1.setVisible(false);
                    p2.setVisible(true);
                } else {
                    p1.setVisible(true);
                    p2.setVisible(false);
                }

                if (i < 10) {
                    if (l % 2 == 0) {
                        System.out.println(i);
                        int a = 0;
                        int s = i / 3;
                        if ((float) i / 3 == 1.0) {
                            s = 0;
                        }
                        if ((float) i / 3 == 2.0) {
                            s = 1;
                        }
                        if ((float) i / 3 == 3.0) {
                            s = 2;
                        }

                        int d = (i % 3) - 1;
                        if (i % 3 == 0) {
                            d = 2;
                        }
                        m[a][s][d] = 'O';
                        b[i].setText("O");
                        b[i].setFont(f1);
                        b[i].setEnabled(false);
                        l++;
                        System.out.println(a);
                    } else {
                        int a = 0;
                        int s = i / 3;
                        if ((float) i / 3 == 1.0) {
                            s = 0;
                        }
                        if ((float) i / 3 == 2.0) {
                            s = 1;
                        }
                        if ((float) i / 3 == 3.0) {
                            s = 2;
                        }

                        int d = (i % 3) - 1;
                        if (i % 3 == 0) {
                            d = 2;
                        }
                        m[a][s][d] = 'X';
                        b[i].setText("X");
                        b[i].setFont(f1);
                        b[i].setEnabled(false);
                        l++;
                    }
                } else if (i < 20) {
                    if (l % 2 == 0) {
                        int a = 1;
                        int s = (i - 10) / 3;
                        if ((float) (i - 10) / 3 == 1.0) {
                            s = 0;
                        }
                        if ((float) (i - 10) / 3 == 2.0) {
                            s = 1;
                        }
                        if ((float) (i - 10) / 3 == 3.0) {
                            s = 2;
                        }

                        int d = ((i - 10) % 3) - 1;
                        if ((i - 10) % 3 == 0) {
                            d = 2;
                        }
                        m[a][s][d] = 'O';
                        b[i].setText("O");
                        b[i].setFont(f1);
                        b[i].setEnabled(false);
                        l++;
                    } else {
                        int a = 1;
                        int s = (i - 10) / 3;
                        if ((float) (i - 10) / 3 == 1.0) {
                            s = 0;
                        }
                        if ((float) (i - 10) / 3 == 2.0) {
                            s = 1;
                        }
                        if ((float) (i - 10) / 3 == 3.0) {
                            s = 2;
                        }

                        int d = ((i - 10) % 3) - 1;
                        if ((i - 10) % 3 == 0) {
                            d = 2;
                        }
                        m[a][s][d] = 'X';
                        b[i].setText("X");
                        b[i].setFont(f1);
                        b[i].setEnabled(false);
                        l++;
                    }
                } else if (i < 30) {
                    if (l % 2 == 0) {
                        int a = 2;
                        int s = (i - 20) / 3;
                        if ((float) (i - 20) / 3 == 1.0) {
                            s = 0;
                        }
                        if ((float) (i - 20) / 3 == 2.0) {
                            s = 1;
                        }
                        if ((float) (i - 20) / 3 == 3.0) {
                            s = 2;
                        }

                        int d = ((i - 20) % 3) - 1;
                        if ((i - 20) % 3 == 0) {
                            d = 2;
                        }
                        m[a][s][d] = 'O';
                        b[i].setText("O");
                        b[i].setFont(f1);
                        b[i].setEnabled(false);
                        l++;
                    } else {
                        int a = 2;
                        int s = (i - 20) / 3;
                        if ((float) (i - 20) / 3 == 1.0) {
                            s = 0;
                        }
                        if ((float) (i - 20) / 3 == 2.0) {
                            s = 1;
                        }
                        if ((float) (i - 20) / 3 == 3.0) {
                            s = 2;
                        }

                        int d = ((i - 20) % 3) - 1;
                        if ((i - 20) % 3 == 0) {
                            d = 2;
                        }
                        m[a][s][d] = 'X';
                        b[i].setText("X");
                        b[i].setFont(f1);
                        b[i].setEnabled(false);
                        l++;
                    }
                }

                System.out.println("\n\n Status after move: " + l);
                for (int b = 0; b < 3; b++) {
                    System.out.println("\n PLANE " + b + " :");
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            System.out.print(m[b][j][k] + " ");
                        }
                        System.out.println();
                    }
                }
            }
            if (e.getSource() != bt1 && e.getSource() != bt2) {
                int check = result();
                if (check != 0 || l > 26) {
                    if (check != 0) {
                        if (check == 1) {
                            l1.setVisible(true);
                        } else {
                            l2.setVisible(true);
                        }
                    } else {
                        l3.setVisible(true);
                    }
                    abort();
                }
            }
            if (e.getSource() == bt2) {
                this.dispose();

            }

        }
    }

    public static void main(String[] args) {
        tictactoe3D obj = new tictactoe3D();

    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        repaint();
    }
}
