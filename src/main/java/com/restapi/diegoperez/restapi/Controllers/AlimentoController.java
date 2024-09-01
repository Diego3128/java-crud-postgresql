package com.restapi.diegoperez.restapi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.diegoperez.restapi.Entities.Alimento;
import com.restapi.diegoperez.restapi.Respositories.AlimentoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

// decorador para la creacion de la APIREST
@RestController
// configurar endpoint
@RequestMapping("/alimentos")

public class AlimentoController {
    // Decorador Spring para inyectar instancia del repositorio
    @Autowired
    // instanciar repositorio
    private AlimentoRepository alimentoRepository;

    // direcciones que el cliente puede consumir
    // GET
    @GetMapping
    public List<Alimento> obtenerAlimentos() {
        // utilizar la instancia del repositorio para traer todos los alimentos
        return alimentoRepository.findAll();
    }

    // GET/ID
    @GetMapping("/{id}")
    public Alimento obtenerAlimentoId(@PathVariable Long id) {
        // utilizar la instancia del repositorio para buscar el alimento por su id
        return alimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El alimento con id: " + id + " no fue encontrado"));
        // devolver error si el producto no es encontrado
    }

    // POST
    // Se debe recibir en el body un objeto tipo alimento (definido en Alimento.java)
    @PostMapping
    public Alimento crearAlimento(@RequestBody Alimento alimento) {
        // utilizar la instancia del repositorio para guardar el nuevo alimento
        return alimentoRepository.save(alimento);
    }
    // PUT
    // se recibe el id a modificar mediante un parametro en la url
    // Se debe recibir en el body un objeto tipo alimento (definido enAlimento.java)
    @PutMapping("/{id}")
    public Alimento actualizarAlimento(@PathVariable Long id, @RequestBody Alimento informacionAlimento) {
        // utilizar la instancia del repositorio para buscar el alimento por su id
        Alimento alimento = alimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El alimento con id: " + id + " no fue encontrado"));
        // devolver error si el producto no es encontrado

        // actualizar alimento mediante el objeto recibido mediante el body
        alimento.setNombre(informacionAlimento.getNombre());
        alimento.setCalorias(informacionAlimento.getCalorias());
        alimento.setCarbohidratos(informacionAlimento.getCarbohidratos());
        alimento.setGrasa(informacionAlimento.getGrasa());
        alimento.setProteina(informacionAlimento.getProteina());

        // utilizar la instancia del repositorio para guardar los cambios
        return alimentoRepository.save(alimento);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminarAlimento(@PathVariable Long id) {
        // utilizar la instancia del repositorio para buscar el alimento por su id
        Alimento alimento = alimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El alimento con id: " + id + " no fue encontrado"));
        // devolver error si el producto no es encontrado

        // utilizar la instancia del repositorio para guardar los cambios
        alimentoRepository.delete(alimento);

        return "El producto con id: " + id + " fue eliminado";
    }

}
