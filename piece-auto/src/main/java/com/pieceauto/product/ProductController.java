package com.pieceauto.product;

import com.pieceauto.common.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Integer> saveProduct(
            @Valid @RequestBody ProductRequest   request,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.saveProduct(request).getId());
    }
    @GetMapping("/{product-id}")
    public ResponseEntity<Product> findProductById(
            @PathVariable("product-id") Integer productId
    ) {
        return ResponseEntity.ok(service.findById(productId));
    }
    @GetMapping
    public ResponseEntity<PageResponse<Product>> findAllProducts(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.findAll(page, size, connectedUser));
    }
    @PatchMapping("/shareable/{book-id}")
    public ResponseEntity<Product> updatePeoduct(
            @PathVariable("product-id") Integer prodID,
            @Valid @RequestBody ProductRequest   request,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.updateProduct(request,prodID));
    }
}
