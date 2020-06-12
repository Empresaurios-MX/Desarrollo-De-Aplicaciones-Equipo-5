package org.uv.desarrollo.webservice1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Angel
 */

@RestController
public class HolaMundoController {
    
    
    @GetMapping("/holamundo")
    public String getHolaMundo(){
        return "Hola Mundo";
    }
    
    @GetMapping("/empleado")
    public Empleado getEmpleado(){
        Empleado e = new Empleado();
        e.setClave("01");
        e.setNombre("Juan");
        return e;
    }
}
