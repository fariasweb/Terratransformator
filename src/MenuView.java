import java.awt.event.*;
import javax.swing.*;

public class MenuView extends AbstractViewer {

	private JMenuBar menuBar;
	private JMenu exit, help;

	MenuView(MenuControllerView c) {
		super(c);
		
		create_view();
		create_events();
	}

	@Override
	protected void create_view() {
		menuBar = new JMenuBar();
		Console.log("Creamos");
		// HELP
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_X);
		menuBar.add(help);

		// EXIT
		exit = new JMenu("Exit");
		exit.setMnemonic(KeyEvent.VK_X);
		menuBar.add(exit);
	}

	@Override
	protected void create_events() {
		exit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != null) {
					System.exit(0);
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		help.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() != null) {
					((MenuControllerView)controller).show_help();
				}

			}
		});
	}
	
	/**
	 * 
	 * @return
	 */
	public JMenuBar get_menu() {
		return menuBar;
	}
	
}