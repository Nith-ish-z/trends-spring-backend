package com.ecom.trends.dto.user;

import java.util.List;

public class UserResponseDTO {
    public Long userId;
    public NameDTO name;
    public String email;
    public String username;
    public String role;
    public String dob;
    public String mob;
    public List<CartItemDTO> cartItem;
    public List<WishItemDTO> wishItem;
    public String profileImg;
}
