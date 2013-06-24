import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;


/**
 *
 * @author sridhar
 */
public class ProjectDemo_test extends javax.swing.JFrame {
	
	FileSystemView fileSystemView;
	File currentFile;
	DefaultTreeModel treeModel;    	
	Desktop desktop;

    public ProjectDemo_test()
    {
        initComponents();
        setLocation(150,150);
    }

   @SuppressWarnings("unchecked")
                        
    private void initComponents()
    {
    	jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_terminal = new javax.swing.JTextArea();
        jScrollPane_right = new javax.swing.JScrollPane();
        jTextArea_treeDisplay = new javax.swing.JTextArea();
        
        jScrollPane1.setViewportView(jTree1);
        jTextField1.setBackground(new java.awt.Color(1, 1, 1));
        jTextField1.setForeground(new java.awt.Color(254, 254, 254));
        jTextField1.setToolTipText("Enter Command Here");
        
        jTextArea_terminal.setEditable(false);
        jTextArea_terminal.setBackground(new java.awt.Color(1, 1, 1));
        jTextArea_terminal.setColumns(20);
        jTextArea_terminal.setForeground(new java.awt.Color(254, 254, 254));
        jTextArea_terminal.setRows(5);
        jScrollPane2.setViewportView(jTextArea_terminal);
        
        jTextArea_treeDisplay.setColumns(20);
        jTextArea_treeDisplay.setRows(5);
        jScrollPane_right.setViewportView(jTextArea_treeDisplay);
        
        fileSystemView = FileSystemView.getFileSystemView();
        desktop = Desktop.getDesktop();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Dash Board");        
          
        FileSystemView fileSystemView;
    	DefaultTreeModel treeModel;
    	
        fileSystemView = FileSystemView.getFileSystemView();
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        treeModel = new DefaultTreeModel(root);

        //show the file system roots
        File[] roots = fileSystemView.getRoots();
        for (File fileSystemRoot : roots) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
           	root.add( node );
        	jTree1.setModel(new DefaultTreeModel(node));
            
        	//showChildren(node);
            File[] files = fileSystemView.getFiles(fileSystemRoot, true);
            for (File file : files) {
                if (file.isDirectory()) {
                    node.add(new DefaultMutableTreeNode(file));                              
                }            
            }            
        }
        
        //Listening to selection (Keyboard or mouse) 
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener()
        {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
            	DefaultMutableTreeNode node =
                        (DefaultMutableTreeNode)evt.getPath().getLastPathComponent();    	 
            	            	           
            	 showChildren(node);
                                  
            	 System.out.println(node);
            	 jTextArea_treeDisplay.setText(node.toString()); 
                
            }
        });
        

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jTextField1KeyPressed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_right, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane_right, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2)))))
                .addContainerGap())
        );

        pack();
    }                      

   private void showChildren(final DefaultMutableTreeNode node) {
   	jTree1.setEnabled(false);
   	
       SwingWorker<Void, File> worker = new SwingWorker<Void, File>() {
           @Override
           public Void doInBackground() {
               File file = (File) node.getUserObject();
               if (file.isDirectory()) {
                   File[] files = fileSystemView.getFiles(file, true); //!!
                   if (node.isLeaf()) {
                       for (File child : files) {
                           if (child.isDirectory()) {
                               publish(child);
                           }
                       }
                   }
                 // System.out.println(files);
                   //setTableData(files);
               }
               return null;
           }

           @Override
           protected void process(List<File> chunks) {
               for (File child : chunks) {
                   node.add(new DefaultMutableTreeNode(child));
               }
           }

           @Override
           protected void done() {
           	
           	jTree1.setEnabled(true);
           }
       };
       worker.execute();// TODO Auto-generated method stub
		
	}
                                  

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt)                                    
    {                                           
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {     
            execute_command();  
        }
        else {
            System.out.println("Enter or control not pressed");
        }

    }     
    
  //Here is my code for executing the terminal
    void execute_command()
    {
    	String cmd_input;
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
   
            jTextArea_terminal.setText("");            
                                         
            while ((line=buf.readLine())!=null) 
            {    
                System.out.println(line);
                jTextArea_terminal.append(line);
                jTextArea_terminal.append("\n");
            }
          } 
        catch (Exception e) {
        	jTextArea_terminal.setText("");
        	 //line = "error occurred";
        	 line = e.toString();
        	 System.out.println(line);
        	 jTextArea_terminal.append(line);
        	 jTextArea_terminal.append("\n");        
        }                             
    }
   
    	
    public static void main(String args[])
    {
        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        	 
        } catch(Exception e) { System.out.println("Error setting native LAF: " + e); }
        
        
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new ProjectDemo_test().setVisible(true);
            }
        });
    }
    // Variables declaration                    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane_right;
    private javax.swing.JTextArea jTextArea_terminal;
    private javax.swing.JTextArea jTextArea_treeDisplay;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    // End of variables declaration                   
}
