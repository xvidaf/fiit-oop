package osoba;

import java.io.Serializable;

import javafx.stage.Stage;

/**
 * An abstract class from which we start inheritance
 * @author vidaf
 *
 */
public abstract class Clovek implements Serializable{
	protected String login;
	protected String passwd;
	protected String meno;
	
	/** Logs the user in
	 * @param loginStage
	 */
	public abstract void login(Stage loginStage);
	
	public String getMeno() {
		return meno;
	}
	public void setMeno(String meno) {
		this.meno = meno;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
