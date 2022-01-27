package com.sifan.mp_api.service;

import com.sifan.mp_api.dto.ImageData;

import java.util.List;

public interface ImageService {
    ImageData saveImage(ImageData imageData);
    boolean deleteImageById(final Long imageId);
    ImageData getImageById(final Long imageId);
    List<ImageData> getAllImages();
    ImageData updateImage(Long imageId, Long itemId);
}
