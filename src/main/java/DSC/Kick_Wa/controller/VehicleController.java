package DSC.Kick_Wa.controller;

import DSC.Kick_Wa.dto.response.VehicleShowInfoDto;
import DSC.Kick_Wa.response.DefaultRes;
import DSC.Kick_Wa.response.StatusCode;
import DSC.Kick_Wa.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    //킥보드 정보 조회
    @GetMapping("/{vehicleId}/vehicle-info")
    public ResponseEntity getVehicleInfo(@PathVariable("vehicleId") Long vehicleId) throws IOException{
        VehicleShowInfoDto vehicle = vehicleService.vehicleShowInfo(vehicleId);

        return vehicle != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK,"킥보드 정보 조회 완료",vehicle), HttpStatus.OK):
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST,"조회된 정보 없음"),HttpStatus.OK);
    }
    //parameter: 브라우저(client)에서 만들어진 정보
    //attribute: servlet(server)에서 만들어진 정보
}
