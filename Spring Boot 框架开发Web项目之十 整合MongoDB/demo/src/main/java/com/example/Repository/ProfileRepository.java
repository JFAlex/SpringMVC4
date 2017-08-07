package com.example.Repository;

import com.example.dto.ProfileForm;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface  ProfileRepository extends MongoRepository<ProfileForm,String> {
    ProfileForm findByTwitterHandle(String twitterHandle);
}
