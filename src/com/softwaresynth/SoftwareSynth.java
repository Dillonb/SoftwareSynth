package com.softwaresynth;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SoftwareSynth extends JFrame implements KeyListener,
		ActionListener {
	static final long serialVersionUID = 1;
	static final int samplerate = 44100;
	String oscType = "SquareWaveOscillator";
	
	JTextField typingArea;

	static boolean play = false;
	Keyboard keyboard;

	private static void guiInit() {
		SoftwareSynth frame = new SoftwareSynth();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponents();
		System.out.println("Setting frame to visible");
		frame.pack();
		frame.setVisible(true);
	}

	private void addComponents() {
		System.out.println("addComponents() called");
		keyboard = new QwertyKeyboard();
		JLabel label = new JLabel("Play notes in this window.");
		typingArea = new JTextField(20);
		typingArea.addKeyListener(this);
		typingArea.setEditable(false);
		this.getContentPane().add(label, BorderLayout.CENTER);
		this.getContentPane().add(typingArea, BorderLayout.PAGE_END);
		this.getContentPane().addKeyListener(this);
		Thread thread = new Thread(new Runnable()
		{
			public void run()
			{
				// this will be run in a separate thread
				oscillatorInit();
			}
		});
		thread.start();
	}

	public static void main(String[] args) {
		// Note note = new Note("C0");
		// System.out.println(note.frequency);
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				guiInit();
			}
		});
	}

	OscillatorManager oscs;
	public void oscillatorInit() {
//		swq = new SquareWaveOscillator();
//		swq.initialize(44100, 40);
		oscs = new OscillatorManager();
		oscs.registerNewType(new SquareWaveOscillator(44100,40));
        oscs.registerNewType(new TriangleWaveOscillator(44100,40));
		// swq.start(400);
	}
	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Key pressed: " + e.getKeyCode());
//		if (!swq.isBusy()) {
//			swq.start(keyboard.keyToNote(e.getKeyCode()).getFrequency());
//		}
		try
		{
			oscs.get(oscType).start(keyboard.keyToNote(e.getKeyCode()));
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	// Implemented because KeyListener interface requires it
	public void keyTyped(KeyEvent e)
	{
	}
	public void keyReleased(KeyEvent e)
	{
		Oscillator osc = oscs.getPlaying(oscType,keyboard.keyToNote(e.getKeyCode()).getFrequency());
		if (osc != null)
			osc.stop();
		// play = false;
		// System.out.println("Key released");
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Action performed");
	}
}
