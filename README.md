Tragamonedas (Slot Machine)
Este es un proyecto simple de una máquina tragamonedas utilizando Java, que permite simular el giro de tres rodillos. La interfaz gráfica de usuario (GUI) está construida con Swing, y utiliza múltiples hilos para simular el giro de los rodillos de manera simultánea. Cuando los tres rodillos muestran el símbolo "7", se muestra un GIF como un mensaje de victoria.

Requisitos
Java 8 o superior.

Biblioteca Swing (incluida por defecto en JDK).

Estructura del Proyecto
El proyecto está dividido en tres clases principales:

SlotMachineController: Controlador que maneja la lógica del juego.

SlotmachineModel: Modelo que simula los rodillos de la tragamonedas.

SlotMachineView: Vista que contiene la interfaz gráfica y muestra los resultados.

Instrucciones
Compilar y ejecutar el programa:

Para compilar el programa, usa el comando:

bash
Copiar
Editar
javac SlotMachineController.java SlotmachineModel.java SlotMachineView.java
Para ejecutar el programa:

bash
Copiar
Editar
java casino.maquinacasino.SlotMachineView
Interacción con la aplicación:

El usuario puede presionar el botón Spin para hacer girar los tres rodillos.

Si los tres rodillos muestran el símbolo "7", se mostrará un GIF indicando que el jugador ha ganado.

Este proyecto tiene tres clases principales:

SlotMachineController controla la lógica del juego y maneja la interacción entre la vista y el modelo. En el método spinReels(), se deshabilita el botón "Spin", se simula el giro de los rodillos, y cuando los tres rodillos terminan de girar, si muestran "7", se muestra un GIF de victoria. Los rodillos giran en hilos independientes utilizando un ExecutorService con un ThreadPool de 3 hilos.

SlotmachineModel es el modelo que proporciona los resultados aleatorios de los rodillos. Su método `spin
