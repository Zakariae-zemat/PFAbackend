package backend.backend.DTO;

public class AuthResponseDTO {

    private String accessToken;
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    private String tokenType = "Bearer ";

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
    
}
