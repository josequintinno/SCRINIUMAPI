package br.com.quintinno.SCRINIUMAPI.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import br.com.quintinno.SCRINIUMAPI.utility.ConstantesUtility;

@RestController
@RequestMapping("/api/arquivo")
public class ArquivoController {

    @Value("${file.upload-dir}")
    private String UPLOAD_DIR;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("arquivo") List<MultipartFile> multipartFileList) {
        for (MultipartFile multipartFile : multipartFileList) {
            byte[] bytes;
            try {
                bytes = multipartFile.getBytes();
                Path path = Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ConstantesUtility.MENSAGEM_FALHA_UPLOAD);
            }
            return ResponseEntity.status(HttpStatus.OK).body(ConstantesUtility.MENSAGEM_SUCESSO_UPLOAD.concat(" (" + multipartFile.getOriginalFilename().concat(")")));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ConstantesUtility.MENSAGEM_FALHA_UPLOAD);
    }

}
