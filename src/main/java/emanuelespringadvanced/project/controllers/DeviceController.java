package emanuelespringadvanced.project.controllers;

import emanuelespringadvanced.project.entities.Device;
import emanuelespringadvanced.project.entities.User;
import emanuelespringadvanced.project.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("")
    public List<Device> deviceList(){
        return deviceService.getDeviceList();
    }
    
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Device saveDevice(@RequestBody Device body) {
        return deviceService.save(body);
    }

    @GetMapping("/{id}")
    public Device findById(@PathVariable int id){
        return deviceService.findById(id);
    }

    @PutMapping("/{id}")
    public Device findByIdAndUpdate(@PathVariable int id, @RequestBody Device body){
    return deviceService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int id){
        deviceService.findByIdAndDelete(id);
    }

}
