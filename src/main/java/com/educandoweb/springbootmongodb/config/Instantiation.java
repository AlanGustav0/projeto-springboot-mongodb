package com.educandoweb.springbootmongodb.config;

import com.educandoweb.springbootmongodb.domain.Post;
import com.educandoweb.springbootmongodb.domain.User;
import com.educandoweb.springbootmongodb.dto.AuthorDTO;
import com.educandoweb.springbootmongodb.repository.PostRepository;
import com.educandoweb.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null,sdf.parse("25/07/2022"),"Partiu viagem","Viajando para São Paulo",new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("25/07/2022"),"Belo dia","Bom dia São Paulo",new AuthorDTO(maria));


        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
