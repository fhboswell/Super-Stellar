/**
 * Created by henryboswell on 7/21/17.
 */

import javax.swing.*;
import java.awt.*;

public class Stellar extends JFrame {

    public Stellar() {

        initUI();
    }

    private void initUI() {

        add(new Scene());

        setSize(600, 600
        );
        setResizable(true);

        setTitle("Super Stellar");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Stellar game = new Stellar();
                game.setVisible(true);
            }
        });
    }
}
