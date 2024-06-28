package org.example.KeyInput;

import org.example.Player.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    /// Referencia al jugador
    private Player player;

/// Constructor
    public KeyInput(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Establecer el estado de las teclas de movimiento cuando se presionan
        if (key == KeyEvent.VK_W) player.setUp(true);
        if (key == KeyEvent.VK_S) player.setDown(true);
        if (key == KeyEvent.VK_A) player.setLeft(true);
        if (key == KeyEvent.VK_D) player.setRight(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // Establecer el estado de las teclas de movimiento cuando se sueltan
        if (key == KeyEvent.VK_W) player.setUp(false);
        if (key == KeyEvent.VK_S) player.setDown(false);
        if (key == KeyEvent.VK_A) player.setLeft(false);
        if (key == KeyEvent.VK_D) player.setRight(false);
    }
}
