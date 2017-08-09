

import java.awt.dnd.*;
import javax.swing.*;

public class DropTest {

   public static void main(String[] args) {
      SwingUtilities.invokeLater(
         new Runnable() {
            public void run() {
               launchGui();
            }
         });
   }

   public static void launchGui() {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      final JPanel c = new JPanel();
      f.getContentPane().add(c);
      new DropTarget(c,
         new DropTargetAdapter() {
            public void drop(final DropTargetDropEvent e) {
               JOptionPane.showMessageDialog(c, "Test");
            }
         });
      f.setSize(400, 400);
      f.setVisible(true);
   }
}