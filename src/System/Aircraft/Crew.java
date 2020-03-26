package System.Aircraft;

public class Crew implements IPerson {
    private String name;
    private boolean ginger;

    private String role;

    Crew(String name,boolean ginger,String role){
        this.name=name;
        this.ginger=ginger;
        this.role=role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isGing() {
        return ginger;
    }

    public String getRole() {
        return role;
    }
}
