package com.coutodev.qrcode.generate.Controller;

import com.coutodev.qrcode.generate.dto.QrCodeGenerateRequest;
import com.coutodev.qrcode.generate.dto.QrCodeGenerateResponse;
import com.coutodev.qrcode.generate.service.QrCodeGeneraterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneraterService qrCodeGeneraterService;

    public QrCodeController(QrCodeGeneraterService qrCodeService) {
        this.qrCodeGeneraterService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generate(@RequestBody QrCodeGenerateRequest request) {
        try {
            QrCodeGenerateResponse response = this.qrCodeGeneraterService.generaterAndUploadQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }

    }
}
