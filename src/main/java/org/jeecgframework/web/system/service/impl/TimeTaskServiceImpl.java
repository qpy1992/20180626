package org.jeecgframework.web.system.service.impl;

import com.jeecg.paiban.entity.PaibanEntity;
import com.jeecg.vehicle.entity.VehicleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.jeecgframework.web.system.service.TimeTaskServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("timeTaskService")
@Transactional
public class TimeTaskServiceImpl extends CommonServiceImpl implements TimeTaskServiceI {

	public void paiban(){
        List<VehicleEntity> list = this.findHql("FROM VehicleEntity");
        for(VehicleEntity vehicle:list){
            PaibanEntity paiban = new PaibanEntity();
            paiban.setFcarcode(vehicle.getFitemid());
            paiban.setFcarno(vehicle.getFcarno());
//            paiban.setFdriver(vehicle.getFdefaultName());
            paiban.setFoutercar("否");
            paiban.setFdate(getFetureDate(7));
            this.save(paiban);
        }
    }

    public String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }
}