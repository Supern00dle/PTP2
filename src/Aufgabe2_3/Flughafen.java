/**
 * Programmiertechnik 2 Aufgabenblatt 2
 * 10.11.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe2_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Aufgabe2_3.Flughafen;
import Aufgabe2_3.Flugzeug;

public class Flughafen extends Thread
{
	private int maxAnzahlFlugzeuge;
	private List<Flugzeug> flugzeuge;
	private int index;

	public Flughafen(int maxAnzhalFlugzeuge)
	{
		this.maxAnzahlFlugzeuge = maxAnzhalFlugzeuge;
		flugzeuge = new ArrayList<Flugzeug>();
		index = 0;
	}

	@Override
	public void run() 
	{
		while (!isInterrupted())
		{
			if (flugzeuge.size() < maxAnzahlFlugzeuge)
			{
				Flugzeug flugzeug = erzeugeFlugzeug(
						(int) (10000 * Math.random()), "Flugzeug " + index);
				flugzeug.start();
				flugzeuge.add(flugzeug);
			}
			for (int i = 0; i < flugzeuge.size(); i++)
			{
				Flugzeug flug = flugzeuge.get(i);
				flug.setZeit((int) (LocalTime.now().toNanoOfDay() / 1000000));

				if (flug.istGelandet())
				{
					flugzeuge.remove(i);
					flug.interrupt();
					System.out.println(flug.toString() + "\n");
				}
				else
				{
					System.out.println(flug.toString() + "\n\n");
				}
			}

			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Flugzeug erzeugeFlugzeug(int flugdauer, String id)
	{
		index++;
		return new Flugzeug(id, flugdauer, this,
				(int) (LocalTime.now().toNanoOfDay() / 1000000));
	}

	public synchronized void landen(Flugzeug flugzeug)
	{
		try
		{
			Thread.sleep(1500);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flugzeug.gelandet();
	}

	public static void main(String[] args)
	{
		Flughafen hafen = new Flughafen(5);
		hafen.start();

	}
}
