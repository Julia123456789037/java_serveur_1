package projet_java.Serveur.java_serveur_1;

import java.net.*;
import java.io.*;

/** 
 * 
 * @author BONDU justine
 * @version 1 du 22/03/23
 */

public class ServeurRandom
{

	public static void main(String[] argv)
	{
		/*-----------------*/
		/* Données         */
		/*-----------------*/
		
		/* Variables       */
		/*-----------------*/
		
		ServerSocket    ss;
		Socket          toClient;
		PrintWriter     out;
		BufferedReader  in;
		String			test;
        boolean			sortir;
		
		/*-----------------*/
		/* Instructions    */
		/*-----------------*/


		while ( true  )
		{
			System.out.println ("attente d’un client..."); 
			try
			{
				ss = new ServerSocket(9000);
				System.out.println ("client arrivé..."); 
				toClient = ss.accept();
				sortir = false;
				DateFR d1;

				out = new PrintWriter(toClient.getOutputStream(), true);

				out.println("Bienvenue sur ServeurSimple1 de " + "Justine"); // bannière

				in = new BufferedReader(new InputStreamReader(toClient.getInputStream()));
                do 
                {
                    out.println( sortir );
                    test = in.readLine();
					d1 = new DateFR ( );
                    if ( ! sortir || ! test.equals (""))
                    {
                        switch( test.charAt (0) )
                        {
                            case 'd' -> out.println("Nous somme le " + d1);
                            case 'm' -> out.println("Nous somme le " + d1);
                            case 'b' -> out.println("Bienvenue sur ServeurInfos de " + "Julia");
                            case 'q' -> sortir = true;
                            default -> out.println("defaut");
                        }
                    }
                    else { sortir = true; }
                    
                    System.out.println (test);
                    out.println(test);
                }while ( sortir != true);


				out.close();
				toClient.close();
				ss.close();
			}
			catch(IOException ioe)
			{
				System.out.println ("Erreur"); 
			}
		}
		

		
		
	}
}
