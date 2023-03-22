package endpoints;
import utils.RestSpecifications;
public class Users extends RestSpecifications{
	
	private final String ENDPOINT = "/api/users";
	private final String fileName = "users7.json";
	
	public void getUsers() {
		getCall(ENDPOINT);
	}
	
	public void getEachUsers(int usersId) {
		getCall(ENDPOINT + "/" + usersId);
	}
	
	public void postUsers() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeJson();
		postCall(ENDPOINT);
	}
	

}
