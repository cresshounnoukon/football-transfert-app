package tech.omeganumeric.beninsoccerapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.omeganumeric.beninsoccerapp.payloads.requests.PositionPayload;
import tech.omeganumeric.beninsoccerapp.services.PositionService;

import java.util.Arrays;

@SpringBootApplication
public class BeninSoccerApplication implements CommandLineRunner {


    final PositionService positionService;

    public BeninSoccerApplication(PositionService positionService) {
        this.positionService = positionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BeninSoccerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] positions = {
                "Left Midfielder",
                "Attacking Midfielder",
                "Center Forward",
                "Center Midfielder",
                "Right Midfielder",
                "Defensive Midfielder",
                "Sweeper",
                "Center-back",
                "Right Full-back",
                "Left Full-back",
                "Goalkeeper",
        };
        Arrays.stream(positions).forEach(s -> {
                    PositionPayload positionPayload = new PositionPayload();
                    positionPayload.setName(s);
                    positionService.save(positionPayload);
                }
        );


    }
}
