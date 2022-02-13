package com.api.ParkingControll.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,unique = true,length = 10)
    private String parkingSpotnumber;

    @Column(nullable = false,unique = true,length = 7)
    private String licenseplatecar;

    @Column(nullable = false,length = 70)
    private String brandCar;

    @Column(nullable = false,length = 70)
    private String modelCar;

    @Column(nullable = false,length = 70)
    private String colorCar;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false,length = 130)
    private String responsibleName;

    @Column(nullable = false,length = 30)
    private String apartment;

    @Column(nullable = false,length = 30)
    private String block;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotnumber() {
        return parkingSpotnumber;
    }

    public void setParkingSpotnumber(String parkingSpotnumber) {
        this.parkingSpotnumber = parkingSpotnumber;
    }

    public String getLicenseplatecar() {
        return licenseplatecar;
    }

    public void setLicenseplatecar(String licenseplatecar) {
        this.licenseplatecar = licenseplatecar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
