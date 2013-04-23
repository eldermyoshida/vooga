package util;

/**
 * Interface that ensures that an object that handles e-mails
 * will have all the necessary information
 * @author Henrique Moraes
 *
 */
public interface IMail {

	public void setProperties(String from, String[] to,
			String server, String subject, String message);
}
