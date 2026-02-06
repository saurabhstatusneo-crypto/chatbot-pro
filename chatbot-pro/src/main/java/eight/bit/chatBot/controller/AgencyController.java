package eight.bit.chatBot.controller;

import eight.bit.chatBot.entity.Agency;
import eight.bit.chatBot.service.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agency")
@AllArgsConstructor
public class AgencyController {
    private final AgencyService agencyService ;

    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency agency) {
        return ResponseEntity.ok(agencyService.saveAgency(agency));
    }

    @GetMapping
    public ResponseEntity<List<Agency>> getAgencies() {
        return ResponseEntity.ok(agencyService.getAllAgencies());
    }
}
