package emanuelespringadvanced.project.services;

import emanuelespringadvanced.project.entities.Device;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    List<Device> deviceList = new ArrayList<>();

    public Device save(Device body){
        this.deviceList.add(body);
        return body;
    };


}
