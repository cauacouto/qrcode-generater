package com.coutodev.qrcode.generate.ports;

public interface StoragePort {
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
