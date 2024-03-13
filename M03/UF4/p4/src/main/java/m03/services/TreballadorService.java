package m03.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import m03.objects.Treballador;
import m03.objects.Encarregat;
import m03.repositories.TreballadorRepository;
import m03.repositories.repositoriesImpl.XMLFileTreballadorRepository;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
public class TreballadorService {
    private static final Logger logger = LogManager.getLogger(TreballadorService.class);
    private TreballadorRepository TreballadorRepository;

    public TreballadorService(TreballadorRepository treballadorRepository) {
        this.TreballadorRepository = treballadorRepository;
    }

    public void addTreballador(Treballador t) {
        Treballador existingTreballador = getAllTrebaladorsByDNI(t.getDni());
        if (existingTreballador == null) {
            TreballadorRepository.createTreballador(t);
            logger.info("Nuevo trabajador agregado con éxito: " + t);
        } else {
            logger.warn("Ya existe un trabajador con el mismo DNI: " + t.getDni());
        }
    }

    public List<Treballador> getLlistaTreballadors() {
        List<Treballador> treballadors = TreballadorRepository.getLlistaTreballadors();

        Collections.sort(treballadors, new Comparator<Treballador>() {
            @Override
            public int compare(Treballador t1, Treballador t2) {
                int result = t1.getCognoms().compareTo(t2.getCognoms());
                if (result == 0) {
                    result = t1.getNom().compareTo(t2.getNom());
                }
                return result;
            }
        });

        return treballadors;
    }

    public Treballador getAllTrebaladorsByDNI(String dni) {
        return TreballadorRepository.getAllTrebaladorsByDNI(dni);
    }

    public Treballador getAllTrebaladorsById(String id) {
        return TreballadorRepository.getAllTrebaladorsById(id);
    }

    public void guardarFitxer() {
        TreballadorRepository.guardarFitxer();
    }

    public static void main(String[] args) {
        TreballadorRepository repository = new XMLFileTreballadorRepository();
        TreballadorService service = new TreballadorService(repository);

        List<Treballador> treballadors = service.getLlistaTreballadors();
        logger.info("Lista de trabajadores:");
        for (Treballador treballador : treballadors) {
            logger.info(treballador);
        }

        String dni = "12345578A";
        Treballador treballadorByDNI = service.getAllTrebaladorsByDNI(dni);
        if (treballadorByDNI != null) {
            logger.info("Trabajador encontrado por DNI:");
            logger.info(treballadorByDNI);
        } else {
            logger.info("No se encontró ningún trabajador con el DNI especificado.");
        }

        String id = "6a9d50b4-e064-4fa8-b3b7-9afc3573f451";
        Treballador treballadorById = service.getAllTrebaladorsById(id);
        if (treballadorById != null) {
            logger.info("Trabajador encontrado por ID:");
            logger.info(treballadorById);
        } else {
            logger.info("No se encontró ningún trabajador con el ID especificado.");
        }

        Encarregat nuevoTreballador = new Encarregat();
        nuevoTreballador.setNom("Nuevo");
        nuevoTreballador.setCognoms("Trabajador");
        nuevoTreballador.setDni("12345578A");
        nuevoTreballador.setDataNaixement(LocalDate.of(1990, 1, 1));
        nuevoTreballador.setSalariBase(2500.0);
        nuevoTreballador.setSouExtra(500);

        repository.createTreballador(nuevoTreballador);
    }
}
