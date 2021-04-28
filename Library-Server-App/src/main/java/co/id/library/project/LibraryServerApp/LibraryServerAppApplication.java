package co.id.library.project.LibraryServerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LibraryServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServerAppApplication.class, args);
                System.out.println("=======PROJECT LIBRARY======");
	}

}
