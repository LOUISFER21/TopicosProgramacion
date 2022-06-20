package Unidad3;

/**
 *
 * @author fersa
 */
import java.awt.*;
import javax.swing.*;

public class PanelFondo extends JPanel 
{
    public String fondo="";
    PanelFondo(String fondo)
    {
        this.fondo=fondo;
    }
    public void paintComponent(Graphics g)
    {
        Dimension tam=getSize();
        ImageIcon imageFondo = new ImageIcon (fondo);
        g.drawImage(imageFondo.getImage(),0,0,tam.width,tam.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
