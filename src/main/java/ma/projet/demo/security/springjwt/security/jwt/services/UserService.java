package ma.projet.demo.security.springjwt.security.jwt.services;


import ma.projet.demo.security.springjwt.dao.IDAO;
import ma.projet.demo.security.springjwt.models.User;
import ma.projet.demo.security.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class UserService implements IDAO<User> {
	
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User o) {
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User o) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
