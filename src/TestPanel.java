import java.awt.*;
import javax.swing.*;

public class TestPanel extends JPanel
{
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawLine(0, 0, 100, 300);
	}
}
