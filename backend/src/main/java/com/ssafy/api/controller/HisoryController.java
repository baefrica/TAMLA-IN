package com.ssafy.api.controller;

import com.ssafy.api.request.ScheduleModifyReq;
import com.ssafy.api.response.ScheduleHistoryRes;
import com.ssafy.api.service.HistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "일정 내역 API", tags = {"History"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/history")
public class HisoryController {
    private final HistoryService historyService;
    @ApiOperation(value = "일정 내역 조회", notes = "마이페이지에서 나의 일정 내역 조회하기")
    @GetMapping("/{userId}")
    public ResponseEntity<?> getScheduleHistory(@PathVariable("userId") Long userId) {
        List<ScheduleHistoryRes> scheduleHistoryResList = historyService.getScheduleHistory(userId);
        return ResponseEntity.status(200).body(scheduleHistoryResList);
    }

    @ApiOperation(value = "일정 내역 삭제", notes = "마이페이지에서 나의 일정 내역 삭제하기")
    @PatchMapping("/delete/{scheduleId}")
    public ResponseEntity<?> deleteScheduleHistory(@PathVariable("scheduleId") Long scheduleId) {
        historyService.deleteScheduleHistory(scheduleId);
        return ResponseEntity.status(200).body("일정 삭제");
    }

    @ApiOperation(value = "일정명 수정", notes = "일정 내역에서 원하는 일정명 수정하기")
    @PatchMapping("/modify")
    public ResponseEntity<?> modifyScheduleName(@RequestBody ScheduleModifyReq scheduleModifyReq) {
        historyService.modifyScheduleName(scheduleModifyReq);
        return ResponseEntity.status(200).body("일정명 수정");
    }
}
