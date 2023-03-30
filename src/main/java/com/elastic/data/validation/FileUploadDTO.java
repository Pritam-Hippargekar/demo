package com.elastic.data.validation;

import com.elastic.data.constants.FILE_TYPE;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "file")
@CompareDate(before = "arrivalDate", after = "departureDate", message = "The arrival date must be lower than the departure date")
public class FileUploadDTO {

    @NotBlank
    private String fileDescription;

    @FileType(allowedFileTypes = {FILE_TYPE.PDF},message = "Please enter valid file format")
    @FileSize(maxSizeInMB = 10)
    private MultipartFile file;

    @NotNull(message = "The departure date is required.")
    @FutureOrPresent(message = "The departure date must be today or in the future.")
    private Date departureDate;

    @NotNull(message = "The arrival date is required.")
    @FutureOrPresent(message = "The arrival date must be today or in the future.")
    private Date arrivalDate;
}
