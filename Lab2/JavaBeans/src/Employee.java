import java.io.Serializable;

public class Employee implements Serializable{
    private int id;

    private String name;

    private boolean active;

    public Employee(){

    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name=name;

    }
    public String getName(){
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}