package com.softwaresynth;

public class QwertyKeyboard extends Keyboard 
{
	@Override
	public Note keyToNote(int num)
	{
		switch(num)
		{
			case 65:
				return new Note("C4");
			case 83:
				return new Note("D4");
			case 68:
				return new Note("E4");
			case 70:
				return new Note("F4");
			case 71:
				return new Note("G4");
			case 72:
				return new Note("A4");
			case 74:
				return new Note("B4");
			case 75:
				return new Note("C5");
			case 76:
				return new Note("D5");
			case 59:
				return new Note("E5");
			case 222:
				return new Note("F5");
			case 10:
				return new Note("G5");

			//Sharps and flats

			//case 81:
			//	return new Note("B#4")
			case 87:
				return new Note("C#4");
			case 69:
				return new Note("D#4");
			// case 82:
			// 	return new Note("E#4");
			case 84:
				return new Note("F#4");
			case 89:
				return new Note("G#4");
			case 85:
				return new Note("A#4");
			// case 73:
			// 	return new Note("B#4");
			case 79:
				return new Note("C#5");
			case 80:
				return new Note("D#5");
			// case 91:
			// 	return new Note("E#4");
			case 93:
				return new Note("F#5");
			case 92:
				return new Note("G#5");
		}
		return new Note("C0");
	}

}
