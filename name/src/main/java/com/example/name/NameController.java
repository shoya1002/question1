package com.example.name;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NameController {
    @GetMapping(value = "/names")
    public List<String> getNames(){

        return List.of("sasaki","satou","yamashita");
    }
    @PostMapping("/names")
    public ResponseEntity<String> createName(@RequestBody NameCreateForm nameCreateForm){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id")
                .build()
                .toUri();
                return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{1234}")
    public ResponseEntity<Map<String,String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message","names successhully updated"));
    }

}
