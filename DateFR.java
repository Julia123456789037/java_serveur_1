package projet_java.Serveur.java_serveur_1;


import java.util.GregorianCalendar;


/** Projet perso: DateFR, permet d'avoir des dates au format français
 *  
 *  @author  Bondu Justine
 *  @version 1 du 20/03/2023
 */
public class DateFR extends GregorianCalendar
{
	private static String[] tabJour = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};

	//On peut initialiser aussi les static avec le constructeur static {}

    /**
     * constructeur de DateFR avec trois int, exemp:1,4,2023
     * @param j : jour
     * @param m : mois
     * @param y : année
	 */
	public DateFR (int j, int m, int y)
	{
		super (y, m-1, j);
	}
    /**
     * constructeur de DateFR sans paramètre, date d'aujourd'hui
	 */
	public DateFR()
	{
		super();
	}

    /**
     * constructeur de DateFR avec un String, exemp:"16/3/2023"
     * @param j : jour
	 */
	public DateFR (String date)
	{
		// Il le fait par défaut en premier
		super();

		int j, m, y;
		int indSlash  = date.indexOf ('/'               );
		int indSlash2 = date.indexOf ('/', indSlash + 1 );

		j = Integer.parseInt(date.substring (           0 , indSlash     ));
		m = Integer.parseInt(date.substring (indSlash  +1 , indSlash2    ));
		y = Integer.parseInt(date.substring (indSlash2 +1                )); 

		System.out.println (j + "  " + m + "  " + y);


		// On rechange la date
		this.set( y, m-1, j );

		//super (y, m-1, j);
	}

	/**
	 * return le jour de l'objet
	 * @return j : le jour de l'objet
	 */
	public int getJour () {return this.get (GregorianCalendar.DAY_OF_MONTH)    ;}
    /**
	 * return le moi de l'objet
	 * @return m : le moi de l'objet
	 */
	public int getMois () {return this.get (GregorianCalendar.MONTH       ) +1 ;}
    /**
	 * return l'année de l'objet
	 * @return y : l'année de l'objet
	 */
	public int getAnnee() {return this.get (GregorianCalendar.YEAR        )    ;}

	/**
	 * return le nombre de jour qui sépare l'objet courant au paramètre, cela peut être négatif
	 * @param d : dateFR qui peut être la même ou différente de l'objet courant
	 * @return j : le nombre de jour qui sépare les deux dateFR, peut être négatif
	 */
	public int deltaJour( DateFR d ) {return (int)((this.getTimeInMillis() - d.getTimeInMillis()) /(1000/60/60/24));}

	/**
	 * Méthode toString avec jjj jj/mm/aaaa
	 * @return la date française sous forme  jjj jj/mm/aaaa
	 */
	public String toString ()
	{
		int j, m, a;
		int numJour;

		j = this.get (GregorianCalendar.DAY_OF_MONTH)   ;
		m = this.get (GregorianCalendar.MONTH       ) +1;
		a = this.get (GregorianCalendar.YEAR        )   ;

		numJour = this.get(GregorianCalendar.DAY_OF_WEEK);
		
		return   String.format ("%-9s", DateFR.tabJour[numJour-1])   + "  "   +
	             String.format ("%02d",  j )                         + " / "  + 
				 String.format ("%02d",  m )                         + " / "  + 
				 String.format ("%4d" ,  a )                                  ;
	
	}
    /**
     * code de test de la classe, peut être supp
	 */
	public static void main (String[] arg)
	{
		DateFR d1, d2, d3;
		
		d1 = new DateFR (1,4,2023   );
		d2 = new DateFR (           );
		d3 = new DateFR ("16/3/2023");

        System.out.println ();
		System.out.println ( "----------------------------------------------" );
		System.out.println (d1);
        System.out.println ();
        System.out.println ( "------------8-------------" );
		System.out.println (d2);
        System.out.println ();
        System.out.println ( "------------8-------------" );
		System.out.println (d3);
        System.out.println ( "----------------------------------------------" );
        System.out.println ();
	
		
	}
}
