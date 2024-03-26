package com.main.demo.main.eat;


import com.main.demo.main.table.Diet;
import com.main.demo.main.table.DietDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("main/eat")
public class EatController {

    private final EatService eatService;
    @PostMapping("")
    public ResponseEntity<List<Diet>> week(@RequestBody DietDTO dietDTO) {
        List<Diet> week = eatService.Week(dietDTO.getId());
        return ResponseEntity.status(HttpStatus.OK).body(week);
    }


    @DeleteMapping("")
    public String Deleteat(@RequestBody Map<String, String> requestBody) {
        DietDTO dietDTO = new DietDTO();

        dietDTO.setId(requestBody.get("id"));
        dietDTO.setDname(requestBody.get("dname"));
        String date = requestBody.get("date");

        eatService.delete(dietDTO.getId(), dietDTO.getDname(), date);

        if (dietDTO.getDname() != null) {
            return date + " " + dietDTO.getDname() + " 의 운동정보가 삭제됬습니다.";
        } else {
            return date + " 의 모든 운동정보가 삭제됬습니다.";
        }
    }
        @PostMapping("/insert")
        public Diet inserteat(@RequestBody Diet dite){
            dite.setDdatetime(LocalDateTime.now());
            eatService.regist(dite);

            return dite;


    }

}