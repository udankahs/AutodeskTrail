package com.email.scripts;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

class CheckboxCellRenderer extends DefaultListCellRenderer {
	  protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

	  public Component getListCellRendererComponent(JList list, Object value, int index,
	      boolean isSelected, boolean cellHasFocus) {
	    if (value instanceof CheckBoxListEntry) {
	    	CheckBoxListEntry checkbox = (CheckBoxListEntry) value;
	      checkbox.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
	      if (checkbox.isRed()) {
	        checkbox.setForeground(Color.red);
	      } else {
	        checkbox.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
	      }
	      checkbox.setEnabled(isEnabled());
	      checkbox.setFont(getFont());
	      checkbox.setFocusPainted(false);
	      checkbox.setBorderPainted(true);
	      checkbox.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder")
	          : noFocusBorder);

	      return checkbox;
	    } else {
	      return super.getListCellRendererComponent(list, value.getClass().getName(), index,
	          isSelected, cellHasFocus);
	    }
	  }
	}

public class temp2 {

	public static void main(String[] args) {
		new CheckBoxList();
	}
}
