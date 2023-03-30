package com.elastic.data.validation;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("manage-file")
public class FileMgtController {

    @PostMapping
    public void addFile(@Valid  @ModelAttribute FileUploadDTO fileUploadDTO){
        System.out.println("File is valid");
    }

}
