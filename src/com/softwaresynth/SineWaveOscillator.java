package com.softwaresynth;

public class SineWaveOscillator extends Oscillator
{

	public SineWaveOscillator(int Samplerate, int Buffersize)
	{
		super(Samplerate, Buffersize);
	}
	@Override
	protected void oscillate(int buffersize)
	{
		//Needed variables
		short amplitude = 30000; //Amplitude of the wave
		short lastsample = -30000; //Used in generating the wave, here we start at the negative amplitude
		int i = 0;
		
        int bufi = 0;
        int bufferswritten = 0;
        byte[] buf = new byte[buffersize]; //A 2-byte buffer to hold each sample
		//int slope = (amplitude * 2) / samples_per_cycle; //How much should the sample increase or decrease each step?
        
		while (this.play)
		{
			//sin
			lastsample = (short) ((int)amplitude*Math.sin(
												(
														(2*Math.PI*frequency*i)/16000
												)));
			
			//Converts the lastsample short into a byte[] array to send to the stream.
			buf[bufi*2] = (byte)(lastsample & 0xff);
			buf[bufi*2+1] = (byte)((lastsample >> 8) & 0xff);
			//System.out.println("Calculated audio data");
			
            bufi++;
			i++;
            
            if (2 * bufi >= buffersize)
            {
                //Sends the data to the stream.
            	//System.out.println("Just wrote audio data");
                line.write(buf,0,buffersize);
                bufi = 0;
                bufferswritten++;
                if (bufferswritten % 1000 == 0)
                {
                    //System.out.println("Wrote " + bufferswritten + " buffers.");
                    //line.stop();
                }
            }
		}
	}

	@Override
	public Oscillator newInstance()
	{
		return new SineWaveOscillator(samplerate,buffersize);
	}

	@Override
	public String getType()
	{
		return "SineWaveOscillator";
	}

}
