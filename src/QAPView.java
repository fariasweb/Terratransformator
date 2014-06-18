import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class QAPView extends View3Row {
	private JButton inputButton;
	private QAPInputForm fInput;
	
	
	private QAPInputDetail qapinput;

	QAPView(AbstractControllerView c) {
		super(c);	
	}
	
	/*public void showQAPInputForm(String nameGalaxy, String QAPType, int nivel) throws Exception{

			((QAPController)controller.get_controller()).generateQAPInput(nameGalaxy, QAPType, nivel);
			qapinput = new QAPInputDetail((QAPInputControllerView)controller);
			qapinput.setVisible(true);
	}*/

	protected void create_events() {
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					/*if((String)gcb.getSelectedItem() != "None" || ((QAPController)controller.get_controller()).getByNameToString((String)gcb.getSelectedItem()).length() > 1){
					
					if(rb1.isSelected())showQAPInputForm((String)gcb.getSelectedItem(), rb1.getName(), (Integer)jp.getValue());
					else showQAPInputForm((String)gcb.getSelectedItem(), rb2.getName(), (Integer)jp.getValue());
					}
					else {
						//if((QAPIn)((QAPInputControllerView)controller).vError.error("Enter Galaxy to continue!");
					}*/
					
					fInput.submit_form();
				}
				catch(Exception e3){
					controller.show_error(e3.getMessage());
				}
			}
		});

	}


	protected void create_view() {
		
		//Formulario
		fInput = new QAPInputForm(((QAPInputControllerView)controller));
		add_top(fInput);
		
		//Boton inferior
		inputButton = new JButton("Create Input Form");
		add_bottom(inputButton);
	}

}
