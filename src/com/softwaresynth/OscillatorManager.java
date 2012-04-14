package com.softwaresynth;
import java.util.Hashtable;
import java.util.ArrayList;

public class OscillatorManager
{
	static Hashtable<String,ArrayList<Oscillator>> oscillators;
	static Hashtable<String,Oscillator> oscillatorTypes;

	public OscillatorManager()
	{
		if (oscillators == null)
			oscillators = new Hashtable<String,ArrayList<Oscillator>>();
		if (oscillatorTypes == null)
			oscillatorTypes = new Hashtable<String,Oscillator>();
	}
	public void registerNewType(Oscillator instance)
	{
		//System.out.println("Registering " + instance.getType());
		if (!oscillatorTypes.containsKey(instance.getType()))
		{
			oscillatorTypes.put(instance.getType(),instance);
			oscillators.put(instance.getType(),new ArrayList<Oscillator>());
		}
	}
	/*
	 * Gets an oscillator that is not busy
	 * @param type What type of oscillator to get
	 * @return An idle oscillator
	 */
	public Oscillator get(String type) throws Exception
	{
		ArrayList<Oscillator> oscs = oscillators.get(type);
		if (oscs == null)
		{
			//System.out.println("");
		}
		for (Oscillator osc: oscs)
		{
			if (!osc.isBusy())
			{
				return osc;
			}
		}
		//No existing oscillators are free, create a new one.
		Oscillator osc = null;
		if (oscillatorTypes.containsKey(type))
			osc = oscillatorTypes.get(type).newInstance();
		else
			throw new Exception("Unknown type: " + type);
		oscs.add(osc);
		return osc;
	}
	/*
	 * Gets an oscillator that is currently playing
	 * @param frequency What frequency the oscillator is currently playing
	 * @returns an Oscillator
	 */
	public Oscillator getPlaying(String type, double frequency)
	{
		ArrayList<Oscillator> oscs = oscillators.get(type);
		for (Oscillator osc: oscs)
		{
			if (osc.getFrequency() == frequency)
				return osc;
		}
		return null;
	}
}