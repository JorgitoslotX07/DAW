package daw.m3.uf6.controllers;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import daw.m3.uf6.objects.Actor;
import daw.m3.uf6.objects.http.AppErrorResponse;
import daw.m3.uf6.objects.http.ErrorMessage;
import daw.m3.uf6.objects.http.RequestActor;
import daw.m3.uf6.objects.http.RequestCategory;
import daw.m3.uf6.objects.http.ResponseActor;
import daw.m3.uf6.objects.http.ResponseCategory;
import daw.m3.uf6.services.ActorService;
import daw.m3.uf6.services.CategoryService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//import daw.m3.uf6.repositories.impl.RepositoriJDBCImpl;;

/**
 * Controller principal de l'aplicació, aquí es defineixen els endpoints (punts d'accés de l'app) les anotacions GetMapping, 
 * defineixen el mètode que s'ha d'utilitzar, i es poden rebre paràmetres per path, per pathVariable, requestParam i pel Body 
 * @author Marti
 *
 */
//@Controller
@RestController
public class AppController {
	
	private static final Logger logger = LogManager.getLogger(AppController.class);
	
	@Autowired
	private ActorService actorService;

	@Autowired
	private CategoryService categoryService;
	

	//@Autowired
	//private RepositoriJDBCImpl repositoriJDBCImpl;
	
	/**
	 * getAllActors recupera tots els actors de la BD i els retorna amb un array d'actors en JSON.
	 * @return
	 */
	@GetMapping("/getAllActors")
	public ResponseEntity<List<Actor>> getAllActors() {
        logger.debug("Inici mètode getAllActors");
        //Cridar al service respectiu que processi la informació
		
		//List<Actor> listUser = repositoriJDBCImpl.getAllActors();

        List<Actor> listUser = actorService.getAllActors();
        logger.info("{} usuaris recuperats correctament",listUser.size());
		
        if(listUser==null || listUser.isEmpty()) {
        	AppErrorResponse errorResponse = new AppErrorResponse(ErrorMessage.E404.name());
        	return new ResponseEntity(errorResponse, errorResponse.getHttpCode());
        }else {       	
        	return ResponseEntity.ok(listUser);
        }
	}

	
	@PutMapping("/updateActor/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable Long id, @RequestBody RequestActor actorUpdateRequest) {
		try {
			// Verificar si el actor a actualizar existe
			Actor existingActor = actorService.getActorById(id);
			if (existingActor == null) {
				logger.error("Error interno en el servidor al actualizar el actor");
				AppErrorResponse errorResponse = new AppErrorResponse(ErrorMessage.E404.name());
			    return new ResponseEntity(errorResponse, errorResponse.getHttpCode());
			}
	
			// Validar los campos del actor actualizado
			HashMap<String, String> validations = new HashMap<>();
			if (actorUpdateRequest == null ) {
				validations.put("actor", "Objecto actor inválido.");
				logger.error("Error interno en el servidor al actualizar el actor");
				AppErrorResponse errorResponse = new AppErrorResponse(ErrorMessage.E001.name());
			    return new ResponseEntity(errorResponse, errorResponse.getHttpCode());
			}
	
			existingActor.setFirstName(actorUpdateRequest.getFirstName());
			existingActor.setSecondName(actorUpdateRequest.getSecondName());
	
			Actor updatedActor = actorService.updateActorById(id, existingActor);
	
			// Retornar un 200 con el actor actualizado
			return ResponseEntity.ok(updatedActor);
		} catch (Exception e) {
			// En caso de cualquier otro error, retornar un 500 con un mensaje de error genérico
			logger.error("Error interno en el servidor al actualizar el actor", e);
			AppErrorResponse errorResponse = new AppErrorResponse(ErrorMessage.E500.name());
			    return new ResponseEntity(errorResponse, errorResponse.getHttpCode());
		}
	}
	

	@PostMapping("/{tipusBD}/createActor")
	public ResponseEntity<ResponseActor> createActor(@PathVariable String tipusBD, @RequestBody RequestActor requestActor){
		logger.debug("Inici mètode createUser, user rebut[{}]",requestActor);
		
		HashMap<String,String> validacions = new HashMap<>();
		if (!tipusBD.equals("jdbc") && !tipusBD.equals("jpa") && !tipusBD.equals("mongo")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

		if (requestActor == null || requestActor.getFirstName() == null || requestActor.getFirstName().isBlank() ||
				requestActor.getSecondName() == null || requestActor.getSecondName().isBlank()) {
			return ResponseEntity.badRequest().build();
		}

		Actor actor = new Actor();
		actor.setFirstName(requestActor.getFirstName());
		actor.setSecondName(requestActor.getSecondName());

		ResponseActor createdActor = actorService.insertActorVariableBD(tipusBD, requestActor);;
		
		if (createdActor != null) {
			logger.info("Actor creado correctamente en la base de datos");
			return new ResponseEntity<>(createdActor, HttpStatus.CREATED);
		} else {
			logger.error("Error al crear el actor en la base de datos");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/deleteActor")
	public ResponseEntity<Boolean> deleteActor(@RequestParam("id") Long id) {
		try {
			// Verificar si el actor a actualizar exist

			Actor existingActor = actorService.getActorById(id);
			if (existingActor == null) {
				logger.error("Error interno en el servidor al actualizar el actor");
				AppErrorResponse errorResponse = new AppErrorResponse(ErrorMessage.E404.name());
			    return new ResponseEntity(errorResponse, errorResponse.getHttpCode());
			}
	
			// Validar los campos del actor actualizado
			HashMap<String, String> validations = new HashMap<>();
			if (id == null ) {
				validations.put("actor", "Objecto actor inválido.");
				logger.error("Error interno en el servidor al actualizar el actor");
				AppErrorResponse errorResponse = new AppErrorResponse(ErrorMessage.E001.name());
			    return new ResponseEntity(errorResponse, errorResponse.getHttpCode());
			}
	
			boolean updatedActor = actorService.deleteActorById(id);
	
			// Retornar un 200 con el actor actualizado
			return ResponseEntity.ok(updatedActor);
			//return ResponseEntity.ok().build();
		} catch (Exception e) {
			// En caso de cualquier otro error, retornar un 500 con un mensaje de error genérico
			logger.error("Error interno en el servidor al actualizar el actor", e);
			AppErrorResponse errorResponse = new AppErrorResponse(ErrorMessage.E500.name());
			    return new ResponseEntity(errorResponse, errorResponse.getHttpCode());
		}
	}

	@PostMapping("/insertMongo")
    public ResponseEntity<ResponseActor> insertMongo(@RequestBody RequestActor requestActor) {

        ResponseActor responseActor = actorService.insertMongoDB(requestActor);
        if (responseActor != null) {
            return new ResponseEntity<>(responseActor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@PostMapping("/{tipusBD}/newCategory")
    public ResponseEntity<ResponseCategory> newCategory(@PathVariable String tipusBD, @RequestBody RequestCategory requestCategory) {

		if (!tipusBD.equals("jdbc") && !tipusBD.equals("jpa") && !tipusBD.equals("mongo")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

		if (requestCategory != null && requestCategory.getName() != "") {		
			ResponseCategory responseCategory = categoryService.newCategory(tipusBD, requestCategory);

			if (responseCategory != null) {
				
				return new ResponseEntity<>(responseCategory, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

    }
}
