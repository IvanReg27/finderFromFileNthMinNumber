package ru.makhorin.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.makhorin.controller.XlsxController;
import ru.makhorin.service.XlsxService;

@RestController
@RequiredArgsConstructor
public class XlsxControllerImpl implements XlsxController {

    private final XlsxService xlsxService;

    @Override
    public ResponseEntity<Integer> getNthMinNumber(String path, int n) {
        int result = xlsxService.findNthMinNumber(path, n);
        return ResponseEntity.ok(result);
    }
}
