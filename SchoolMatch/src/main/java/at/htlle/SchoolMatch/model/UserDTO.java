package at.htlle.SchoolMatch.model;

public class UserDTO {
    private String id;
    private String email;
    private String name;
    private String klasse;
    private String interessen;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getKlasse() { return klasse; }
    public void setKlasse(String klasse) { this.klasse = klasse; }
    public String getInteressen() { return interessen; }
    public void setInteressen(String interessen) { this.interessen = interessen; }
}
