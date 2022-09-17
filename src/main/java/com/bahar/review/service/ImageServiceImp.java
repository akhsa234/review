package com.bahar.review.service;


import com.bahar.review.convertor.image.DTOConvertToImage;
import com.bahar.review.convertor.image.ImageConvertToDTO;
import com.bahar.review.dto.ImageDTO;
import com.bahar.review.exception.NotFoundException;
import com.bahar.review.model.Image;
import com.bahar.review.repo.ImageDbRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor(onConstructor_= @Autowired)
public class ImageServiceImp {

    //    @Value("${image.path}")
    private String path="C:/Users/bah/Documents/project_product_onlineStore";
//    @Value("${image.url}")

    private String url="http://localhost:7080/image/download";

    private final ImageDbRepository imageDbRepository;
    private final ImageConvertToDTO imageConvertToDTO;
    private final DTOConvertToImage dtoConvertToImage;

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);



    public Image saveImage(MultipartFile file, String description) {
        logger.info("=========== saving a picture ==============");
        try {
            byte[] bytes= file.getBytes();
            Path pathImage= Paths.get(path+ file.getOriginalFilename());
            Files.write(pathImage,bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
        file.getOriginalFilename();
        Image image = Image.builder()
                .name(file.getOriginalFilename())
                .description(description)
                .path(path)
                .url(url+file.getOriginalFilename())
                .build();
        imageDbRepository.save(image);
        return image;
    }


    public ImageDTO findById(Long id) throws NotFoundException {
        Image image = imageDbRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No image was found with id=" + id));
        return imageConvertToDTO.convert(image);

    }

    public void delete(Long id) {
        imageDbRepository.deleteById(id);
    }
}
