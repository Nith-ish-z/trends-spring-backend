package com.ecom.trends.controller;

import com.ecom.trends.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("{productId}")
    public ResponseEntity<?> add(@PathVariable Long productId) {
        Long userId = getCurrentUserId();
        return ResponseEntity.status(201)
                .body(cartService.addToCart(userId, productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> remove(@PathVariable Long productId) {
        Long userId = getCurrentUserId();
        int count = cartService.removeFromCart(userId, productId);

        return ResponseEntity.ok(Map.of(
                "productId", productId,
                "remainingCount", count
        ));
    }

    @DeleteMapping("/clear/{productId}")
    public  ResponseEntity<?> removeAll(@PathVariable Long productId){
        Long userId = getCurrentUserId();
        cartService.removeAllFromCart(userId, productId);

        return ResponseEntity.ok(Map.of("Response","Deleted"));
    }


    private Long getCurrentUserId() {
        return 1L; // TEMP
    }
}
