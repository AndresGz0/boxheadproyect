package org.example.Player;

import java.awt.*;

public class Enemy extends Player{
    public Enemy(int x, int y) {
        super(x, y);
        this.speed = 2;
    }
    public void update(Player player) {
        // Update enemy position to chase player
        int dx = player.getX() - x; // Calculate difference in x-coordinates
        int dy = player.getY() - y; // Calculate difference in y-coordinates

        // Normalize the direction vector (optional)
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance > 0) {
            dx = (int) (dx / distance * speed);
            dy = (int) (dy / distance * speed);
        }

        x += dx;
        y += dy;

        constrainToBounds();// (Assuming you have a similar method from Player class)
    }
    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }
}
