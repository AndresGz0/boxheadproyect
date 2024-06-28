package org.example.Player;

import java.awt.*;

public class Enemy extends Player{
    public Enemy(int x, int y) {
        super(x, y);
        this.speed = 2;
    }
    @Override
    public void update()
    {
        y += speed;
    }
    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }
}
