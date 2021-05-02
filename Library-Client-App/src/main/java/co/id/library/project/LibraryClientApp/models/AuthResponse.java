
package co.id.library.project.LibraryClientApp.models;

import java.util.List;
import lombok.Data;


@Data
public class AuthResponse {
    private String userName;
    private Integer userId;
    private List<String> authorities;

    public AuthResponse(String userName, Integer userId, List<String> authorities) {
        this.userName = userName;
        this.userId = userId;
        this.authorities = authorities;
    }

    public AuthResponse(String userName) {
        this.userName = userName;
    }

    public AuthResponse() {
    }

}
