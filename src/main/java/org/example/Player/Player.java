package org.example.Player;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import org.example.GamePanel;
public class Player {
    protected int x, y; /// Posicion del jugador
    protected int width, height; /// Ancho y largo del mismo
    protected int speed; /// Velocidad
    private boolean up, down, left, right;
    /// Estado de las teclas, siendo presionadas o no

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
        this.speed = 3;
    }

    public void update() {
        /// Actualizar logica

        /// Mover el jugador
        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;

        constrainToBounds();
    }

    public void render(Graphics g) {
        /// Dibujarlo
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    // Obtener el rectángulo de colisión del jugador
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    // Método para manejar las colisiones del jugador con los bloques
    public void handleCollision(Rectangle blockBounds) {
        // Si el jugador colisiona con un bloque, ajustar su posición
        if (getBounds().intersects(blockBounds)) {
            if (up) {
                y = blockBounds.y + blockBounds.height; // Mover hacia abajo
            }
            if (down) {
                y = blockBounds.y - height; // Mover hacia arriba
            }
            if (left) {
                x = blockBounds.x + blockBounds.width; // Mover hacia la derecha
            }
            if (right) {
                x = blockBounds.x - width; // Mover hacia la izquierda
            }
        }
    }
    protected void constrainToBounds() {
        // Restringir el movimiento horizontal dentro de los límites de la ventana
        if (x < 0) {
            x = 0;
        } else if (x > GamePanel.WIDTH - width) {
            x = GamePanel.WIDTH - width;
        }

        // Restringir el movimiento vertical dentro de los límites de la ventana
        if (y < 0) {
            y = 0;
        } else if (y > GamePanel.HEIGHT - height) {
            y = GamePanel.HEIGHT - height;
        }
    }
    // Métodos para controlar el movimiento
    public void setUp(boolean up) { this.up = up; }
    public void setDown(boolean down) { this.down = down; }
    public void setLeft(boolean left) { this.left = left; }
    public void setRight(boolean right) { this.right = right; }
}
