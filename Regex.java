package Projets;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * class about regular expression
 * 
 * @author simon_bens
 *
 */
public class Regex {

	// 1) EMAIL_PATTERN :
	
	// a) AlphaNum@AlphNum.com --> ex : abc@gmail.com

	/*b) Detail expression :
	 * -> "^" - "$" => début et fin de l'expression limitation
	 * - >"[a-zA-Z0-9]" => prend toutes lettres de a-z en minuscule et majuscule plus les chiffres de 0-9
	 * -> "{1,20}" => longueur de la chaine : 1 a 20 caractères
	 * ->"@" et " ." => symbole de l'email
	 */
	
public static final   String EMAIL_PATTERN = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";  
JTextField[] tf_name;
public Regex(JTextField[] tf_name){
	this.tf_name = tf_name;
}
public  void emailPattern( JTextField tf_mail)
{
	
	Pattern p = Pattern.compile(EMAIL_PATTERN);

	Matcher mat = p.matcher(tf_mail.getText());

	if (! mat.matches())
	{
		System.out.println( "OK-[REGEX EMAIL]");
		
	}else
	{
		JOptionPane.showMessageDialog(null,  "Email is incorrect ... PLease try again ");

	}
}


}
