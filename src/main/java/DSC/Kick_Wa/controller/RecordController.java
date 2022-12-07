package DSC.Kick_Wa.controller;

import DSC.Kick_Wa.dto.RentalDto;
import DSC.Kick_Wa.dto.ReturnVehicleDto;
import DSC.Kick_Wa.dto.response.PaymentDto;
import DSC.Kick_Wa.dto.response.RentVehicleInfoDto;
import DSC.Kick_Wa.dto.response.UsageRecordDto;
import DSC.Kick_Wa.response.DefaultRes;
import DSC.Kick_Wa.response.StatusCode;
import DSC.Kick_Wa.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;

    //킥보드 빌린다
    @PostMapping("/rental")
    public ResponseEntity rental(@RequestBody RentalDto rentalDto) {

        Long record = recordService.rental(rentalDto);

        return record != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "킥보드 대여 완료", record), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //킥보드 반납
    @PostMapping("/return-vehicle")
    public ResponseEntity returnVehicle(@RequestBody ReturnVehicleDto returnVehicleDto) {

        Long record = recordService.returnVehicle(returnVehicleDto);

        return record != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "킥보드 반납 완료", record), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //유저 이용 내역
    @GetMapping("/show/usage-info")
    public ResponseEntity showUsageInfo(@RequestParam(name = "userId") Long userId) {

        List<UsageRecordDto> collect = recordService.showUsageRecord(userId);

        return collect != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "유저 이용 내역 조회 완료", collect), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //사용중인 킥보드 정보
    @GetMapping("/show/rental-vehicle")
    public ResponseEntity rentalVehicleInfo(@RequestParam(name = "userId") Long userId) {

        RentVehicleInfoDto record = recordService.showRentVehicleInfo(userId);

        return record != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "이용중인 킥보드 내역 조회 완료", record), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //반납 결제
    @GetMapping("/show/payment-info")
    public ResponseEntity showPaymentInfo(@RequestParam(name = "userId") Long userId){

        PaymentDto result = recordService.showPayment(userId);

        return result != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "결제 정보 조회 완료", result), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }
}
