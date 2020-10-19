package com.dull.piqued.controllers;

import com.dull.piqued.common.ResponseTemplate;
import com.dull.piqued.dto.MisconductRequestDTO;
import com.dull.piqued.dto.MisconductResponseDTO;
import com.dull.piqued.services.MisconductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/misconduct")
public class MisconductController {

    @Autowired
    private MisconductService misconductService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseTemplate addEmployeeMisconduct(@RequestBody MisconductRequestDTO misconductRequest) {
        ResponseTemplate response =  new ResponseTemplate();
        MisconductResponseDTO misconductResponse = misconductService.createEmployeeMisconduct(misconductRequest);
        response.setData(misconductResponse);
        response.setMessage("Successfully saved the misconduct");
        return response;
    }
}
