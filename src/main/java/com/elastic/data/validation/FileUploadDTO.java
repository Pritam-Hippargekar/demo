package com.elastic.data.validation;

import com.elastic.data.constants.FILE_TYPE;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "file")
public class FileUploadDTO {

    @NotBlank
    private String fileDescription;

    @FileType(allowedFileTypes = {FILE_TYPE.PDF},message = "Please enter valid file format")
    @FileSize(maxSizeInMB = 10)
    private MultipartFile file;
}
