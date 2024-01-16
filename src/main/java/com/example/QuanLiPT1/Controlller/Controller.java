package com.example.QuanLiPT1.Controlller;

import com.example.QuanLiPT1.DTO.Request.LoginRequest;
import com.example.QuanLiPT1.DTO.Request.RegisterRequest;
import com.example.QuanLiPT1.DTO.Request.UserDTO;
import com.example.QuanLiPT1.DTO.Response.MessageResponse;
import com.example.QuanLiPT1.Entity.Products;
import com.example.QuanLiPT1.Service.ProductService;
import com.example.QuanLiPT1.Service.emailService;
import com.example.QuanLiPT1.Service.jwtService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/v1/account/")
@RestController
public class Controller {
    @Autowired
    public emailService emailService;
    @Autowired
    public jwtService userService;
    @Autowired
    public ProductService productService;
    @PostMapping(path = "TaoTK",produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageResponse TaoTaiKhoan(@RequestBody RegisterRequest registerRequest){
        return emailService.Register(registerRequest);
    }
    @PostMapping(path = "XacNhanTK",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> XacNhanTK(@RequestParam String code){
        return emailService.XacNhanUser(code);
    }
    @CrossOrigin
    @PostMapping(path = "Login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> Login(@RequestBody LoginRequest loginRequest ){
        return ResponseEntity.ok(userService.Login(loginRequest));
    }
    @CrossOrigin
    @PostMapping(path = "ThemSanPham",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ThemSanPham(@RequestBody String products){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Products product = gson.fromJson(products,Products.class);
        return productService.ThemSanPham(product);
    }
    @CrossOrigin
    @GetMapping(path = "WomensFeature",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> GetWomensFeature(){
        return productService.GetWomensFeature();
    }
    @CrossOrigin
    @GetMapping(path = "WomensCollection",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> GetWomensCollection(){
        return productService.GetWomensCollection();
    }
    @CrossOrigin
    @GetMapping(path = "MensCollection",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> GetMensCollection(){
        return productService.GetMensCollection();
    }
    @CrossOrigin
    @GetMapping(path = "KidsCollection",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> GetKidsCollection(){
        return productService.GetKidsCollection();
    }
    @CrossOrigin
    @GetMapping(path = "AllCollection",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> GetAllCollection(){
        return productService.GetAllCollection();
    }


}
