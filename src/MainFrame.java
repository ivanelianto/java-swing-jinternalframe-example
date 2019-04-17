import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame extends JFrame
{
	Image backgroundImage;
	JMenuBar menuBar;
	JMenu menu1;
	JMenuItem subMenu1, subMenu2;	
	JDesktopPane desktop;
	MakanInternalFrame makanInternalFrame;
	TidurInternalFrame tidurInternalFrame;

	public MainFrame()
	{
		// Untuk Dapetin Ukuran Layar Sekarang
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		try
		{
			// Baca File Gambar
			backgroundImage = ImageIO.read(new File("bg.jpg"));
			
			// Atur Ukuran Gambar Gak Full Banget, Ikutin Layar Sekarang
			backgroundImage = backgroundImage.getScaledInstance(
					screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
		}
		catch (Exception e) { }

		// Biasalah
		setTitle("Test");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		setupMenuBar();
		
		/* Ini Pakai Desktop Pane, 
		 * Jadi Anggepannya Ini Penampung Buat JInterfalFrame
		 * Kita
		 */ 
		desktop = new JDesktopPane() {
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
		
				/* Jadi Ketika Sedang Menggambarkan Semua Component2 Kita
				 * Kita Sekalian Gambarkan Sebuah Gambar Ke Background 
				 */
				g.drawImage(backgroundImage, 0, 0, null);
			}
		};
		
		// Siapkan Semua Internal Framenya
		// Masukkin Ke JDesktopPane, Tapi Jangan Di Show Dulu
		// Shownya Ketika Menunya Diklik
		setupInternalFrames();
		
		this.add(desktop, BorderLayout.CENTER);

		setVisible(true);
	}
	
	private void setupMenuBar()
	{
		// Buat Menu Bar
		menuBar = new JMenuBar();
		
		// Buat Menu
		menu1 = new JMenu("Senang");
		menuBar.add(menu1);
		
		// Buat Sub Menu
		subMenu1 = new JMenuItem("Makan");
		subMenu1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// Ketika Di Klik, Internal Frame Mana Yang Harus Muncul
				// dan Internal Frame Mana Yang Harus Di Sembunyiin
				tidurInternalFrame.hide();
				makanInternalFrame.show();
			}
		});
		menu1.add(subMenu1);
		
		subMenu2 = new JMenuItem("Tidur");
		subMenu2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				makanInternalFrame.hide();
				tidurInternalFrame.show();
			}
		});
		menu1.add(subMenu2);
		
		this.add(menuBar, BorderLayout.NORTH);
	}
	
	private void setupInternalFrames()
	{
		makanInternalFrame = new MakanInternalFrame();
		desktop.add(makanInternalFrame);

		tidurInternalFrame = new TidurInternalFrame();
		desktop.add(tidurInternalFrame);
	}

	public static void main(String[] args)
	{
		new MainFrame();
	}

}
