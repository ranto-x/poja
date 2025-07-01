package ranto.co.io.endpoint.rest.controller.health;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ranto.co.io.PojaGenerated;

@PojaGenerated
@RestController
@AllArgsConstructor
public class PingController {

  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/pong")
  public String pong() {
    return "ping";
  }

  @GetMapping("/pang")
  public String pang() {
    return "ping";
  }
}
