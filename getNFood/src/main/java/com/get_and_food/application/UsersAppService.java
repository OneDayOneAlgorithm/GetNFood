/*
 * 2024 05 07
 * 이상기
 * */
package com.get_and_food.application;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.security.enterprise.credential.Password;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.get_and_food.controller.request.UsersRequest;
import com.get_and_food.controller.response.UsersResponse;
import com.get_and_food.domain.model.Address;
import com.get_and_food.domain.model.Users;
import com.get_and_food.domain.repository.AddressRepository;
import com.get_and_food.domain.repository.UsersRepository;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersAppService {
	
	private final UsersRepository userRepository;
	private final AddressRepository addressRepository;
	
	@Value("${app.firebase-bucket}")
    private String firebaseBucket;
	
	@Transactional
	public UsersResponse.Detail retrieveList(Long userId)
	{
		Users user = userRepository.findById(userId).orElseThrow();
		
		return UsersResponse.Detail.of(user);
	}
	
	@Transactional
	public UsersResponse.Detail createUser(UsersRequest.create request)
	{
		Users user = Users.builder()
				.loginId(request.getLoginId())
				.password(request.getPassword())
				.username(request.getUserName())
				.email(request.getEmail())
				.userPhone(request.getUsePhone())
				.isBusiness(false)
				.address_name(null)
				.build();
				
		
		userRepository.save(user);
		
		return UsersResponse.Detail.of(user);
	}
	
	@Transactional
	public UsersResponse.Detail updateUser(long id, UsersRequest.update request) throws IOException
	{
		Users user = userRepository.findById(id).orElseThrow();
		
		Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(request.getUserPhoto().getBytes());
        Blob blob = bucket.create(user.getLoginId(), content, request.getUserPhoto().getContentType());
		
		/*Address address = addressRepository.findById(request.getAddressId())
				.orElseThrow();*/
		
		user.setAddress_name(request.getAddress());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		user.setUserPhone(request.getUsePhone());
		
		user.setUserPhotoUrl("https://firebasestorage.googleapis.com/v0/b/" + firebaseBucket + "/o/" + blob.getName() + "?alt=media");
		
		userRepository.save(user);
		
		return UsersResponse.Detail.of(user);
	}
	
	
	
	/*
	@Transactional
	public UsersResponse.Detail changeUserAddr(long id, UsersRequest.changeAddr request) {
	    Users user = userRepository.findById(id)
	                               .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
	    
	    Address address = addressRepository.findById(request.getAddressId())
	                                        .orElseThrow(() -> new NoSuchElementException("Address not found with id: " + request.getAddressId()));
	    
	    user.setAddress(address);
	    userRepository.save(user);
	    
	    return UsersResponse.Detail.of(user);
	}
	*/
	
	public Long login(UsersRequest.login request, HttpServletRequest httpRequest) {
        Users user = userRepository.findByLoginId(request.getLoginId());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            HttpSession session = httpRequest.getSession(true);
            session.setAttribute("userId", user.getUserId());
            return user.getUserId();
        }
        return -1L; 
    }
	
	@Transactional
	public void resign(long userId)
	{
		Users user = userRepository.findById(userId).orElseThrow();
		userRepository.delete(user);
	}
	
}
