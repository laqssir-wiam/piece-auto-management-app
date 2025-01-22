package com.pieceauto.product;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WIAM
 **/
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@Tag(name="product")
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer> saveBook(
            @Valid @RequestBody ProductRequest   request,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.saveProduct(request).getId());
    }
}
