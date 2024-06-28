package org.example;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

import org.example.Block.Block;
import org.example.KeyInput.KeyInput;
import org.example.Player.Player;
import org.example.Map.Map;
public class GamePanel extends JPanel implements Runnable {
    private Thread thread; // Hilo para el bucle del juego
    private boolean running; // Indica si el juego está en ejecución
    private BufferedImage image; // Imagen en memoria para el doble buffer
    private Graphics g; // Gráficos para dibujar en la imagen
    public static final int WIDTH = 800; // Ancho del panel del juego
    public static final int HEIGHT = 600; // Alto del panel del juego

    private Player player; // Jugador
    private Map map; // Mapa del juego

    // Constructor para configurar el panel del juego
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Establecer el tamaño preferido del panel
        setFocusable(true); // Hacer el panel enfocable
        requestFocus(); // Solicitar el foco
    }

    @Override
    public void addNotify() {
        super.addNotify();
        // Iniciar el hilo del juego si no está iniciado
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        init(); // Inicializar el juego

        // Bucle principal del juego
        while (running) {
            update(); // Actualizar la lógica del juego
            render(); // Dibujar el juego en el buffer
            draw(); // Dibujar el buffer en la pantalla
            try {
                Thread.sleep(16); // Pausar el hilo para mantener ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para inicializar el juego
    private void init() {
        running = true; // Establecer el estado del juego en ejecución
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); // Crear una nueva imagen en memoria
        g = image.getGraphics(); // Obtener los gráficos de la imagen

        player = new Player(WIDTH / 2, HEIGHT / 2); // Crear un nuevo jugador en el centro de la pantalla
        map = new Map(); // Crear un nuevo mapa
        addKeyListener(new KeyInput(player)); // Añadir el detector de teclas al panel
    }

    // Método para actualizar la lógica del juego
    private void update() {
        player.update(); // Actualizar la lógica del jugador
        checkCollisions(); // Verificar colisiones
    }

    // Método para dibujar el juego en el buffer
    private void render() {
        g.setColor(Color.GRAY); // Establecer el color de fondo
        g.fillRect(0, 0, WIDTH, HEIGHT); // Dibujar el fondo

        map.render(g); // Dibujar el mapa
        player.render(g); // Dibujar el jugador
    }

    // Método para dibujar el buffer en la pantalla
    private void draw() {
        Graphics g2 = getGraphics(); // Obtener los gráficos del panel
        g2.drawImage(image, 0, 0, null); // Dibujar la imagen en el panel
        g2.dispose(); // Liberar los recursos gráficos
    }

    // Método para verificar colisiones entre el jugador y los bloques
    private void checkCollisions() {
        for (Block block : map.getBlocks()) {
            if (!block.isCollisionable() && player.getBounds().intersects(block.getBounds())) { // Si el jugador colisiona con un bloque
                player.handleCollision(block.getBounds()); // Manejar la colisión
            }
        }
    }
}

