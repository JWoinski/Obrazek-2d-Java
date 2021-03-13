import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Kwadrat {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.add(new JPanel() {
            @Override
            // za pomocą nadpisanego painta rysujemy kwadraty
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                // Kąt, który będziemy pomiędzy każdym kolejnym kwadratem
                double degree = Math.toRadians(10);
                // Obrazek do nextsize jest dołączony razem z kodem, lecz tutaj rozpiszę na czym polega next size.
                // Z twierdzenia o kwadracie wpisanym mamy następujące równanie, że Długość podstawy większego kwadratu jest
                // długością dwóch pozostałych kawałków, które zostają nam i tworzą przez to trójkąt i za pomocą funkcji trygonometrycznych
                // jesteśmy w stanie opisać długość kolejnego boku w zależności od kąta, który przypiszemy ( dowód na obrazku)
                double nextSize = 1 / (Math.sin(degree) + Math.cos(degree));

                double size = 200;

                g2d.translate(size, size);

                for (int i = 0; i < 10; i++) {
                    //zmieniamy sobie kolory prostym ifem, mozna to rozbudować by
                    // po kolei przyjmował kolory tęczy, ale do czytelności algorytmu starczy
                    if(i%2==0)g2d.setColor(Color.red);
                    else g2d.setColor(Color.black);
                    // z czasem size będzie przyjmować wartości po przecinku więc za każdym razem przpisujemy mu tylko zaokrągloną wartość
                    int calkowitysize = (int) Math.round(size);
                    // ustawiamy sobie srodek kwadratu na połowie długości jego dlugosci i wysokosci
                    g2d.fillRect(-calkowitysize / 2, -calkowitysize / 2, calkowitysize, calkowitysize);
                    //zmniejszamy większość nextsize
                    size *=nextSize;
                    //odwracamy kwadra o podany kąt wyżej
                    g2d.rotate(degree);
                }
            }
        });
        frame.setVisible(true);

    }
}