package com.example.admin.signup;

/**
 * Created by Admin on 21-09-2019.
 */

public class ParkingData extends UserProfile{

    public String vehicleType;
    public String Zone;
    public String slot;

    /*public ParkingData(String userMN,String userName,String userEmail,String userPassword,
                       String vehicleType,String Zone,String slot){
        super(userMN,userName,userEmail,userPassword);
        this.vehicleType=vehicleType;
        this.Zone=Zone;
        this.slot=slot;

    }*/

    public ParkingData(String userMN,String userName,String userEmail,String userPassword,
                       String vehicleType){
        super(userMN,userName,userEmail,userPassword);
        this.vehicleType=vehicleType;


    }
}
