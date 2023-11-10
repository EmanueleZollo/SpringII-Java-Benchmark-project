package emanuelespringadvanced.project.services;

import emanuelespringadvanced.project.entities.Device;
import emanuelespringadvanced.project.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class DeviceService {
    List<Device> deviceList = new ArrayList<>();

    public Device save(Device body){
        this.deviceList.add(body);
        return body;
    };

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public Device findById (int id) {
        Device d = null;
        for (Device device: this.deviceList) {
            if (device.getId() == id) {
                d = device;
            }
        }
        if(d == null ){
            throw new NotFoundException(id);
        } else {
            return d;
        }
    }

    public void findByIdAndDelete(int id) {
        ListIterator<Device> iterator = this.deviceList.listIterator();
        while (iterator.hasNext()) {
            Device selectedDevice = iterator.next();
            if (selectedDevice.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Device findByIdAndUpdate(int id, Device body){
        Device selectedDevice = null;

        for (Device device: this.deviceList) {
            if (device.getId() == id) {
                selectedDevice = device;
                selectedDevice.setId(id);
                selectedDevice.setDeviceStatus(body.getDeviceStatus());
                selectedDevice.setDeviceType(body.getDeviceType());
                selectedDevice.setUser(body.getUser());
            }
        }
        if(selectedDevice == null ){
            throw new NotFoundException(id);
        } else {
            return selectedDevice;
        }
    }

    
}
