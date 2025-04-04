package casino.maquinacasino;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;

public class SlotMachineController {
    private final SlotmachineModel model;
    private final SlotMachineView view;
    private final ExecutorService executorService;

    // Usamos AtomicInteger para contar de manera segura en el entorno multihilo
    private final AtomicInteger finishedReels = new AtomicInteger(0);

    public SlotMachineController(SlotmachineModel model, SlotMachineView view) {
        this.model = model;
        this.view = view;
        this.executorService = Executors.newFixedThreadPool(3);
        
        view.getSpinButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinReels();
            }
        });
    }

private void spinReels() {
    view.getSpinButton().setEnabled(false); // Deshabilitar el botón mientras gira
    view.removeWinnerGif(); // Eliminar el GIF de ganador antes de girar de nuevo

    String[] reelResults = new String[3]; // Para almacenar los resultados
    finishedReels.set(0); // Reiniciar el contador

    for (int i = 0; i < 3; i++) {
        final int index = i;
        executorService.execute(() -> {
            try {
                for (int j = 0; j < 15; j++) {
                    String tempSymbol = model.spin();
                    SwingUtilities.invokeLater(() -> view.setReelSymbol(index, tempSymbol));
                    Thread.sleep(100); // Simulación del giro
                }

                // Forzar el resultado final a "7.png"
                String finalSymbol = model.spin();
                SwingUtilities.invokeLater(() -> {
                    view.setReelSymbol(index, finalSymbol);
                    reelResults[index] = finalSymbol;
                });

                // Incrementar contador de rodillos terminados
                int finished = finishedReels.incrementAndGet();
                
                // Si este es el último rodillo en detenerse, verificar y mostrar el GIF
                if (finished == 3) {
                    SwingUtilities.invokeLater(() -> {
                        if (reelResults[0].equals("7.png") && reelResults[1].equals("7.png") && reelResults[2].equals("7.png")) {
                            view.showWinnerGif(); // Mostrar GIF inmediatamente después del último rodillo
                        }
                        view.getSpinButton().setEnabled(true); // Rehabilitar el botón
                    });
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }
}

}
