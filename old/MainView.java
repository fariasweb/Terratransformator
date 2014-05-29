/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mthani
 */
public class MainView extends javax.swing.JFrame {
 
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
 
        jLabelTitle = new JLabel();
        jTabbedPane1 = new JTabbedPane();
        JPanelPlanet = new JPanel();
        jScrollPane3 = new JScrollPane();
        jTablePlanet = new JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        JButtonLoadPlanet = new JButton();
        jButtonSavePlanet = new JButton();
        jButtonAddPlanet = new JButton();
        jButtonDeletePlanet = new JButton();
        JPanelGalaxy = new JPanel();
        jScrollPane4 = new JScrollPane();
        jTable4 = new JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButtonLoadGalaxy = new JButton();
        jButtonSaveGalaxy = new JButton();
        jButtonAddGalaxy = new JButton();
        jButtonDeleteGalaxy = new JButton();
        JPanelSolution = new JPanel();
        jLabelSolution = new JLabel();
        JPanelArbol = new JPanel();
        jTabbedPane2 = new JTabbedPane();
        jPanelResource = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTableResource = new JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButtonDeleteResource = new JButton();
        jButtonAddResource = new JButton();
        jButtonSaveResource = new JButton();
        jButtonLoadResource = new JButton();
        jPanelPacket = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTablePacket = new JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButtonDeletePacket = new JButton();
        jButtonAddPacket = new JButton();
        jButtonSavePacket = new JButton();
        jButtonLoadPacket = new JButton();
        jTabbedPane3 = new JTabbedPane();
        jPanel5 = new JPanel();
        jLabel3 = new JLabel();
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        jLabelTitle.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitle.setText("Terraformación de Planetas");
 
