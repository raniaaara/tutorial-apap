package apap.tutorial.haidokter.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import apap.tutorial.haidokter.rest.Setting;

@Service
@Transactional
public class HospitalRestServiceImpl implements HospitalRestService {
    private final WebClient webClient;

    public HospitalRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.hospitalUrl).build();
    }

    @Override
    public String getHospitalByState(String singkatanNegaraBagian) {
        return this.webClient.get()
                .uri("?state="+singkatanNegaraBagian)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}