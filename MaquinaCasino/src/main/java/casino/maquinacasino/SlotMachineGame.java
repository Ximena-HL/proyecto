package casino.maquinacasino;

import javax.swing.SwingUtilities;

public class SlotMachineGame { 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SlotmachineModel model = new SlotmachineModel();
            SlotMachineView view = new SlotMachineView();
            new SlotMachineController(model, view);
            view.setVisible(true);
        });
    }
}
