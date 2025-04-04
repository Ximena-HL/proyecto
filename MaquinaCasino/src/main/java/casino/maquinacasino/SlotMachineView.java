package casino.maquinacasino;

import javax.swing.*;
import java.awt.*;

public class SlotMachineView extends JFrame {
    private final JLabel[] reels = new JLabel[3];
    private final JButton spinButton = new JButton("Spin");

    public SlotMachineView() {
        setTitle("Tragamonedas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de los rodillos
        JPanel slotPanel = new JPanel(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            reels[i] = new JLabel(loadImage("default.png")); 
            reels[i].setHorizontalAlignment(SwingConstants.CENTER);
            slotPanel.add(reels[i]);
        }

        add(slotPanel, BorderLayout.CENTER);
        add(spinButton, BorderLayout.SOUTH);
    }

    public void setReelImage(int index, String imageName) {
        reels[index].setIcon(loadImage(imageName));
    }

  private ImageIcon loadImage(String imageName) {
    java.net.URL imgURL = getClass().getClassLoader().getResource("imagenes/" + imageName);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {
        System.err.println("No se encontró la imagen: " + imageName);
        return new ImageIcon();  // Devuelve imagen vacía para evitar errores
    }
}
// SlotMachineView.java

public void showWinnerGif() {
    // Aquí, por ejemplo, puedes agregar un JLabel con el gif de la victoria
    JLabel winnerLabel = new JLabel(loadImage("winner.gif"));
    winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    winnerLabel.setVerticalAlignment(SwingConstants.CENTER);

    // Aquí, se agrega al JFrame para que sea visible
    this.add(winnerLabel, BorderLayout.NORTH); // O donde quieras en el layout

    // Forzamos la actualización de la interfaz para ver el gif
    SwingUtilities.invokeLater(() -> this.revalidate());
    SwingUtilities.invokeLater(() -> this.repaint());
}



public void removeWinnerGif() {
    // Busca y elimina el JLabel que contiene el GIF si existe
    for (Component comp : getContentPane().getComponents()) {
        if (comp instanceof JLabel) {
            JLabel label = (JLabel) comp;
            if (label.getIcon() != null && label.getIcon().toString().contains("winner.gif")) {
                getContentPane().remove(label);
                break;
            }
        }
    }
    // Forzar actualización de la interfaz
    SwingUtilities.invokeLater(() -> {
        revalidate();
        repaint();
    });
}

public void setReelSymbol(int index, String symbol) {
    // Cambiar la imagen del rodillo según el símbolo (puede ser una imagen o el GIF)
    reels[index].setIcon(loadImage(symbol));
}



    public JButton getSpinButton() {
        return spinButton;
    }
}

