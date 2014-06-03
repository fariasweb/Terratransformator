import java.awt.event.*;
import java.awt.Image;
import javax.swing.*;
import javax.swing.event.*;

public class OurMenu implements ActionListener, MenuKeyListener {
  
   private JMenuBar menuBar;
   private JMenu svld, exit;
   private JMenuItem save, load;

   OurMenu(){
      menuBar = new JMenuBar();
      svld = new JMenu("Save/Load");
     /* svld.setMnemonic(KeyEvent.VK_I);
      svld.addMenuKeyListener(this);
      svld.addMenuListener(new MenuListener(){
         @Override
         public void menuCanceled(MenuEvent event) {
         }
         @Override
         public void menuDeselected(MenuEvent event) {
         }
         @Override
         public void menuSelected(MenuEvent event) {
            /*if(event.getSource().equals("exit"))
               System.exit(0);*/
         // }
      // });
      menuBar.add(svld);

      exit = new JMenu("Exit");
      exit.setMnemonic(KeyEvent.VK_X);
      exit.addMouseListener(new MouseListener() {  
              
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
                if(e.getSource() != null)  
                {  
                    System.out.print("ffs"); 
                    System.exit(0);
                }  
                  
            }  
        });  

     /* exit.addMenuListener(new MenuListener(){
         @Override
         public void menuCanceled(MenuEvent event) {
         }
         @Override
         public void menuDeselected(MenuEvent event) {
         }
         @Override
         public void menuSelected(MenuEvent event) {*/
            //if(event.getSource().equals("exit"))
               // System.exit(0);
         // }
      menuBar.add(exit);

      save = new JMenuItem("Save", new ImageIcon(new ImageIcon("images/save_icon.gif")
        .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
      save.addActionListener(this);
      svld.add(save);

      load = new JMenuItem("Open", new ImageIcon(new ImageIcon("images/open_icon.gif")
        .getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
      load.addActionListener(this);
      svld.add(load);

   }

   public void setOurMenu(PresentationView pv){
      pv.setJMenuBar(menuBar);
   }

   public void actionPerformed(ActionEvent e) {
      System.out.println("Item clicked: "+e.getActionCommand());
   }

   public void menuKeyTyped(MenuKeyEvent e) {
      MenuElement[] path = e.getPath();
      JMenuItem item = (JMenuItem) path[path.length-1];
      System.out.println("Key typed: "+e.getKeyChar()
         + ", "+e.getKeyText(e.getKeyCode())
         + " on "+item.getText());
   }

   public void menuKeyPressed(MenuKeyEvent e) {
      MenuElement[] path = e.getPath();
      JMenuItem item = (JMenuItem) path[path.length-1];
      System.out.println("Key pressed: "+e.getKeyChar()
         + ", "+e.getKeyText(e.getKeyCode())
         + " on "+item.getText());
   }

   public void menuKeyReleased(MenuKeyEvent e) {
      MenuElement[] path = e.getPath();
      JMenuItem item = (JMenuItem) path[path.length-1];
      System.out.println("Key released: "+e.getKeyChar()
         + ", "+e.getKeyText(e.getKeyCode())
         + " on "+item.getText());
   }
}