import java.io.Serializable;

public class Student implements Serializable {

 

    //default serialVersion id

    private static final long serialVersionUID = 1L;
    private String first_name;
    private String last_name;
    private int id;
    private Transcript transcript;

    public Student(String fname, String lname, int idNumber){

        this.first_name = fname;
        this.last_name  = lname;
        this.id = idNumber;

    }

 

    public void setFirstName(String fname) {
    	
        this.first_name = fname;

   }

 

    public String getFirstName() {

        return this.first_name;

    }

 

    public void setLastName(String lname) {

        this.first_name = lname;

    }

 
    public String getLastName() {
    	
        return this.last_name;

    }

 

    public void setId(int idNumber) {

        this.id = idNumber;

    }

 

   public int getId() {

        return this.id;

    }

   
 
    @Override

    public String toString() {

        return new StringBuffer(" First Name: ").append(this.first_name)

                .append(" Last Name : ").append(this.last_name).append(" Age : ").append(this.id).toString();

    }

 

}
