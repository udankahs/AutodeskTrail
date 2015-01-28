package com.email.scripts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.Scrollable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class temp1 {

	public static void main(String[] args) {
		new temp1();
	}

	public temp1() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new GridLayout(0, 2));
				// frame.add(new CheckBoxGroup(new String[]{"Bananas",
				// "Oranages", "Apples", "Pears"}));
				frame.add(new CheckBoxGroup(new String[] { "Learn Archery",
						"Float in the dead sea", "Swing with a whale shark",
						"Sail the greek islands", "Go skydiving",
						"Dance in the rain", "Cycle through the Netherlands" }));
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	public class CheckBoxGroup extends JPanel {

		private JCheckBox all;
		private List<JCheckBox> checkBoxes;

		// JButton button;

		public CheckBoxGroup(String... options) {
			checkBoxes = new ArrayList<>(25);
			setLayout(new BorderLayout());
			final JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 1,
					1));

			// button = new JButton("Is JCheckBox selected?");
			// button.addActionListener(new ActionListener() {
			// @Override
			// public void actionPerformed(ActionEvent ae) {
			// if (all.isSelected()) {
			// JOptionPane.showMessageDialog(header,
			// "JCheckBox is selected");
			// } else {
			// JOptionPane.showMessageDialog(header,
			// "JCheckBox is NOT selected");
			//
			// }
			// }
			// });

			all = new JCheckBox("Select All...");
			all.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (JCheckBox cb : checkBoxes) {
						cb.setSelected(all.isSelected());
					}
				}
			});

			header.add(all);
			add(header, BorderLayout.NORTH);

			// header.add(button);
			// add(header, BorderLayout.SOUTH);

			JPanel content = new ScrollablePane(new GridBagLayout());
			content.setBackground(UIManager.getColor("List.background"));
			if (options.length > 0) {

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				gbc.anchor = GridBagConstraints.NORTHWEST;
				gbc.weightx = 1;
				for (int index = 0; index < options.length - 1; index++) {
					final JCheckBox cb = new JCheckBox(options[index]);
					cb.setOpaque(false);
					checkBoxes.add(cb);
					content.add(cb, gbc);

					cb.addActionListener(new ActionListener() {
						public void focusGained(ActionEvent e) {
							if (cb.hasFocus() == true) {
								System.out.print(cb.getText());
							}
						}

						@Override
						public void actionPerformed(ActionEvent e) {
							if (cb.isSelected() == true) {
								System.out.println(cb.getText());
							}
							else if (cb.isSelected() == false) {
								System.out.println(cb.getText());
							}

						}
					}
					
							);

				}

				JCheckBox cb = new JCheckBox(options[options.length - 1]);
				cb.setOpaque(false);
				checkBoxes.add(cb);
				gbc.weighty = 1;
				content.add(cb, gbc);

			}

			add(new JScrollPane(content));
		}

		public class ScrollablePane extends JPanel implements Scrollable {

			public ScrollablePane(LayoutManager layout) {
				super(layout);
			}

			@Override
			public Dimension getPreferredScrollableViewportSize() {
				return new Dimension(250, 200);
			}

			@Override
			public int getScrollableUnitIncrement(Rectangle visibleRect,
					int orientation, int direction) {
				return 32;
			}

			@Override
			public int getScrollableBlockIncrement(Rectangle visibleRect,
					int orientation, int direction) {
				return 32;
			}

			@Override
			public boolean getScrollableTracksViewportWidth() {
				boolean track = false;
				Container parent = getParent();
				if (parent instanceof JViewport) {
					JViewport vp = (JViewport) parent;
					track = vp.getWidth() > getPreferredSize().width;
				}
				return track;
			}

			@Override
			public boolean getScrollableTracksViewportHeight() {
				boolean track = false;
				Container parent = getParent();
				if (parent instanceof JViewport) {
					JViewport vp = (JViewport) parent;
					track = vp.getHeight() > getPreferredSize().height;
				}
				return track;
			}
		}
	}
}