package org.example.Block;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Block {
    private int x, y; // Posición del bloque
    private int width, height; // Tamaño del bloque
    private boolean collisionable;

    // Constructor para inicializar la posición y el tamaño del bloque

    public Block(int x, int y, int width, int height, boolean collisionable) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.collisionable = collisionable;
    }

    public boolean isCollisionable() {
        return collisionable;
    }

    public void setCollisionable(boolean collisionable) {
        this.collisionable = collisionable;
    }

    // Método para dibujar el bloque
    public void render(Graphics g) {
        g.setColor(Color.LIGHT_GRAY); // Color del bloque
        g.fillRect(x, y, width, height); // Dibujar el bloque como un rectángulo
    }
    public void render(Graphics g, int val) {
        g.setColor(Color.darkGray); // Color del bloque
        g.fillRect(x, y, width, height); // Dibujar el bloque como un rectángulo
    }

    // Método para obtener el rectángulo de colisión del bloque
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

