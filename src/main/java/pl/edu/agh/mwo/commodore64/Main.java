package pl.edu.agh.mwo.commodore64;

public class Main
{
	public static void main(String[] args)
	{
		String path = Intro.welcomePage();
		//tworzenie tabeli zbiorczej
		//stworzenie Workbooka do tabeli zbiorczej, kt�ry b�dzie przekazywany do funkcji
		//usuni�cie tabeli zbiorczej
		PathCommander.getPath(path);
	}
}