        jTablePlanet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PlanetOne", "10", "20"},
             
            },
            new String [] {
                "PlanetName", "PosX", "PosY"
            }
        ));
        jTablePlanet.setUpdateSelectionOnSort(false);
        jTablePlanet.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablePlanetPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePlanet);
        jTablePlanet.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
 
        JButtonLoadPlanet.setText("Cargar");
        JButtonLoadPlanet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonLoadPlanetActionPerformed(evt);
            }
        });
 
        jButtonSavePlanet.setText("Guardar");
        jButtonSavePlanet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavePlanetActionPerformed(evt);
            }
        });
 
        jButtonAddPlanet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPlanetActionPerformed(evt);
            }
        });
        jButtonAddPlanet.setText("Añadir");
 
        jButtonDeletePlanet.setText("Eliminar");
 
        javax.swing.GroupLayout JPanelPlanetLayout = new GroupLayout(JPanelPlanet);
        JPanelPlanet.setLayout(JPanelPlanetLayout);
        JPanelPlanetLayout.setHorizontalGroup(
            JPanelPlanetLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(JPanelPlanetLayout.createSequentialGroup()
                .addComponent(JButtonLoadPlanet)
                .addGap(17, 17, 17)
                .addComponent(jButtonSavePlanet)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddPlanet)
                .addGap(18, 18, 18)
                .addComponent(jButtonDeletePlanet)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPanelPlanetLayout.setVerticalGroup(
            JPanelPlanetLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, JPanelPlanetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelPlanetLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonLoadPlanet)
                    .addComponent(jButtonSavePlanet)
                    .addComponent(jButtonAddPlanet)
                    .addComponent(jButtonDeletePlanet))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
        );
 
        jTabbedPane1.addTab("Planet", JPanelPlanet);
 
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"GalaxyOne", "Atri2", "Atri3"},
             
            },
            new String [] {
                "GalaxyName", "Title 2", "Title 3"
            }
        ));
        jScrollPane4.setViewportView(jTable4);
 
        jButtonLoadGalaxy.setText("Importar");
        jButtonLoadGalaxy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadGalaxyActionPerformed(evt);
            }
        });
 
        jButtonSaveGalaxy.setText("Exportar");
 
        jButtonAddGalaxy.setText("Añadir");
        jButtonAddGalaxy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddGalaxyMouseClicked(evt);
            }
        });
 
        jButtonDeleteGalaxy.setText("Eliminar");
 
        GroupLayout JPanelGalaxyLayout = new GroupLayout(JPanelGalaxy);
        JPanelGalaxy.setLayout(JPanelGalaxyLayout);
        JPanelGalaxyLayout.setHorizontalGroup(
            JPanelGalaxyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(JPanelGalaxyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLoadGalaxy)
                .addGap(18, 18, 18)
                .addComponent(jButtonSaveGalaxy)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddGalaxy)
                .addGap(18, 18, 18)
                .addComponent(jButtonDeleteGalaxy)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelGalaxyLayout.setVerticalGroup(
            JPanelGalaxyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, JPanelGalaxyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelGalaxyLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadGalaxy)
                    .addComponent(jButtonSaveGalaxy)
                    .addComponent(jButtonAddGalaxy)
                    .addComponent(jButtonDeleteGalaxy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
        );
 
        jTabbedPane1.addTab("Galaxy", JPanelGalaxy);
 
        jLabelSolution.setText("Aqui ira formulario para generar una solucion entrando una galaxia y paquete ");
 
        GroupLayout JPanelSolutionLayout = new GroupLayout(JPanelSolution);
        JPanelSolution.setLayout(JPanelSolutionLayout);
        JPanelSolutionLayout.setHorizontalGroup(
            JPanelSolutionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(JPanelSolutionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSolution, GroupLayout.PREFERRED_SIZE, 448, Short.MAX_VALUE))
        );
        JPanelSolutionLayout.setVerticalGroup(
            JPanelSolutionLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(JPanelSolutionLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabelSolution, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );
 
        jTabbedPane1.addTab("Solution", JPanelSolution);
 
        GroupLayout JPanelArbolLayout = new GroupLayout(JPanelArbol);
        JPanelArbol.setLayout(JPanelArbolLayout);
        JPanelArbolLayout.setHorizontalGroup(
            JPanelArbolLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        JPanelArbolLayout.setVerticalGroup(
            JPanelArbolLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
 
        jTabbedPane1.addTab("Arbol", JPanelArbol);
 
        jTableResource.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ResourceOne", "atri1", "atri2", "atri3"},
             
            },
            new String [] {
                "Nombre Recurso", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableResource);
 
        jButtonDeleteResource.setText("Eliminar");
 
        jButtonAddResource.setText("Añadir");
 
        jButtonSaveResource.setText("Exportar");
 
        jButtonLoadResource.setText("Importar");
        jButtonLoadResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadResourceActionPerformed(evt);
            }
        });
 
        GroupLayout jPanelResourceLayout = new GroupLayout(jPanelResource);
        jPanelResource.setLayout(jPanelResourceLayout);
        jPanelResourceLayout.setHorizontalGroup(
            jPanelResourceLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanelResourceLayout.createSequentialGroup()
                .addComponent(jButtonLoadResource)
                .addGap(18, 18, 18)
                .addComponent(jButtonSaveResource)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddResource)
                .addGap(18, 18, 18)
                .addComponent(jButtonDeleteResource)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelResourceLayout.setVerticalGroup(
            jPanelResourceLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelResourceLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanelResourceLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadResource)
                    .addComponent(jButtonSaveResource)
                    .addComponent(jButtonAddResource)
                    .addComponent(jButtonDeleteResource))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
        );
 
        jTabbedPane2.addTab("Resource", jPanelResource);
 
        jTablePacket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PacketOne", "AtriP1", "AtriP2", "AtriP3"},
             
            },
            new String [] {
                "NombrePaquete", "", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablePacket);
 
        jButtonDeletePacket.setText("Eliminar");
 
        jButtonAddPacket.setText("Añadir");
 
        jButtonSavePacket.setText("Guardar");
 
        jButtonLoadPacket.setText("Cargar");
        jButtonLoadPacket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadPacketActionPerformed(evt);
            }
        });
 
        GroupLayout jPanelPacketLayout = new GroupLayout(jPanelPacket);
        jPanelPacket.setLayout(jPanelPacketLayout);
        jPanelPacketLayout.setHorizontalGroup(
            jPanelPacketLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanelPacketLayout.createSequentialGroup()
                .addComponent(jButtonLoadPacket)
                .addGap(18, 18, 18)
                .addComponent(jButtonSavePacket)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddPacket)
                .addGap(18, 18, 18)
                .addComponent(jButtonDeletePacket)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelPacketLayout.setVerticalGroup(
            jPanelPacketLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanelPacketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPacketLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoadPacket)
                    .addComponent(jButtonSavePacket)
                    .addComponent(jButtonAddPacket)
                    .addComponent(jButtonDeletePacket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1,GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE))
        );
 
        jTabbedPane2.addTab("Packet", jPanelPacket);
 
        jLabel3.setText("Muestra información acerca de la Solución");
 
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );
 
        jTabbedPane3.addTab("Operaciones", jPanel5);
 
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3,GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabelTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(227, 227, 227))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabelTitle, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane2,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
       
        pack();
    }// </editor-fold>                        
 
    private void jButtonLoadGalaxyActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                
 
    private void JButtonLoadPlanetActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                
 
    private void jButtonLoadPacketActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                
 
    private void jButtonLoadResourceActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                  
 
    private void jTablePlanetPropertyChange(java.beans.PropertyChangeEvent evt) {                                            
        // TODO add your handling code here:
    }                                          
 
    private void jButtonAddGalaxyMouseClicked(java.awt.event.MouseEvent evt) {                                              
        // TODO add your handling code here:
       
    }                                            
 
    private void jButtonSavePlanetActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                
   
    private void jButtonAddPlanetActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here
        jLabel3.setVisible(false);
       
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify                    
    private JButton JButtonLoadPlanet,jButtonAddGalaxy,jButtonAddPacket,jButtonAddPlanet,jButtonAddResource,jButtonDeleteGalaxy,jButtonDeletePacket,jButtonDeletePlanet,jButtonDeleteResource,jButtonLoadGalaxy,jButtonLoadResource,jButtonLoadPacket,jButtonSaveGalaxy,jButtonSavePacket,jButtonSavePlanet,jButtonSaveResource;
    private JPanel JPanelArbol,JPanelGalaxy,JPanelPlanet,JPanelSolution;
    private JLabel jLabel3,jLabelSolution,jLabelTitle;
    private JPanel jPanel5,jPanelPacket,jPanelResource;
    private JScrollPane jScrollPane1,jScrollPane2,jScrollPane3,jScrollPane4;
    private JTabbedPane jTabbedPane1,jTabbedPane2,jTabbedPane3;
    private JTable jTable4,jTablePacket,jTablePlanet,jTableResource;
 
    // End of variables declaration                  
}