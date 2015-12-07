/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author ivan
 */
public class TreeModelFile implements TreeModel{

    private String root; // The root identifier

  private Vector listeners; // Declare the listeners vector
  ChannelSftp channelSftp;
  List<LsEntry> ls = new ArrayList<LsEntry>();

  public TreeModelFile(ChannelSftp s, String str) {
  
    channelSftp = s;
    root = str;    
    //ls.add(channelSftp.lstat(str).);
    
    //channelSftp.
    //File tempFile = new File(root);
    //root = tempFile.getParent();

    listeners = new Vector();
  }

    @Override
  public Object getRoot() {
    return root;
  }

    @Override
  public Object getChild(Object parent, int index) {
    File directory = (File) parent;
    String[] directoryMembers = directory.list();
    return (new File(directory, directoryMembers[index]));
  }

    @Override
  public int getChildCount(Object parent) {
    File fileSystemMember = (File) parent;
    if (fileSystemMember.isDirectory()) {
      String[] directoryMembers = fileSystemMember.list();
      return directoryMembers.length;
    }

    else {

      return 0;
    }
  }

    @Override
  public int getIndexOfChild(Object parent, Object child) {
    File directory = (File) parent;
    File directoryMember = (File) child;
    String[] directoryMemberNames = directory.list();
    int result = -1;

    for (int i = 0; i < directoryMemberNames.length; ++i) {
      if (directoryMember.getName().equals(directoryMemberNames[i])) {
        result = i;
        break;
      }
    }

    return result;
  }

    @Override
  public boolean isLeaf(Object node) {
    return ((File) node).isFile();
  }

    @Override
  public void addTreeModelListener(TreeModelListener l) {
    if (l != null && !listeners.contains(l)) {
      listeners.addElement(l);
    }
  }

    @Override
  public void removeTreeModelListener(TreeModelListener l) {
    if (l != null) {
      listeners.removeElement(l);
    }
  }

    @Override
  public void valueForPathChanged(TreePath path, Object newValue) {
    // Does Nothing!
  }

}
