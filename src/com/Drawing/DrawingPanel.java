package com.Drawing;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class DrawingPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnYellow;
	private JRadioButton rdbtnGreen;
	private JRadioButton rdbtnBlue;
	private JRadioButton rdbtnRed;
	private Point point = new Point(0, 0);
	private List<Point> points = new ArrayList<Point>();
	private int countPoints = 0;
	private JPanel drawPanel;
	private JPanel colorPanel;
	private JPanel panel;
	private JRadioButton rdbtnSmall;
	private JRadioButton rdbtnMedium;
	private JRadioButton rdbtnLarge;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private Color currentColor = Color.white;
	private int size = 0;
	/**
	 * Create the panel.
	 */
	public DrawingPanel() {
		setLayout(null);

		drawPanel = new JPanel();
		drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				point = new Point(e.getX(), e.getY());
				Graphics g = drawPanel.getGraphics();
				g.setColor(currentColor);
				g.fillOval(e.getX(), e.getY(), size, size);
			}
		});
		drawPanel.setBounds(145, 11, 295, 278);
		drawPanel.setBackground(Color.white);
		add(drawPanel);

		colorPanel = new JPanel();
		colorPanel.setName("Color");
		colorPanel.setBounds(10, 24, 125, 134);
		add(colorPanel);

		rdbtnRed = new JRadioButton("Red");
		rdbtnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentColor = Color.red;
			}
		});
		rdbtnRed.setBounds(6, 7, 123, 23);
		buttonGroup.add(rdbtnRed);

		rdbtnBlue = new JRadioButton("Blue");
		rdbtnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentColor = Color.blue;
			}
		});
		rdbtnBlue.setBounds(6, 33, 109, 23);
		buttonGroup.add(rdbtnBlue);

		rdbtnGreen = new JRadioButton("Green");
		rdbtnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentColor = Color.green;
			}
		});
		rdbtnGreen.setBounds(6, 56, 109, 23);
		buttonGroup.add(rdbtnGreen);

		rdbtnYellow = new JRadioButton("Yellow");
		rdbtnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentColor = Color.yellow;
			}
		});
		rdbtnYellow.setBounds(6, 82, 109, 23);
		buttonGroup.add(rdbtnYellow);
		colorPanel.setLayout(null);
		colorPanel.add(rdbtnRed);
		colorPanel.add(rdbtnBlue);
		colorPanel.add(rdbtnGreen);
		colorPanel.add(rdbtnYellow);
		
		JButton btnAnotherColor = new JButton("Another color");
		btnAnotherColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentColor = JColorChooser.showDialog(DrawingPanel.this, "Choose", currentColor);
			}
		});
		btnAnotherColor.setBounds(0, 111, 123, 23);
		colorPanel.add(btnAnotherColor);
		
		panel = new JPanel();
		panel.setBounds(10, 169, 125, 120);
		add(panel);
		panel.setLayout(null);
		
		rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = 6;
			}
		});
		buttonGroup_1.add(rdbtnMedium);
		rdbtnMedium.setBounds(6, 42, 100, 23);
		panel.add(rdbtnMedium);
		
		rdbtnLarge = new JRadioButton("Large");
		rdbtnLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size=10;
			}
		});
		buttonGroup_1.add(rdbtnLarge);
		rdbtnLarge.setBounds(6, 77, 100, 23);
		panel.add(rdbtnLarge);
		
		rdbtnSmall = new JRadioButton("Small");
		rdbtnSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				size = 3;
			}
		});
		buttonGroup_1.add(rdbtnSmall);
		rdbtnSmall.setBounds(6, 5, 100, 23);
		panel.add(rdbtnSmall);

	}
}
