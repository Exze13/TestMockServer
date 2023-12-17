package com.example.demo.controller;

import com.example.demo.dto.PhoneDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhoneController {

    ArrayList<PhoneDTO> phones = new ArrayList<>() {
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
}
