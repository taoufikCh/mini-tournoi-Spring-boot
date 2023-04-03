package spring.jpa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import spring.jpa.config.JwtResponse;
import spring.jpa.config.JwtTokenUtil;
import spring.jpa.exception.Message;
import spring.jpa.exception.ResourceNotFoundException;
import spring.jpa.model.User;
import spring.jpa.repository.UserRepository;
import spring.jpa.request.LoginRequest;
import spring.jpa.request.RegisterRequest;
import spring.jpa.service.UserDetailsImpl;
import spring.jpa.service.UserDetailsServiceImpl;

import org.springframework.security.core.userdetails.UserDetails;

@RestController // pour déclarer un service web de type REST
@RequestMapping("/users")  //    http://localhost:8080/user/
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired // pour l'injection de dépendances
	private UserRepository userRepository;

	@Autowired 	
	private AuthenticationManager authenticationManager;

	@Autowired	
	private PasswordEncoder encoder;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired	
	private JwtTokenUtil jwtUtils;
	
	@GetMapping("/")
	public List<User> getAllUtilisateur() {
	    System.out.println("Get all users...");
	 
	    List<User> Utilisateur = new ArrayList<>();
	    userRepository.findAll().forEach(Utilisateur::add);
	 
	    return Utilisateur;
	  }
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUtilisateurById(@PathVariable(value = "id") Long UtilisateurId)
			throws ResourceNotFoundException {
		User Utilisateur = userRepository.findById(UtilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UtilisateurId));
		return ResponseEntity.ok().body(Utilisateur);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long UtilisateurId)
			throws ResourceNotFoundException {
		User Utilisateur = userRepository.findById(UtilisateurId)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found  id :: " + UtilisateurId));

		userRepository.delete(Utilisateur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	 @PutMapping("/{id}")
	  public ResponseEntity<User> updateUtilisateur(@PathVariable("id") long id, @RequestBody User Utilisateur) {
	    System.out.println("Update Utilisateur with ID = " + id + "...");
	 
	    Optional<User> UtilisateurInfo = userRepository.findById(id);
	 
	    if (UtilisateurInfo.isPresent()) {
	    	User utilisateur = UtilisateurInfo.get();
	    	utilisateur.setRole(Utilisateur.getRole());
	    	utilisateur.setEmail(Utilisateur.getEmail());
	    	utilisateur.setUsername(Utilisateur.getUsername());
	    	utilisateur.setPassword(Utilisateur.getPassword());
	      return new ResponseEntity<>(userRepository.save(Utilisateur), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	/* @PostMapping("/login")
		public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest data) {
			System.out.println("login 1");
			System.out.println(data.getPassword());
			System.out.println(data.getUsername());
			Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(data.getUsername(),null));
			//Authentication authentication = new UsernamePasswordAuthenticationToken(data.getUsername(),data.getPassword());
			
			System.out.println("gtetet"+authentication);
			System.out.println("login 2");
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
			System.out.println(jwt);
			System.out.println(userDetails.getUsername());
			System.out.println(userDetails.getRole());
			return ResponseEntity.ok(new JwtResponse(jwt,userDetails.getId(),userDetails.getUsername(), 
													 userDetails.getEmail(), userDetails.getRole())
			);
		}*/
	 @PostMapping("/login")
	    public ResponseEntity<?> loginUser(@RequestBody LoginRequest data) {
	        Map<String, Object> responseMap = new HashMap<>();
	        try {
	            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername()
	                    , data.getPassword()));
	            
	            if (auth.isAuthenticated()) {
	                logger.info("Logged In");
	                //UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(data.getUsername());
	                System.out.println("bbbbb");
					SecurityContextHolder.getContext().setAuthentication(auth);
					String jwt = jwtUtils.generateJwtToken(auth);
					
					UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();	
	                //String token = jwtUtils.generateJwtToken(auth);
	               /* responseMap.put("error", false);
	                responseMap.put("message", "Logged In");
	                responseMap.put("token", token);*/
	                logger.info("token "+jwt);
	                return ResponseEntity.ok(new JwtResponse(jwt, 
							 userDetails.getId(), 
							 userDetails.getUsername(), 
							 userDetails.getEmail(), 
							 userDetails.getRole()));
	                //return ResponseEntity.ok(responseMap);
	            } else {
	                responseMap.put("error", true);
	                responseMap.put("message", "Invalid Credentials");
	                return ResponseEntity.status(401).body(responseMap);
	            }
	        } catch (DisabledException e) {
	            e.printStackTrace();
	            responseMap.put("error", true);
	            responseMap.put("message", "User is disabled");
	            return ResponseEntity.status(500).body(responseMap);
	        } catch (BadCredentialsException e) {
	            responseMap.put("error", true);
	            responseMap.put("message", "Invalid Credentials");
	            return ResponseEntity.status(401).body(responseMap);
	        } catch (Exception e) {
	            e.printStackTrace();
	            responseMap.put("error", true);
	            responseMap.put("message", "Something went wrong");
	            return ResponseEntity.status(500).body(responseMap);
	        }
	        
	    }
	
	
	@PostMapping("/")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new Message("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new Message("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),signUpRequest.getRole());
		userRepository.save(user);

		return ResponseEntity.ok(new Message("User registered successfully!"));
	}

}
