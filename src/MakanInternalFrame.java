import javax.swing.*;

import com.sun.glass.ui.Screen;

import java.awt.*;
import java.beans.PropertyVetoException;

public class MakanInternalFrame extends JInternalFrame
{
	public MakanInternalFrame()
	{
		setSize(500, 500);
		
		JLabel lblMakan = new JLabel("Makan!");
		lblMakan.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblMakan, BorderLayout.CENTER);
	}
}
