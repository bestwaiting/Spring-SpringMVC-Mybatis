package bestwaiting.service;

import bestwaiting.model.UserBean;

public interface ILoginService {
	public UserBean Login(String name,String pwd);
}
