package br.com.concrete.backend.produto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api("/produtos")
@RestController("/produtos/")
public class VitrineController {
    
    @ApiOperation("Lista os produtos")
    @RequestMapping(method = GET, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get() {
        return null;
    }
}
