package newpackage;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;



//import org.GNOME.Accessibility.Component;

/**
 *
 * @author sridhar
 */
public class Fm_final extends javax.swing.JFrame {

    FileSystemView fileSystemView;
    File currentFile;
    DefaultTreeModel treeModel;
    Desktop desktop;
    ListSelectionListener listSelectionListener;
        
    public Fm_final()
    {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        terminalInput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        terminalOutput = new javax.swing.JTextArea();
        jPanelTable = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane_right = new javax.swing.JScrollPane();
        jTextArea_viewer = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_tree_file_properties = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jEditorPaneFolderPath = new javax.swing.JEditorPane();
        copyButton = new javax.swing.JButton();
        cutButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea_belowTree = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Dash Board");

        fileSystemView = FileSystemView.getFileSystemView();
        desktop = Desktop.getDesktop();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        treeModel = new DefaultTreeModel(root);

        File[] roots = fileSystemView.getRoots();
        for (File fileSystemRoot : roots)
        {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
            root.add( node );

            //showChildren(node);
            File[] files = fileSystemView.getFiles(fileSystemRoot, true);
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    node.add(new DefaultMutableTreeNode(file));
                }
            }

            tree.setModel(new DefaultTreeModel(node));
            tree.setCellRenderer(new FileTreeCellRenderer());
        }
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener()
        {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt)
            {
                treeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tree);

        terminalInput.setBackground(new java.awt.Color(255, 255, 255));
        terminalInput.setFont(new java.awt.Font("aakar", 1, 18)); // NOI18N
        terminalInput.setToolTipText("Enter Command Here");
        terminalInput.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                terminalInputKeyPressed(evt);
            }
        });

        terminalOutput.setEditable(false);
        terminalOutput.setBackground(new java.awt.Color(255, 255, 255));
        terminalOutput.setColumns(20);
        terminalOutput.setFont(new java.awt.Font("Akaash", 1, 18)); // NOI18N
        terminalOutput.setRows(5);
        jScrollPane2.setViewportView(terminalOutput);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String []
            {
                "Icon", "File", "Ext", "Size", "Mode"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        table.setToolTipText("");
        table.setRowHeight(21);
        table.setRowMargin(0);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTable.setViewportView(table);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setHeaderValue("Icon");
        table.getColumnModel().getColumn(1).setHeaderValue("File");
        table.getColumnModel().getColumn(2).setHeaderValue("Ext");
        table.getColumnModel().getColumn(3).setHeaderValue("Size");
        table.getColumnModel().getColumn(4).setHeaderValue("Mode");

        jTextArea_viewer.setEditable(false);
        jTextArea_viewer.setColumns(20);
        jTextArea_viewer.setRows(5);
        jTextArea_viewer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane_right.setViewportView(jTextArea_viewer);

        jTextArea_tree_file_properties.setEditable(false);
        jTextArea_tree_file_properties.setColumns(20);
        jTextArea_tree_file_properties.setLineWrap(true);
        jTextArea_tree_file_properties.setRows(5);
        jTextArea_tree_file_properties.setToolTipText("attributes");
        jTextArea_tree_file_properties.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextArea_tree_file_properties);

        javax.swing.GroupLayout jPanelTableLayout = new javax.swing.GroupLayout(jPanelTable);
        jPanelTable.setLayout(jPanelTableLayout);
        jPanelTableLayout.setHorizontalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLayout.createSequentialGroup()
                .addComponent(jScrollPane_right, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelTableLayout.setVerticalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLayout.createSequentialGroup()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane_right, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jEditorPaneFolderPath.setEditable(false);
        jEditorPaneFolderPath.setBackground(new java.awt.Color(255, 255, 255));
        jEditorPaneFolderPath.setFont(new java.awt.Font("Ubuntu Light", 1, 24)); // NOI18N
        jEditorPaneFolderPath.setDragEnabled(true);
        jScrollPane4.setViewportView(jEditorPaneFolderPath);

        copyButton.setIcon(new javax.swing.ImageIcon("/home/sridhar/dump/workspace/icons/copy.png")); // NOI18N
        copyButton.setToolTipText("Copy");
        copyButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                copyButtonActionPerformed(evt);
            }
        });

        cutButton.setIcon(new javax.swing.ImageIcon("/home/sridhar/dump/workspace/icons/cut.png")); // NOI18N
        cutButton.setToolTipText("Cut");
        cutButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cutButtonActionPerformed(evt);
            }
        });

        newButton.setIcon(new javax.swing.ImageIcon("/home/sridhar/dump/workspace/icons/new.png")); // NOI18N
        newButton.setToolTipText("New");
        newButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon("/home/sridhar/dump/workspace/icons/del.jpg")); // NOI18N
        deleteButton.setToolTipText("Paste");
        deleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteButtonActionPerformed(evt);
            }
        });

        jTextArea_belowTree.setEditable(false);
        jTextArea_belowTree.setColumns(20);
        jTextArea_belowTree.setFont(new java.awt.Font("DejaVu Serif", 0, 14)); // NOI18N
        jTextArea_belowTree.setRows(5);
        jScrollPane5.setViewportView(jTextArea_belowTree);
        {
            String line = "";
            Process p2;

            try
            {
                p2 = Runtime.getRuntime().exec("df -h");
                p2.waitFor();

                BufferedReader buf = new BufferedReader(new InputStreamReader(p2.getInputStream()));

                //jTextArea_belowTree.setText("");

                while ((line=buf.readLine())!=null)
                {
                    jTextArea_belowTree.append(line);
                    jTextArea_belowTree.append("\n");
                    System.out.println(line);
                }
            }
            catch (Exception e) { System.out.println(line); }
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(terminalInput)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cutButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(copyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cutButton)
                                    .addComponent(newButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(copyButton)
                                    .addComponent(deleteButton)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(terminalInput, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showChildren(final DefaultMutableTreeNode node)
    {
        tree.setEnabled(false);

        SwingWorker<Void, File> worker = new SwingWorker<Void, File>() {
            public Void doInBackground()
            {
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

            protected void process(List<File> chunks)
            {
                for (File child : chunks) {
                    node.add(new DefaultMutableTreeNode(child));
                }
            }

            protected void done()
            {

                tree.setEnabled(true);
            }
        };
        worker.execute();

    }
    
    private TreePath findTreePath(File find)
    {
        for (int ii = 0; ii < tree.getRowCount(); ii++) {
            TreePath treePath = tree.getPathForRow(ii);
            Object object = treePath.getLastPathComponent();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) object;
            File nodeFile = (File) node.getUserObject();

            if (nodeFile == find) {
                return treePath;
            }
        }
        // not found!
        return null;
    }
    
    
/** A TreeCellRenderer for a File. */
    class FileTreeCellRenderer extends DefaultTreeCellRenderer {

        private FileSystemView fileSystemView;
        private JLabel label;

        FileTreeCellRenderer()
        {
            label = new JLabel();
            label.setOpaque(true);
            fileSystemView = FileSystemView.getFileSystemView();
        }

        public Component getTreeCellRendererComponent(
                JTree tree,
                Object value,
                boolean selected,
                boolean expanded,
                boolean leaf,
                int row,
                boolean hasFocus)
        {

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            File file = (File) node.getUserObject();
            label.setIcon(fileSystemView.getSystemIcon(file));
            label.setText(fileSystemView.getSystemDisplayName(file));
            label.setToolTipText(file.getPath());

            if (selected) {
                label.setBackground(backgroundSelectionColor);
                label.setForeground(textSelectionColor);
            } else {
                label.setBackground(backgroundNonSelectionColor);
                label.setForeground(textNonSelectionColor);
            }

            return label;
        }
    }
    
    //code for executing the terminal
    private void execute_command()
    {
        String cmd_input;
        cmd_input = terminalInput.getText();
        final String cmd = cmd_input;
        String line = "";
        Process p;

        try {
            //p = Runtime.getRuntime().exec(cmd);
            p = Runtime.getRuntime().exec(cmd_input);
            p.waitFor();

            BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));

            terminalOutput.setText("");

            while ((line = buf.readLine()) != null) {
                System.out.println(line);
                terminalOutput.append(line);
                terminalOutput.append("\n");
            }
        } catch (Exception e) {
            terminalOutput.setText("");
            //line = "error occurred";
            line = e.toString();
            System.out.println(line);
            terminalOutput.append(line);
            terminalOutput.append("\n");
        }
    }
    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt)//GEN-FIRST:event_treeValueChanged
    {//GEN-HEADEREND:event_treeValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) evt.getPath().getLastPathComponent();        
        showChildren(node);        
        System.out.println(node);        
        jEditorPaneFolderPath.setText(node.toString());
    }//GEN-LAST:event_treeValueChanged

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_copyButtonActionPerformed
    {//GEN-HEADEREND:event_copyButtonActionPerformed
        
        new copyFile().setVisible(true);
    }//GEN-LAST:event_copyButtonActionPerformed

    private void cutButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cutButtonActionPerformed
    {//GEN-HEADEREND:event_cutButtonActionPerformed
        new moveFile().setVisible(true);
    }//GEN-LAST:event_cutButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteButtonActionPerformed
    {//GEN-HEADEREND:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newButtonActionPerformed
    {//GEN-HEADEREND:event_newButtonActionPerformed

        new newFile().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonActionPerformed

    private void terminalInputKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_terminalInputKeyPressed
    {//GEN-HEADEREND:event_terminalInputKeyPressed

        int key = evt.getKeyCode();
        
        if (key == KeyEvent.VK_ENTER)
        {     
            execute_command();  
        }
        else
        {
            System.out.println("Enter or control not pressed");
        }
        
    }//GEN-LAST:event_terminalInputKeyPressed

    public static void main(String args[])
    {

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (Exception e) { 
            
            System.out.println("Error setting native LAF: " + e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new Fm_final().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copyButton;
    private javax.swing.JButton cutButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JEditorPane jEditorPaneFolderPath;
    private javax.swing.JPanel jPanelTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JScrollPane jScrollPane_right;
    private javax.swing.JTextArea jTextArea_belowTree;
    private javax.swing.JTextArea jTextArea_tree_file_properties;
    private javax.swing.JTextArea jTextArea_viewer;
    private javax.swing.JButton newButton;
    private javax.swing.JTable table;
    private javax.swing.JTextField terminalInput;
    private javax.swing.JTextArea terminalOutput;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
}
