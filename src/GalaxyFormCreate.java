import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class GalaxyFormCreate extends AbstractViewer {
	private JTextField tfname;
	private JTextField tfposx;
	private JTextField tfposy;
	private JButton bcommit;
	
	GalaxyFormCreate(GalaxyControllerView gcf){
		controller = gcf;
	}
	
	@Override
	protected void create_view() {
		
		JLabel name = new JLabel("Name: ");
		JLabel posx = new JLabel("Position X: ");
		JLabel posy = new JLabel("Position Y: ");
		
	    tfname = new JTextField(10);
		tfposx = new JTextField(3);
		tfposy = new JTextField(3);
		
		bcommit = new JButton("Save");
		
		//Creamos un Layout para colocar Labels y TextFields del formulario
		 
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(name) .addComponent(tfname))
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(posx) .addComponent(tfposx)
												)
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(posy) .addComponent(tfposy))
								.addGroup(
										layout.createSequentialGroup()
												.addComponent(bcommit)))
				);

		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(name)
												.addComponent(tfname)
												.addComponent(posx)
												.addComponent(tfposx)
												.addComponent(posy)
												.addComponent(tfposy)
												.addComponent(bcommit)
												)
										));
	}

	@Override
	protected void create_events() {
		
		//FORMULARIO: Guardar
		bcommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				
				try {
					
					//Comprobacion basica de campos
					if(tfposx.getText() == null || tfposy.getText() == null || tfname.getText() == null)
						throw new Exception("The values can not be empty");
					
					//Creaci—n del objeto por parte del controlador
					((GalaxyControllerView)controller).addGalaxy(tfname.getText(), Integer.parseInt(tfposx.getText()), Integer.parseInt(tfposy.getText()));

					//Add to table - TODO: Orden alfabetico??
					//jt.addRow(new Object[] { tfname.getText() });
					
					//Reinicio campos
					tfname.setText("");;
					tfposx.setText("");
					tfposy.setText("");
					
				} catch (Exception e) {
					controller.show_error(e.getMessage());
				}
			}
		});
	}
}

