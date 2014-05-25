/**
 * 
 */
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ViewMain extends JFrame {

	/**
	 * 
	 */
	private ViewController cpp;

	private JPanel pTop, pBottom;
	private JTabbedPane tabbedLeft, tabbedRight, tabbedOpe;

	/**
	 * 
	 * @param vc
	 */
	ViewMain(ViewController vc) {
		// Creamos el frame
		super("Terratransformator");

		// Guardamos la referencia al controlador principal de presentacion
		cpp = vc;

		// Evento por defecto
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Size y visibilidad
		setSize(500, 500);
		setVisible(true);
		
		
		pTop = new JPanel();
		pBottom = new JPanel();

		tabbedLeft = (JTabbedPane) create_JtabledPane();
		tabbedRight = (JTabbedPane) create_JtabledPane();
		tabbedOpe = (JTabbedPane) create_JtabledPane();

		// add(tabbedLeft);

		tabbedLeft.add("Fran", createInnerPanel("Fran"));
		tabbedLeft.add("Fran2", createInnerPanel("Fran"));
		tabbedLeft.add("Fran3", createInnerPanel("Fran33"));

		// add(tabbedRight);
		tabbedRight.add("Pruebas", createInnerPanel("ppp"));
		
		tabbedOpe.add("Operaciones", createInnerPanel("ppp"));
		pBottom.add(tabbedOpe);
		
		// Layout
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Vertically, we want to align each label with his textfield
		// on the baseline of the components

		layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(pTop)
								.addComponent(pBottom)
						)
			);

		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(pTop)
				)
				.addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(pBottom)
				)
				
		);
		
		GroupLayout layout_pTop = new GroupLayout(pTop);
		pTop.setLayout(layout_pTop);
		layout_pTop.setAutoCreateGaps(true);
		layout_pTop.setAutoCreateContainerGaps(true);

		layout_pTop.setHorizontalGroup(layout_pTop
				.createSequentialGroup()
				.addGroup(
						layout_pTop.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(tabbedLeft)
						)
				.addGroup(
						layout_pTop.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(tabbedRight)
						)
			);

		layout_pTop.setVerticalGroup(layout_pTop
				.createSequentialGroup()
				.addGroup(layout_pTop
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tabbedLeft)
						.addComponent(tabbedRight)
				)
		);
		
		
		GroupLayout layout_pBottom = new GroupLayout(pBottom);
		pBottom.setLayout(layout_pBottom);
		layout_pBottom.setAutoCreateGaps(true);
		layout_pBottom.setAutoCreateContainerGaps(true);

		layout_pBottom.setHorizontalGroup(layout_pBottom
				.createSequentialGroup()
				.addGroup(
						layout_pBottom.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(tabbedOpe)
						)
			);

		layout_pBottom.setVerticalGroup(layout_pBottom
				.createSequentialGroup()
				.addGroup(layout_pBottom
						.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tabbedOpe)
				)
		);
		
		pack();

	}

	private Component create_JtabledPane() {

		JTabbedPane jTabbedPane1 = new JTabbedPane();
		return jTabbedPane1;
	}

	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}

}
