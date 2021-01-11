
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rovit
 */
public class seeker extends javax.swing.JFrame {

    /**
     * Creates new form seeker
     */
        public Connection cn;
    public Statement st;
    public int ids;
    public String name,pno;
    public seeker seeker1;
    public seeker() {
        initComponents();
         
         try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal?zeroDateTimeBehavior=convertToNull","root","");
            st=cn.createStatement();
            JOptionPane.showMessageDialog(null,"Connected");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Not Connected");
        }
         Show_Users_In_JTable();
         Show_Users_In_JTable1();
          Show_Users_In_JTable2();
    }
 

    seeker(int id) {
        this.ids=id;
        initComponents();
         try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal?zeroDateTimeBehavior=convertToNull","root","");
            st=cn.createStatement();
            JOptionPane.showMessageDialog(null,"Connected");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Not Connected");
        }
         Show_Users_In_JTable();
         Show_Users_In_JTable1();
          Show_Users_In_JTable2();
    }
    public ArrayList<typeofjob> getUsersList1()
   {
       ArrayList<typeofjob> usersList = new ArrayList<typeofjob>();
       String query = "SELECT * FROM  jobapplied j,userdetails u,jobcreate jc  WHERE ids="+ids+" and j.idc=u.id and jc.jobid=j.jobid";
      try {
           ResultSet rs;
           rs = st.executeQuery(query);
           typeofjob display;
           while(rs.next())
           {
               display = new typeofjob(rs.getInt("jobid"),rs.getString("typeofjob"),rs.getString("place"));
               usersList.add(display);
           }
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
       return usersList;
   }
   
   // Display Data In JTable
   
   public void Show_Users_In_JTable1()
   {
       ArrayList<typeofjob> list = getUsersList1();
       DefaultTableModel model = (DefaultTableModel)applied.getModel();
       Object[] row = new Object[3];

       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getid();
            row[1]=list.get(i).getjob();
           row[2]=list.get(i).getplace();
          
                   

           
           model.addRow(row);
       }
    }

    
    public ArrayList<typeofjob> getUsersList()
   {
       ArrayList<typeofjob> usersList = new ArrayList<typeofjob>();
      
       String query = "SELECT * FROM  jobcreate j,userdetails u WHERE j.id=u.id ";

      
       try {
           ResultSet rs;
           rs = st.executeQuery(query);
           typeofjob display;
           while(rs.next())
           {
               display = new typeofjob(rs.getInt("jobid"),rs.getString("typeofjob"),rs.getString("place"));
               usersList.add(display);
           }
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
       return usersList;
   }
   
   // Display Data In JTable
   
   public void Show_Users_In_JTable()
   {
       ArrayList<typeofjob> list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)details.getModel();
       Object[] row = new Object[3];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getid();
           row[1] = list.get(i).getjob();
           row[2] = list.get(i).getplace();
           
           model.addRow(row);
       }
    }
    public ArrayList<typeofjob> getUsersList2()
   {
       ArrayList<typeofjob> usersList = new ArrayList<typeofjob>();
      
       String query = " SELECT * FROM  approved a,jobcreate jc,userdetails u WHERE a.ids='"+ids+"' and jc.jobid=a.jobid and u.id=a.idc" ;
      try {
           ResultSet rs;
           rs = st.executeQuery(query);
           typeofjob display;
           while(rs.next())
           {
               display = new typeofjob(rs.getInt("jobid"),rs.getString("typeofjob"),rs.getString("place"));
               usersList.add(display);
           }
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
       return usersList;
   }
   
   // Display Data In JTable
   
   public void Show_Users_In_JTable2()
   {
       ArrayList<typeofjob> list = getUsersList2();
       DefaultTableModel model = (DefaultTableModel)approved.getModel();
       Object[] row = new Object[3];

       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getid();
            row[1]=list.get(i).getjob();
           row[2]=list.get(i).getplace();
          
                   

           
           model.addRow(row);
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        details = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jobid = new javax.swing.JTextField();
        typeofjob = new javax.swing.JTextField();
        apply = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        applied = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        approved = new javax.swing.JTable();
        remove = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "jobid", "typeofjob", "place"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(details);

        jLabel1.setText("jobid");

        jLabel2.setText("typeofjob");

        jobid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobidActionPerformed(evt);
            }
        });

        apply.setText("Apply");
        apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyActionPerformed(evt);
            }
        });

        applied.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job id", "Type of Job", "Place"
            }
        ));
        jScrollPane2.setViewportView(applied);

        approved.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Typeofjob", "Place"
            }
        ));
        jScrollPane3.setViewportView(approved);

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        jLabel3.setText("Applied");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(typeofjob))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(52, 52, 52)
                                        .addComponent(jobid)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(remove)
                                    .addComponent(apply))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jobid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(typeofjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apply)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remove)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobidActionPerformed

    private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
        // TODO add your handling code here:
        
        String query,query1;
        String sql="select * from jobcreate where jobid='"+jobid.getText()+"' and typeofjob='"+typeofjob.getText()+"'";
            ResultSet res;
            try {
                res = st.executeQuery(sql);
                 if(res.next()){
                    query1 = "INSERT INTO jobapplied(ids, idc,jobid) VALUES ('"+ids+"','"+res.getString("id")+"','"+res.getString("jobid")+"')";  
                    int res1=st.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Added");
                    seeker1 = new seeker(ids);
            seeker1.setVisible(true);
            this.dispose();
                 }else{
                     JOptionPane.showMessageDialog(null, "Job Not Found");
                 }
            } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, "Job Already Applied");
            }
            

   
    }//GEN-LAST:event_applyActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
                     String query;
    query = "delete from jobapplied  where ids="+ids+" and jobid='"+jobid.getText()+"'";
    try {
            int res=st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Deleted");
                seeker seeker1 = new seeker(ids);
                seeker1.setVisible(true);
            this.dispose();
      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       
        }
    }//GEN-LAST:event_removeActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(seeker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seeker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seeker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seeker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seeker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable applied;
    private javax.swing.JButton apply;
    private javax.swing.JTable approved;
    private javax.swing.JTable details;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jobid;
    private javax.swing.JButton remove;
    private javax.swing.JTextField typeofjob;
    // End of variables declaration//GEN-END:variables
}
