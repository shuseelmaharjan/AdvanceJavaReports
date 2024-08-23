
public class Test{

    public static void main(String args[]){
        Employee e=new Employee();
        e.setId(1);
        e.setName("Shuseel");
        e.setActive(true);
        System.out.println("ID:"+e.getId()+", Name:" + e.getName() + ", Is Active:"+e.isActive());
    }
}