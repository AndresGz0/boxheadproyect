package org.example.Map;
import org.example.Block.Block;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Block> blocks; // Lista de bloques en el mapa

    // Constructor para inicializar la lista de bloques
    public Map() {
        blocks = new ArrayList<>();
        // Añadir algunos bloques al mapa
        blocks.add(new Block(120,220,200,200,true));
        blocks.add(new Block(520,220,200,200,true));
        blocks.add(new Block(100, 200, 200, 200,false));
        blocks.add(new Block(500, 200, 200, 200,false));

    }
    // Método para dibujar todos los bloques del mapa
    public void render(Graphics g) {
        for (Block block : blocks) {
            block.render(g); // Dibujar cada bloque
            if (!block.isCollisionable()) {
                block.render(g,0);
            }
            else
                block.render(g); // Dibujar cada bloque

        }
    }

    // Método para obtener la lista de bloques
    public List<Block> getBlocks() {
        return blocks;
    }
}
