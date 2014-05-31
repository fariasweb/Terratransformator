import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author farias
 * 
 */
public abstract class View3Col extends ViewLayout {

	protected JPanel pLeft, pRight, pCenter;

	View3Col(AbstractControllerView c) {
		super(c);
	}

	/**
	 * 
	 */
	protected void create_layout() {
		
		pLeft = new JPanel();
		pRight = new JPanel();
		pCenter = new JPanel();

		// Layout
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Horizontal
		layout.setHorizontalGroup(layout
				.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pLeft)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pCenter)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pRight)
						)
				)
		);

		// Vertical
		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(pLeft)
								.addComponent(pCenter)
								.addComponent(pRight))
		);
		
		
	}
}
