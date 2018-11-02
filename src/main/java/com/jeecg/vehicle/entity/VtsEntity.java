package com.jeecg.vehicle.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "z_vts", schema = "")
public class VtsEntity implements java.io.Serializable {
    /**主键*/
    private java.lang.String id;
    /**牵引车id*/
    private java.lang.String vehId;
    /**挂车id*/
    private java.lang.String traId;
    /**司机id*/
    private java.lang.String sijiId;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

    @Column(name ="ID",nullable=false,length=36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name ="VEH_ID",nullable=true,length=32)
    public String getVehId() {
        return vehId;
    }

    public void setVehId(String vehId) {
        this.vehId = vehId;
    }

    @Column(name ="TRA_ID",nullable=true,length=32)
    public String getTraId() {
        return traId;
    }

    public void setTraId(String traId) {
        this.traId = traId;
    }

    @Column(name ="SIJI_ID",nullable=true,length=32)
    public String getSijiId() {
        return sijiId;
    }

    public void setSijiId(String sijiId) {
        this.sijiId = sijiId;
    }
}
