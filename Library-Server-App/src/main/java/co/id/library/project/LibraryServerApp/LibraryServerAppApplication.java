package co.id.library.project.LibraryServerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages={
//"com.example.something", "com.example.application"})
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableSwagger2
public class LibraryServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServerAppApplication.class, args);
                System.out.println("=======PROJECT LIBRARY======");
	}

}
