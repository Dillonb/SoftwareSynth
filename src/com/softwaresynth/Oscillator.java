package com.softwaresynth;
import javax.sound.sampled.*;


public abstract class Oscillator 
{
	double frequency;
	Thread thread;
	int samplerate = -1;
	int buffersize = -1;
	boolean play = false;
	boolean busy = false;
	//static ArrayList<Oscillator> oscillators = new ArrayList<Oscillator>();
	SourceDataLine line = null;

	/*
	 * Gets a new instance of the correct type.
	 * @returns a new instance of the correct type.
	 */
	public abstract Oscillator newInstance();
	/*
	 * Gets the type of the oscillator
	 * @returns the standard string name of the oscillator subclass
	 */
	public abstract String getType();
	public void start(Note note)
	{
		start(note.getFrequency());
	}
	/*
	 * Starts the oscillator
	 * @param frequency What frequency to play
	 */
	public void start(double frequency)
	{
		if (busy)
			return;
		this.play = true;
		this.busy = true;
		this.frequency = frequency;
		thread = new Thread(new Runnable()
		{
			public void run()
			{
				oscillate(buffersize);
				busy = false;
			}
		});
		thread.start();
	}
	/*
	 * Stops the oscillator
	 */
	public void stop()
	{
		this.play = false;
		this.busy = false;
		thread.interrupt();
		//line.pause();
		line.flush();
	}
	public Oscillator(int Samplerate, int Buffersize)
	{
		System.out.println("Created a new " + getType() + "samplerate: " + Samplerate + " buffersize: " + Buffersize);
		initialize(Samplerate, Buffersize);
	}
	/*
	 * Creates a sourceDataLine and other initialization things
	 * @param samplerate The sample rate of the generated waveform
	 */
	public void initialize(int Samplerate, int Buffersize)
	{
		samplerate = Samplerate;
		buffersize = Buffersize;
		AudioFormat af = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, samplerate, 16, 1, 2, samplerate, false);
		//Initialize the data line
		try
		{
			line = AudioSystem.getSourceDataLine(af);
			line.open(af);
		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
			System.exit(1);
		
		}
		line.start();
	}
	/*
	 * Gets whether or not the oscillator is currently oscillating.
	 */
	public boolean isBusy()
	{
		return busy;
	}
	public double getFrequency()
	{
		return frequency;
	}
	/*
	 * Oscillates the oscillator. The frequency is defined in a double instance variable, data should be written to the
	 * SourceDataLine in the "line" instance variable
	 * @param buffersize How large of a buffer should be generated?
	 */
	protected abstract void oscillate(int buffersize);
}