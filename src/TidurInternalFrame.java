import javax.swing.*;

import com.sun.glass.ui.Screen;

import java.awt.*;
import java.beans.PropertyVetoException;

public class TidurInternalFrame extends JInternalFrame
{
	public TidurInternalFrame()
	{
		setSize(500, 500);
		
		JLabel lblTidur = new JLabel("Tidur!");
		lblTidur.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblTidur, BorderLayout.CENTER);
	}
}
