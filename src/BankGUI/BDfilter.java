/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankGUI;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author offic
 */
public class BDfilter extends FileFilter {

    public BDfilter() {
    }

    @Override
    public boolean accept(File f) {
        if(f.isDirectory() || f.getName().toLowerCase().endsWith(".bdf")){
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
           return "Bank Database File";
    }
    
}
