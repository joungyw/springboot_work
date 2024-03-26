package com.main.demo.main.work;


import com.main.demo.main.table.Record;
import com.main.demo.main.table.RecordDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("main/work")
public class WorkController {

    private final WorkService workService;

    @PostMapping("")
    public ResponseEntity<List<Record>> week(@RequestBody RecordDTO recordDTO) {
        List<Record> list = workService.Week(recordDTO.getId());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("")
    public String Deletework(@RequestBody Map<String, String> requestBody) {
        RecordDTO recordDTo = new RecordDTO();
        Record record = new Record();
        recordDTo.setId(requestBody.get("id"));
        recordDTo.setEname(requestBody.get("ename"));
        String date = requestBody.get("date");

        workService.delete(recordDTo.getId(), recordDTo.getEname(), date);
        if (recordDTo.getEname() != null) {
            return date + " " + recordDTo.getEname() + " 의 운동정보가 삭제됬습니다.";
        } else {
            return date + " 의 모든 운동정보가 삭제됬습니다.";
        }
    }
    @PostMapping("/insert")
    public Record insertwork(@RequestBody Record record){
        record.setRdatetime(LocalDateTime.now());
          workService.regist(record);
        System.out.println(record.getRdatetime());


        return record;
    }

}
