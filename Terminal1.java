import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.UIManager;

public class Terminal1 extends javax.swing.JFrame {
    
    String cmd_input;
    
    public Terminal1()
    {
        initComponents();
        setLocation(455,250);
        
        
    }
    
                     
    private void initComponents()
    {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jTextField1KeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                       

    
    void execute_command()
    {
        cmd_input = jTextField1.getText();
        final String cmd = cmd_input;
        String line = ""; 
        Process p;
            
        try 
        {
            //p = Runtime.getRuntime().exec(cmd);
            p = Runtime.getRuntime().exec(cmd_input);
            p.waitFor();
 
            BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));
   
            jTextArea1.setText("");            
                                         
            while ((line=buf.readLine())!=null) 
            {    
                System.out.println(line);
                jTextArea1.append(line);
                jTextArea1.append("\n");
            }
          } 
        catch (Exception e) {e.printStackTrace();} 
                            
    }

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt)                                       
    {                                           
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER)
        {     
            execute_command();  
        }
        else
        {
            System.out.println("Enter or control not pressed");
        }

    }                                      

        
    public static void main(String args[])
    {
    	
    	try {
  	      		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
  	    	} 	catch(Exception e) 
  	    		{
  	    			System.out.println("Error setting native LAF: " + e);
  	    		}
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new Terminal1().setVisible(true);
            }
        });
    }
                        
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
                       
}
