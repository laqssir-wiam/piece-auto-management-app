package com.pieceauto.category;

import com.pieceauto.common.PageResponse;
import com.pieceauto.product.Product;
import com.pieceauto.product.ProductRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WIAM
 **/
@RestController
@RequestMapping("category")
@RequiredArgsConstructor
@Tag(name="category")
public class CategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<ProductCategory> saveProductCat(
            @Valid @RequestBody String request,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(productCategoryService.addProductCat(request));
    }
    @GetMapping("/{product-cat-id}")
    public ResponseEntity<ProductCategory> findProductCatById(
            @PathVariable("product-cat-id") Integer productCatId
    ) {
        return ResponseEntity.ok(productCategoryService.findProductCategoryById(productCatId));
    }
    @GetMapping
    public ResponseEntity<PageResponse<ProductCategory>> findAllProductCats(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(productCategoryService.allProductCategory(page, size, connectedUser));
    }
    @PatchMapping("/update/{prod-cat-id}")
    public ResponseEntity<ProductCategory> updateProductCat(
            @PathVariable("prod-cat-id") Integer prodCatID,
            @Valid @RequestBody String   request,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(productCategoryService.updateProductCategory(request,prodCatID));
    }
    @DeleteMapping("/{prod-cat-id}")
    public ResponseEntity<Integer> deleteProductCat(
            @PathVariable("prod-cat-id") Integer prodCatID,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(productCategoryService.deleteProductCategory(prodCatID));
    }
    @GetMapping("/{product-cat-id}")
    public ResponseEntity<PageResponse<List<Product>>> findProductCatById(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            Authentication connectedUser,
            @PathVariable("product-cat-id") Integer productCatId
    ) {
        return ResponseEntity.ok(productCategoryService.allProductOfCategory(productCatId,page,size,connectedUser));
    }
}
