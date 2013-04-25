package com.main.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import com.main.steps.Split;

public class TransUI extends JFrame {
	
	private JTextArea srcText;
	private JTextArea transText;
	JButton 
		splitBtn = new JButton("Split"),
		tokenizeBtn = new JButton("Tokenize"),
		tagBtn = new JButton("POS Tag"),
		chunkBtn = new JButton("Chunk"),
		reorderBtn = new JButton("Reorder"),
		translateBtn = new JButton("Translate"),
		resetBtn = new JButton("Reset"),
		clearBtn = new JButton("Clear");
	
	public TransUI() {
	 super("English to Telugu Translator");
	 createUI();
	 setSize(800,600);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createUI(){
		Container co = getContentPane();
		co.removeAll();
		co.setLayout(new BorderLayout());
		
		JSplitPane textPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		{
			JPanel srcTextPanel = new JPanel(new BorderLayout());
			{
				JLabel l1 = new JLabel("Enter text to be translated in English:");
				srcTextPanel.add(l1, BorderLayout.NORTH);
				
				srcText = new JTextArea();
				srcText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				srcText.setAutoscrolls(true);
				srcTextPanel.add(srcText, BorderLayout.CENTER);
			}
			textPanel.add(srcTextPanel);
			
			JPanel transTextPanel = new JPanel(new BorderLayout());
			{
				transText = new JTextArea();
				transText.setAutoscrolls(true);
				transTextPanel.add(transText, BorderLayout.CENTER);
			}
			textPanel.add(transTextPanel);
		}
		textPanel.setResizeWeight(0.5);
		co.add(textPanel, BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel(new GridLayout(8, 1));
		{
			splitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Vector<String> sentences = Split.executeStep(srcText.getText());
					StringBuffer buffer = new StringBuffer();
					for(String s : sentences){
						buffer.append(s+".\n\n");
					}
					transText.setText( buffer.toString() );
				}
			});
			btnPanel.add(splitBtn); 
			
			btnPanel.add(tokenizeBtn);
			btnPanel.add(tagBtn); 
			btnPanel.add(chunkBtn);
			btnPanel.add(reorderBtn); 
			btnPanel.add(translateBtn);
			btnPanel.add(resetBtn); 
			
			clearBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					srcText.setText("");
				}
			});
			btnPanel.add(clearBtn);
		}
		co.add(btnPanel, BorderLayout.WEST);		
	}
}
