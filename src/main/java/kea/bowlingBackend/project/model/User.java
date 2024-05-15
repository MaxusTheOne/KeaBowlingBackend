

@Entity
public class User {

    private int id;
    private string name;
    private string password;
    private string email;

    private string dateCreated;

    private string dateLastLogin;
    private string dateEdited;
    private <string> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public string getPassword() {
        return password;
    }

    public void setPassword(string password) {
        this.password = password;
    }

    public string getEmail() {
        return email;
    }

    public void setEmail(string email) {
        this.email = email;
    }

    public string getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(string dateCreated) {
        this.dateCreated = dateCreated;
    }

    public string getDateLastLogin() {
        return dateLastLogin;
    }

    public void setDateLastLogin(string dateLastLogin) {
        this.dateLastLogin = dateLastLogin;
    }

    public string getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(string dateEdited) {
        this.dateEdited = dateEdited;
    }
}