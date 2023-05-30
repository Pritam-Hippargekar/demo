package com.elastic.data.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {

    private static final Integer MB=1024*1024;

    private long maxSizeInMB;

    @Override
    public void initialize(FileSize fileSize) {
        this.maxSizeInMB=fileSize.maxSizeInMB();
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext  constraintValidatorContext) {

        if(multipartFile==null)
            return true;

        return multipartFile.getSize()<maxSizeInMB*MB;
    }

}





//    String strFilePath = "C:/data.sql.gz";
//    //File object denoting the file
//    File file = new File(strFilePath);
//        if(file.exists()){
//                long lSizeInBytes = file.length();
//                System.out.println("File size in bytes: " + lSizeInBytes);
//
//                //divide bytes by 1024 to get size in kilobytes
//                double dSizeInKB = lSizeInBytes/1024;
//                System.out.println("File size in kilobytes (KB): " + dSizeInKB);
//
//                //divide kilobytes by 1024 to get size in megabytes
//                double dSizeInMB = dSizeInKB/1024;
//                System.out.println("File size in megabytes (MB): " + dSizeInMB);
//
//                //divide megabytes by 1024 to get size in gigabytes
//                double dSizeInGB = dSizeInMB/1024;
//                System.out.println("File size in gigabytes (GB): " + dSizeInGB);
//
//                //divide gigabytes by 1024 to get size in terabytes
//                double dSizeInTB = dSizeInGB/1024;
//                System.out.println("File size in terabytes (TB): " + dSizeInTB);
//
//          }else{
//
//                System.out.println("File does not exists");
//         }




//    How to get a file extension in Java?
//    int intLastDotPosition = strFileName.lastIndexOf(".");
//    int intSlashPosition = strFileName.lastIndexOf( System.getProperty("file.separator") );
//
//    if( intLastDotPosition > intLastSlashPosition ){
//            strFileExtension = strFileName.substring(intLastDotPosition + 1);
//    }