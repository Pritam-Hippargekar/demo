package com.elastic.data.validation;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTypeValidator implements ConstraintValidator<FileType, MultipartFile>{
    private List<String> validFileTypes;

    @Override
    public void initialize(FileType fileType) {
        validFileTypes=new ArrayList<>();
        Arrays.stream(fileType.allowedFileTypes())
                .forEach(file_type -> validFileTypes.add(file_type.name()));
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext){
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename()).toUpperCase();
        return validFileTypes.contains(extension);
    }
}
