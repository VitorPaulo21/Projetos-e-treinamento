package Fxml;

import dao.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import users.Usuario;

public class LoginControler {

	@FXML
	private TextField emailField;
	
	@FXML
	private PasswordField passField;
	
	public void login() {
		
		if (!emailField.getText().isEmpty() && !passField.getText().isEmpty()) {
			
			DAO<Usuario> dao = new DAO<Usuario>();
			
			dao.open().update(new Usuario(emailField.getText(), passField.getText())).close();
		}
		
		
	}
	
}
