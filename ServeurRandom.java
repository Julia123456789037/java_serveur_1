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

				out = new PrintWriter(toClient.getOutputStream(), true);

				out.println("Bienvenue sur ServeurSimple1 de " + "Julia"); // bannière
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
