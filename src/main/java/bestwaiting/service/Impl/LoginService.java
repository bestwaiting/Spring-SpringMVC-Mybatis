package bestwaiting.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bestwaiting.mapper.UserMapper;
import bestwaiting.model.UserBean;
import bestwaiting.service.ILoginService;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private UserMapper userMapper;
	
	public UserBean Login(String name, String pwd) {
		// TODO Auto-generated method stub
		return userMapper.login(name, pwd);
	}

}
