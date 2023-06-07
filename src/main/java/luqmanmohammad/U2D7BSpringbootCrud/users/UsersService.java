package luqmanmohammad.U2D7BSpringbootCrud.users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepo;
	
	//crea un utente dato uno User u e lo salva
	public User create(User u) {
		return usersRepo.save(u);
	}
	
	//restituire un lista di utenti
	public List<User> find(){
		return usersRepo.findAll();
	}
	
	
	//ritorna un utente dato un id
	public User findById(UUID id) throws Exception{
		return usersRepo.findById(id).orElseThrow(()-> new Exception("Utente non trovato"));
	}
	
	//dato un id modificalo
	public User findByIdAndUpdate(UUID id, User u) throws Exception {
		User found = this.findById(id);
		found.setId(id);
		found.setName(u.getName());
		found.setSurname(u.getSurname());
		found.setEmail(u.getEmail());
		return usersRepo.save(found);
	}
	
	
	//dato un id eliminalo
	public void findByIdAndDelete(UUID id) throws Exception {
		User found = this.findById(id);
		usersRepo.delete(found);
	}
}
