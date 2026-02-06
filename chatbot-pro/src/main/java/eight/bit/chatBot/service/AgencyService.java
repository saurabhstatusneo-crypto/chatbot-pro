package eight.bit.chatBot.service;

import eight.bit.chatBot.entity.Agency;
import eight.bit.chatBot.repository.AgencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgencyService {

    private final AgencyRepository agencyRepository ;

    public Agency saveAgency(Agency agency) {
        return agencyRepository.save(agency);
    }
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }
}
