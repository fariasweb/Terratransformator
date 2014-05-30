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
	
	private DefaultTableModel jt;
	GalaxyFormCreate(DefaultTableModel jtp, GalaxyControllerView gcf){
		controller = gcf;
		jt = jtp;
	}
	
	@Override
	protected void create_view() {
		
		JLabel name = new JLabel("Name: ");
		JLabel posx = new JLabel("Position X: ");
		JLabel posy = new JLabel("Position Y: ");
		
	    tfname = new JTextField(10);
		tfposx = new JTextField(3);
		tfposy = new JTextField(3);
		
		bcommit = new JButton("Commit");
		
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
		// TODO Auto-generated method stub
		bcommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				if(tfposx.getText() != null && tfposy.getText() != null && tfname.getText() != null)((GalaxyControllerView)controller).addGalaxy(tfname.getText(), Integer.parseInt(tfposx.getText()), Integer.parseInt(tfposy.getText()));
				
				//Peta
				
				//Si No lanza Excepcion la funcion anterior, pido la galaxia a la capa de dominio y lo a–ado a la tabla suponiendo que no hay control de cache
				Galaxy name = ((GalaxyControllerView)controller).getByName(tfname.getText());

				//Compruebo que no anada otra vez el mismo nombre de la Galaxia iterando en las filas de la tabla 
				boolean found = false;
				for(int i = 0; i < jt.getRowCount() && !found; ++i){
					if(jt.getValueAt(i,0).equals(name.getName())) found = true;
				}
				
				//Si no encuentra una galaxia con mismo nombre -> La anade en la tabla
				if(!found) jt.addRow(new Object[] { name.getName() });
				
				//Compruebo que esta registrada la galaxia en la capa de dominio en la terminal
				Console.print("Coordenada X: " + name.getSize().getX() + "Coordenada Y:" + name.getSize().getY());
				
				//Funciona ejecutando un juego de pruebas sencillito para comprobar el bucle for funciona bien
				tfname.setText("");;
				tfposx.setText("");
				tfposy.setText("");
			}
		});
	}

	@Override
	public void show(String s){}

}

