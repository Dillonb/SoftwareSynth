package com.softwaresynth;

import java.util.Hashtable;

public class Note
{
	private double frequency = 0;
	private static Hashtable<String, Double> notes = null;
	public double getFrequency()
	{
		return frequency;
	}
	private void initHt()
	{
		//Check if the hashtable is already initialized
		if (notes != null)
			return;
		notes = new Hashtable<String, Double>();
		String tempstr = "C0	 16.35	2100.\n"+
 						 "C#0/Db0	 17.32	1990.\n"+
 						 "D0	 18.35	1870.\n"+
						 "D#0/Eb0	 19.45	1770.\n"+
						 "E0	 20.60	1670.\n"+
						 "F0	 21.83	1580.\n"+
						 "F#0/Gb0	 23.12	1490.\n"+
						 "G0	 24.50	1400.\n"+
						 "G#0/Ab0	 25.96	1320.\n"+
						 "A0	 27.50	1250.\n"+
						 "A#0/Bb0	 29.14	1180.\n"+
						 "B0	 30.87	1110.\n"+
						 "C1	 32.70	1050.\n"+
						 "C#1/Db1	 34.65	996.\n"+
						 "D1	 36.71	940.\n"+
						 "D#1/Eb1	 38.89	887.\n"+
						 "E1	 41.20	837.\n"+
						 "F1	 43.65	790.\n"+
						 "F#1/Gb1	 46.25	746.\n"+
						 "G1	 49.00	704.\n"+
						 "G#1/Ab1	 51.91	665.\n"+
						 "A1	 55.00	627.\n"+
						 "A#1/Bb1	 58.27	592.\n"+
						 "B1	 61.74	559.\n"+
						 "C2	 65.41	527.\n"+
						 "C#2/Db2	 69.30	498.\n"+
						 "D2	 73.42	470.\n"+
						 "D#2/Eb2	 77.78	444.\n"+
						 "E2	 82.41	419.\n"+
						 "F2	 87.31	395.\n"+
						 "F#2/Gb2	 92.50	373.\n"+
						 "G2	 98.00	352.\n"+
						 "G#2/Ab2	 103.83	332.\n"+
						 "A2	 110.00	314.\n"+
						 "A#2/Bb2	 116.54	296.\n"+
						 "B2	 123.47	279.\n"+
						 "C3	 130.81	264.\n"+
						 "C#3/Db3	 138.59	249.\n"+
						 "D3	 146.83	235.\n"+
						 "D#3/Eb3	 155.56	222.\n"+
						 "E3	 164.81	209.\n"+
						 "F3	 174.61	198.\n"+
						 "F#3/Gb3	 185.00	186.\n"+
						 "G3	 196.00	176.\n"+
						 "G#3/Ab3	 207.65	166.\n"+
						 "A3	 220.00	157.\n"+
						 "A#3/Bb3	 233.08	148.\n"+
						 "B3	 246.94	140.\n"+
						 "C4	 261.63	132.\n"+
						 "C#4/Db4	 277.18	124.\n"+
						 "D4	 293.66	117.\n"+
						 "D#4/Eb4	 311.13	111.\n"+
						 "E4	 329.63	105.\n"+
						 "F4	 349.23	98.8\n"+
						 "F#4/Gb4	 369.99	93.2\n"+
						 "G4	 392.00	88.0\n"+
						 "G#4/Ab4	 415.30	83.1\n"+
						 "A4	 440.00	78.4\n"+
						 "A#4/Bb4	 466.16	74.0\n"+
						 "B4	 493.88	69.9\n"+
						 "C5	 523.25	65.9\n"+
						 "C#5/Db5	 554.37	62.2\n"+
						 "D5	 587.33	58.7\n"+
						 "D#5/Eb5	 622.25	55.4\n"+
						 "E5	 659.26	52.3\n"+
						 "F5	 698.46	49.4\n"+
						 "F#5/Gb5	 739.99	46.6\n"+
						 "G5	 783.99	44.0\n"+
						 "G#5/Ab5	 830.61	41.5\n"+
						 "A5	 880.00	39.2\n"+
						 "A#5/Bb5	 932.33	37.0\n"+
						 "B5	 987.77	34.9\n"+
						 "C6	 1046.50	33.0\n"+
						 "C#6/Db6	 1108.73	31.1\n"+
						 "D6	 1174.66	29.4\n"+
						 "D#6/Eb6	 1244.51	27.7\n"+
						 "E6	 1318.51	26.2\n"+
						 "F6	 1396.91	24.7\n"+
						 "F#6/Gb6	 1479.98	23.3\n"+
						 "G6	 1567.98	22.0\n"+
						 "G#6/Ab6	 1661.22	20.8\n"+
						 "A6	 1760.00	19.6\n"+
						 "A#6/Bb6	 1864.66	18.5\n"+
						 "B6	 1975.53	17.5\n"+
						 "C7	 2093.00	16.5\n"+
						 "C#7/Db7	 2217.46	15.6\n"+
						 "D7	 2349.32	14.7\n"+
						 "D#7/Eb7	 2489.02	13.9\n"+
						 "E7	 2637.02	13.1\n"+
						 "F7	 2793.83	12.3\n"+
						 "F#7/Gb7	 2959.96	11.7\n"+
						 "G7	 3135.96	11.0\n"+
						 "G#7/Ab7	 3322.44	10.4\n"+
						 "A7	 3520.00	 9.8\n"+
						 "A#7/Bb7	 3729.31	 9.3\n"+
						 "B7	 3951.07	 8.7\n"+
						 "C8	 4186.01	 8.2\n"+
						 "C#8/Db8	 4434.92	 7.8\n"+
						 "D8	 4698.64	 7.3\n"+
						 "D#8/Eb8	 4978.03	 6.9";
		String[] lines = tempstr.split("\n");
		for (String line: lines)
		{
			String[] line_proc = line.split("\\s");
			String[] notename_proc = line_proc[0].split("/");
			if (notename_proc.length > 1)
			{
				for (String notename: notename_proc)
				{
					notes.put(notename,Double.parseDouble(line_proc[2]));
				}
			}
			else
			{
				notes.put(notename_proc[0],Double.parseDouble(line_proc[2]));
			}
		}
	}
	public Note(String name)
	{
		//System.out.println(name);
		initHt();
		this.frequency = notes.get(name);
	}
	public Note(double frequency)
	{
		this.frequency = frequency;
	}
}
