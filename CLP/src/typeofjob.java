/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rovit
 */
public class typeofjob {
    private int id,id1;
    private String name;
    private String typeofjob;
    private String place;
    
    public typeofjob(int id, String name, String typeofjob, String place)
    {
        this.id = id;
        this.name = name;
        this.place = place;
        this.typeofjob = typeofjob;
    }
    public typeofjob(int id, String typeofjob, String place)
    {
  
        this.id = id;
        this.place = place;
        this.typeofjob = typeofjob;
    }
    public typeofjob(String name,int id, String typeofjob)
    {
  
        this.id = id;
        this.name = name;
        this.typeofjob = typeofjob;
    }

    typeofjob(int id, String typeofjob) {
          this.id1 = id;
          this.typeofjob = typeofjob;
    }
  
    
    public int getid()
    {
        return id;
    }
     public int getid1()
    {
        return id1;
    }
    public String name()
    {
        return name;
    }
    
    public String getjob()
    {
        return typeofjob;
    }
    
    public String getplace()
    {
        return place;
    }
    
}
