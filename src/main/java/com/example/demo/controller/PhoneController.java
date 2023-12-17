package com.example.demo.controller;

import com.example.demo.dto.PhoneDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhoneController {

    private ArrayList<PhoneDTO> phones = new ArrayList<>() {
        {
            add(new PhoneDTO("7 999 999 99 99"));
        }
    };

    @GetMapping("/phone")
    public List<PhoneDTO> getPhones(@RequestParam(required = false) String startWithParam) {
        if (startWithParam != null && !startWithParam.isEmpty()) {
            ArrayList<PhoneDTO> result = new ArrayList<>();
            for (PhoneDTO p : phones) {
                if (p.getPhone().startsWith(startWithParam)) {
                    result.add(p);
                }
            }
            return result;
        }
        return phones;
    }

    @GetMapping("/helloPage")
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/phone")
    public PhoneDTO createPhone(@RequestBody PhoneDTO phone) {
        phones.add(phone);
        return phone;
    }

@DeleteMapping("/phone/{id}")
@ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id){
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getId() == id){
                phones.remove(phones.get(i));
                break;
            }
        }
    }
}
